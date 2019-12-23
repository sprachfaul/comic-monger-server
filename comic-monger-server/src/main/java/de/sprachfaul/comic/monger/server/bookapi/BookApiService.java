package de.sprachfaul.comic.monger.server.bookapi;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.BooksRequestInitializer;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volume.VolumeInfo;
import com.google.api.services.books.model.Volume.VolumeInfo.ImageLinks;
import com.google.api.services.books.model.Volumes;

import de.sprachfaul.comic.monger.server.model.Comic;

@Component
public class BookApiService {

	private static Logger log = LoggerFactory.getLogger(BookApiService.class);

	private static final String APPLICATION_NAME = "Comic-Monger";

	// Buildin No Cover Image
	private static final String NO_COVER_URL = "assets/img/nocover.png";

	public List<Comic> findByISBN(String isbn) throws BookApiException {
		List<Comic> results = new ArrayList<Comic>();
		
		Volumes volumes = findVolumesByISBN(isbn);
		log.info("query for isbn {} in bookapi. Found {} volumes.", isbn, volumes.getTotalItems());
		
		if (volumes.getTotalItems() == 0)
			return results;
		
		for (Volume volume : volumes.getItems()) {
			
			Comic result = transformVolumeToComic(isbn, volume);
			results.add(result);
		}

		return results;
	}

	protected Comic transformVolumeToComic(String isbn, Volume volume) {
		Comic result = new Comic();
		VolumeInfo volumeInfo = volume.getVolumeInfo();
		result.setTitel(volumeInfo.getTitle());
		result.setInhaltsangabe(StringUtils.abbreviateMiddle(volumeInfo.getDescription(), "..", 200));
		result.setIsbn(isbn);
		result.setReleaseDatum(volumeInfo.getPublishedDate());
		ImageLinks imageLinks = volumeInfo.getImageLinks();
		String coverUrl = NO_COVER_URL;
		if (imageLinks != null) {
			coverUrl = imageLinks.getThumbnail();
		}
		result.setCoverUrl(coverUrl);
		return result;
	}

	private Volumes findVolumesByISBN(String isbn) throws BookApiException {
		try {
			JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
			Books books = new Books.Builder(GoogleNetHttpTransport.newTrustedTransport(), jsonFactory, null)
			        .setApplicationName(APPLICATION_NAME)
			        .setGoogleClientRequestInitializer(new BooksRequestInitializer())
			        .build();
			
			String query = "isbn:" + isbn;
			Volumes volumes = books.volumes().list(query).execute();
			return volumes;
		} catch (Exception e) {
			throw new BookApiException("Cannot query for isbn [" + isbn + "]", e);
		}
	}
}

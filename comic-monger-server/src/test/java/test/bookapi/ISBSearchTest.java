package test.bookapi;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.BooksRequestInitializer;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumes;

public class ISBSearchTest {

	private static final String APPLICATION_NAME = "Comic-Monger";

	static public String ISBN_QUERY(String isbn) {
		return "isbn:" + isbn;
	}


	/**
	 * see https://github.com/google/google-api-java-client-samples/blob/master/books-cmdline-sample/src/main/java/com/google/api/services/samples/books/cmdline/BooksSample.java
	 */
	@Test
	public void spiderManDeadpool4() throws Exception {
		
		JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
		Books books = new Books.Builder(GoogleNetHttpTransport.newTrustedTransport(), jsonFactory, null)
				.setApplicationName(APPLICATION_NAME)
				.setGoogleClientRequestInitializer(new BooksRequestInitializer())
				.build();
		String isbn = "3736738471";
		Volumes volumes = books.volumes().list(ISBN_QUERY(isbn)).execute();

		System.out.println(volumes.toPrettyString());
		assertThat(volumes.getTotalItems(), is(1));
		List<Volume> items = volumes.getItems();
		assertThat(items, hasSize(1));
		Volume item = items.get(0);
		
		assertThat(item.getVolumeInfo().getTitle(), is("Spider-Man/Deadpool 4 - Jagd auf Slapstick"));
		assertThat(item.getVolumeInfo().getDescription(), containsString("Eine Serie, zwei Fanlieblinge!"));
		assertThat(item.getVolumeInfo().getIndustryIdentifiers(), hasSize(2));
		// ISBN_13 9783736738478
		// ISBN_10 3736738471
		assertThat(item.getVolumeInfo().getPublishedDate(), is("2018-05-15"));
		assertThat(item.getVolumeInfo().getImageLinks().getSmallThumbnail(), containsString("http://books.google.com/books/content?id=iu1VDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api"));
		assertThat(item.getVolumeInfo().getImageLinks().getThumbnail(), containsString("http://books.google.com/books/content?id=iu1VDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"));
		// Untertitel
		// Preis
	}
}

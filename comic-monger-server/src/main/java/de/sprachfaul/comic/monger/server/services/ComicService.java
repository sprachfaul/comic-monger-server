package de.sprachfaul.comic.monger.server.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import de.sprachfaul.comic.monger.server.bookapi.BookApiException;
import de.sprachfaul.comic.monger.server.bookapi.BookApiService;
import de.sprachfaul.comic.monger.server.jpa.ComicsRepository;
import de.sprachfaul.comic.monger.server.model.Comic;

@Service
public class ComicService {

	private static Logger log = LoggerFactory.getLogger(ComicService.class);
	
	@Autowired
	private BookApiService bookApiService;
	
	@Autowired
	private ComicsRepository comicsRepository;
	
	public List<Comic> findByISBNAndSearchAndAddThem(@RequestParam String isbn) throws BookApiException {
		
		List<Comic> storedComics = comicsRepository.findByIsbn(isbn);
		if (storedComics.size() > 0) {
			log.info("{} comics found in internal repository with isbn {}.", storedComics.size(), isbn);
			return storedComics;
		}
	
		log.info("no comics found in internal repository with isbn {}.", isbn);
		List<Comic> bookApiComics = bookApiService.findByISBN(isbn);
		if (bookApiComics.size() > 0) {
			log.info("{} comics found in bookapi - adding them to internal repository with isbn {}.", bookApiComics.size(), isbn);
			comicsRepository.saveAll(bookApiComics);
		}
		
		return bookApiComics;
	}
}

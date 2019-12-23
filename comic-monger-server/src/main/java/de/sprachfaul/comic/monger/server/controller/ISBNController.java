package de.sprachfaul.comic.monger.server.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.sprachfaul.comic.monger.server.bookapi.BookApiException;
import de.sprachfaul.comic.monger.server.model.Comic;
import de.sprachfaul.comic.monger.server.services.ComicService;

@RestController
public class ISBNController {

	private static Logger log = LoggerFactory.getLogger(ISBNController.class);
	
	@Autowired
	private ComicService comicService;
	
	@RequestMapping("/isbn")
	public List<Comic> findByISBNAndSearchAndAddThem(@RequestParam String isbn) throws BookApiException {
		return comicService.findByISBNAndSearchAndAddThem(isbn);
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="see server log")
	@ExceptionHandler(Exception.class)
	public void conflict(Exception error) {
		log.warn("cannot process isbn endpoint.", error);
	}
}

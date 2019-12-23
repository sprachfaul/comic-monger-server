package de.sprachfaul.comic.monger.server;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import de.sprachfaul.comic.monger.server.jpa.ComicsRepository;
import de.sprachfaul.comic.monger.server.model.Comic;
import de.sprachfaul.comic.monger.server.services.ComicService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK, classes = ComicMongerApplication.class)
public class ComicServiceTest {

	private static final String TEST_ISBN = "3736738471";
	@Autowired
	ComicService comicService;
	
	@Autowired
	ComicsRepository comics;

	@Before
	public void cleanUpTestIsbnInRepository() throws Exception {
		List<Comic> before = comics.findByIsbn(TEST_ISBN);
		comics.deleteAll(before);
	}
	
	@Test
	public void getOrCreateByIsbn() throws Exception {
		assertThat("comic with isb should not exist in repository.", comics.findByIsbn(TEST_ISBN), hasSize(0));

		List<Comic> myComics = comicService.findByISBNAndSearchAndAddThem(TEST_ISBN);
		
		assertThat("comic should be imported by book api", myComics, hasSize(1));
		
		assertThat("comic should be inserted to repository.", comics.findByIsbn(TEST_ISBN), hasSize(1));
	}
}

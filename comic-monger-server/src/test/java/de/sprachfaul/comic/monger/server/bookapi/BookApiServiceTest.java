package de.sprachfaul.comic.monger.server.bookapi;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import de.sprachfaul.comic.monger.server.model.Comic;

/**
 * Es wird ausschliesslich der BookApiService getestet (ohne App drumrum).
 */
@RunWith(SpringRunner.class)
@Import(BookApiService.class)
public class BookApiServiceTest {

	@Autowired BookApiService bookApiService;
	
	@Test
	public void checkNoThumbnail() throws Exception {
		String isbn = "9783834334091";
		
		List<Comic> comics = bookApiService.findByISBN(isbn);
		assertThat(comics, hasSize(1));
		Comic comic = comics.get(0);
		
		assertThat("kein Cover => default Image", comic.getCoverUrl(), containsString("nocover.png"));
	}
}

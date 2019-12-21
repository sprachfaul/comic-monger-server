package de.sprachfaul.comic.monger.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import de.sprachfaul.comic.monger.server.jpa.ComicsRepository;
import de.sprachfaul.comic.monger.server.model.Comic;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT, classes = ComicMongerApplication.class)
public class JPATest {

    @Autowired
    ComicsRepository comicsRepo;
    
    @Test
    public void checkJPA() throws Exception {
        Comic entity = new Comic();
        entity.setIsbn("foobar");
        entity.setTitel("Deadpool KK");
        entity.setCoverUrl("assets/img/deadpool-killerkollektion-1.jpg");
        comicsRepo.save(entity);
        
        Iterable<Comic> all = comicsRepo.findAll();
        all.forEach(item -> System.out.println(item));
    }
}

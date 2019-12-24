package de.sprachfaul.comic.monger.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import de.sprachfaul.comic.monger.server.controller.ControllerConfig;
import de.sprachfaul.comic.monger.server.controller.SpringDataRepositoryRestMvcConfiguration;
import de.sprachfaul.comic.monger.server.jpa.JPAConfig;
import de.sprachfaul.comic.monger.server.services.ComicService;

@SpringBootApplication
@Import({ControllerConfig.class, SpringDataRepositoryRestMvcConfiguration.class, JPAConfig.class, ComicService.class})
@EnableAutoConfiguration
public class ComicMongerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ComicMongerApplication.class, args);
    }
}

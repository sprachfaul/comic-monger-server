package de.sprachfaul.comic.monger.server.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import de.sprachfaul.comic.monger.server.model.Comic;

@Configuration
public class SpringDataRepositoryRestMvcConfiguration implements RepositoryRestConfigurer  {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Comic.class);
    }
}
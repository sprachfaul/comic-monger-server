package de.sprachfaul.comic.monger.server.jpa;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "de.sprachfaul.comic.monger.server.jpa")
public class JPAConfig {
}

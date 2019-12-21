package de.sprachfaul.comic.monger.server.jpa;

import org.springframework.data.repository.CrudRepository;

import de.sprachfaul.comic.monger.server.model.Comic;

public interface ComicsRepository extends CrudRepository<Comic, Long> {

}

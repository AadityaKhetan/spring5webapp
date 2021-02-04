package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domains.book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<book, Long> {

}

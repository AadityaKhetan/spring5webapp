package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domains.author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<author, Long> {
}

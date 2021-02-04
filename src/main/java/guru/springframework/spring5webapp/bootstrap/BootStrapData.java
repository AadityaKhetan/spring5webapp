package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domains.Publisher;
import guru.springframework.spring5webapp.domains.author;
import guru.springframework.spring5webapp.domains.book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        author eric = new author("Eric", "Evans");
        book ddd = new book("Domain Driver Design", "12121");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        author rod = new author("Rod", "Johnson");
        book noEJB = new book("J2EEE development without EJB", "343434");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher publisher = new Publisher("XYZ", "Berlin,Germany");
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("number of books : " + bookRepository.count());
        System.out.println("number of publishers : " + publisherRepository.count());
    }
}

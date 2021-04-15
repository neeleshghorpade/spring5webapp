package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) {
        Author author = new Author("nilesh", "Ghorpade");
        Book book = new Book("this is sample book", "1234569");
        author.getBooks().add(book);
        book.getAuthors().add(author);
        Publisher publisher = new Publisher();
        publisher.setName("londonpublish");
        publisher.setCity("london");
        publisher.setState("us");
        publisher.setZip("4254993");

        publisherRepository.save(publisher);

        book.setPublisher(publisher);
        publisher.getBooks().add(book);
        authorRepository.save(author);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        Author author1 = new Author("Jyoti", "Deshmukh");
        Book book1 = new Book("J2ee java book", "1354569");

        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        book1.setPublisher(publisher);
        publisher.getBooks().add(book1);
        authorRepository.save(author1);
        bookRepository.save(book1);
        publisherRepository.save(publisher);

        System.out.println("Started bootstrap");

        System.out.println("Books size : " + bookRepository.count());

    }
}

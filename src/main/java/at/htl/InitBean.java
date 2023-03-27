package at.htl;

import at.htl.control.AuthorRepository;
import at.htl.control.BookRepository;
import at.htl.entity.Author;
import at.htl.entity.Book;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;

public class InitBean {
    @Inject
    BookRepository bookRepository;
    @Inject
    AuthorRepository authorRepository;

    @Transactional
    void loadBooks(@Observes StartupEvent event) {
        Author a1 = new Author("Joanne", "Rowling");
        Author a2 = new Author("Suzanne", "Collins");
        Author a3 = new Author("Josephine", "Angelini");

/*
        authorRepository.persist(a1);
        authorRepository.persist(a2);
        authorRepository.persist(a3);
*/

        Book b1 = new Book(a1, "Harry Potter und der Stein der Weisen", "https://pictures.abebooks.com/isbn/9783551315120-uk.jpg");
        Book b2 = new Book(a1, "Harry Potter und der Feuerkelch", "http://bilder.buecher.de/produkte/44/44487/44487511z.jpg");
        Book b3 = new Book(a2, "Tribute von Panem Tödliche Spiele", "https://m.media-amazon.com/images/I/51Vn6qGi6bL._SY291_BO1,204,203,200_QL40_FMwebp_.jpg");
        Book b4 = new Book(a2, "Tribute von Panem Flammender Zorn", "https://m.media-amazon.com/images/I/51Cy1AnhfOL._SX218_BO1,204,203,200_QL40_FMwebp_.jpg");
        Book b5 = new Book(a3, "Göttlich verdammt", "https://m.media-amazon.com/images/I/51VYe9RFJ8S.jpg");
        Book b6 = new Book(a3, "Göttlich verloren", "https://m.media-amazon.com/images/I/41dVMsHNozL._SY264_BO1,204,203,200_QL40_ML2_.jpg");

        bookRepository.persist(b1);
        bookRepository.persist(b2);
        bookRepository.persist(b3);
        bookRepository.persist(b4);
        bookRepository.persist(b5);
        bookRepository.persist(b6);
    }
}

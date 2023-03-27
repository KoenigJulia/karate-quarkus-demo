package at.htl.control;

import at.htl.entity.Book;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class BookRepository implements PanacheRepository<Book> {
    @Transactional
    @Override
    public void persist(Book book) {
        PanacheRepository.super.persist(book);
    }
}

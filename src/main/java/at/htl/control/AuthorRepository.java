package at.htl.control;

import at.htl.entity.Author;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class AuthorRepository implements PanacheRepository<Author> {

    @Transactional
    @Override
    public void persist(Author author) {
        PanacheRepository.super.persist(author);
    }
}

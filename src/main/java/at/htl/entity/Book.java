package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "L_BOOK")
public class Book extends PanacheEntityBase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    public Author author;

    public String title;
    public String imageUrl;

    public Book() {
    }

    public Book(Author author, String title, String imageUrl) {
        this.author = author;
        this.title = title;
        this.imageUrl = imageUrl;
    }
}

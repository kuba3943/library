package domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity

@Table (name = "author")
public class Author {


    @Id
    @Column (name = "id_author")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "birth_place")
    private String birthPlace;

    @OneToMany(mappedBy = "authorId", fetch = FetchType.LAZY)
    private Set<Book> books = new HashSet<>();

    public Author( String firstName, String lastName, String birthPlace) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthPlace = birthPlace;
    }

    public void addBooks(Book book){
        books.add(book);
        book.setAuthor(this);
    }
}

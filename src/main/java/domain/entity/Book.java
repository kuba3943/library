package domain.entity;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity

@Table(name ="book")
public class Book {

    @Id
    @Column (name = "id_book")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "borrow")
   private byte borrow;

    @Column (name = "category")
    @Enumerated (EnumType.STRING)
    private Category category;

    @Column (name = "isbn")
    private String isbn;

    @Column (name = "pages")
    private int pages;

    @Column (name = "release_date")
    private java.sql.Date releaseDate;

    @Size(min=5, message = "Summary must be longer")
    @Column (name = "summary")
    private String summary;

    @Size(min = 2, message = "Title must be longer than one sign")
    @Column (name = "title")
    private String title;

    @ManyToOne()
    @JoinColumn (name = "author_id")
    private Author authorId;

    @OneToMany(mappedBy = "bookId", fetch = FetchType.LAZY)

    private Set<Borrow> borrows = new HashSet<>();

    public Book(byte borrow, Category category, String isbn, int pages, Date releaseDate, String summary, String title) {
        this.id = id;
        this.borrow = borrow;
        this.category = category;
        this.isbn = isbn;
        this.pages = pages;
        this.releaseDate = releaseDate;
        this.summary = summary;
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.authorId = author;
    }


    public void addBorrows(Borrow borrow){
        borrows.add(borrow);
        borrow.setBook(this);
    }
}

package domain.entity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity

@Table(name ="book")
public class Book {

    @Id
    @Column (name = "id_book")
    private int id;

    @Column (name = "borrow")
   private byte borrow;

    @Column (name = "category")
    private String category;

    @Column (name = "isbn")
    private String isbn;

    @Column (name = "pages")
    private int pages;

    @Column (name = "release_date")
    private java.sql.Date releaseDate;

    @Column (name = "summary")
    private String summary;

    @Column (name = "title")
    private String title;

    @Column (name = "author_id")
    private int authorId;

}

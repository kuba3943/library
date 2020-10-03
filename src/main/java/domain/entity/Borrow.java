package domain.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity

@Table (name = "borrow")
public class Borrow {

    @Id
    @Column(name = "id_borrow")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn (name = "book_id")
    private Book bookId;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn (name = "borrower_id")
    private Borrower borrowerId;

    @Column (name = "rental_date")
    private java.sql.Date rentalDate;

    public void setBook(Book book) {
        this.bookId = book;
    }

    public void setBorrower(Borrower borrower) {
        this.borrowerId = borrower;
    }

    public Borrow(Date rentalDate) {
        this.id = id;
        this.rentalDate = rentalDate;
    }
}

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

@Table (name = " borrow")
public class Borrow {

    @Id
    @Column(name = "id_borrow")
    private int id;

    @Column (name = "book_id")
    private int bookId;

    @Column (name = "borrower_id")
    private int borrowerId;

    @Column (name = "rentalDate")
    private java.sql.Date rentalDate;
}

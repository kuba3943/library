package domain.dto;

import domain.entity.Book;
import domain.entity.Borrower;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BorrowDTO {

    private String bookTitle;
    private String borrowerLastName;
    private java.sql.Date rentalDate;

}

package domain.dto;

import domain.entity.Author;
import domain.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BookDTO {

    private byte borrow;
    private Category category;
    private String isbn;
    private int pages;
    private java.sql.Date releaseDate;
    private String summary;
    private String title;
    private String authorLastName;
    private String authorFirstName;
}

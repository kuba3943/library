package persistance;

import domain.entity.Book;
import domain.entity.Category;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AppLauncher {

    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();

        Book book = new Book();
        book.setTitle("kk");
        book.setBorrow((byte)1);
        book.setCategory(Category.CLASSIC);
        bookRepository.create(book);

        bookRepository.findAll();
    }
}

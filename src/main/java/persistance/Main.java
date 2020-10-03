package persistance;

import domain.entity.Author;
import domain.entity.Book;
import domain.entity.Category;

import java.sql.Date;

public class Main {


    private persistance.Connection connection;


    public Main(Connection connection) {
        this.connection = connection;
    }

    public void close() {
        Connection.entityManagerFactory.close();
    }

    public static void main(String[] args) {
        persistance.Connection aa = Connection.getInstance();
        Main main = new Main(aa);
        try {
            Author a = new Author("iogfhu", "oifghfu", "hfghhk");
            Author b = new Author("iogddfhu", "oifddghfu", "hfgddhhk");
            Book book1 = new Book((byte) 1, Category.CLASSIC, "99", 90, Date.valueOf("2001-01-01"), "987", "iy");

            AuthorRepository.addAuthor(a);
            AuthorRepository.addAuthor(b);

            BookRepository.addBook(book1,a);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            main.close();
        }
    }
}

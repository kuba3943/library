package persistance;

import domain.entity.Author;
import domain.entity.Book;

import javax.persistence.EntityManager;

public class BookRepository {

    public static void addBook(Book book, Author author) {
        EntityManager entityManager = null;
        entityManager = Connection.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        book.setAuthor(author);
        entityManager.getTransaction().commit();


    }

}

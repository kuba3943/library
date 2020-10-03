package persistance;

import domain.entity.Author;
import domain.entity.Borrower;
import domain.entity.BorrowerDetails;

import javax.persistence.EntityManager;

public class AuthorRepository {

    public static void addAuthor(Author author) {
        EntityManager entityManager = null;
            entityManager = Connection.entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(author);
            entityManager.getTransaction().commit();

        }
    }


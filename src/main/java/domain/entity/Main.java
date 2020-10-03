package domain.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;

public class Main {

    private EntityManagerFactory entityManagerFactory;

    public Main() {
        entityManagerFactory = Persistence.createEntityManagerFactory("domain.entity");
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void close() {
        entityManagerFactory.close();
    }

    private void oneToOne() {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Borrower borrower1 = new Borrower("abcd", "abcd");
            BorrowerDetails details1 = new BorrowerDetails("Poznań", "jj@jjg.pl", "9874597" );

            entityManager.persist(borrower1);
            entityManager.persist(details1);

            borrower1.setBorrowerDetails(details1);
            entityManager.getTransaction().commit();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void OneToMany() {

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Book book1 = new Book((byte) 1,Category.CLASSIC, "99", 90, Date.valueOf("2001-01-01"), "987", "iy");
            Book book2 = new Book((byte) 1,Category.CRIME, "969", 960, Date.valueOf("2006-01-01"), "9867", "iy6");

            Author author1 = new Author("iou", "oiu", "hhk");

            Borrower borrower1 = new Borrower("abcd", "abcd");
            BorrowerDetails details1 = new BorrowerDetails("Poznań", "jj@jjg.pl", "9874597" );

            Borrow borrow1 = new Borrow(Date.valueOf("2006-01-01"));
            Borrow borrow2 = new Borrow(Date.valueOf("2008-01-01"));

            entityManager.persist(borrower1);
            entityManager.persist(details1);
            entityManager.persist(book1);
            entityManager.persist(book2);
            entityManager.persist(author1);
            entityManager.persist(borrow1);
            entityManager.persist(borrow2);

            book1.addBorrows(borrow1);
            book2.addBorrows(borrow2);

            borrower1.addBorrows(borrow1);
            borrower1.addBorrows(borrow2);

            borrower1.setBorrowerDetails(details1);
            author1.addBooks(book1);
            author1.addBooks(book2);

            entityManager.getTransaction().commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }


    public void OneToMany2() {

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Book book1 = new Book((byte) 1,Category.CLASSIC, "99", 90, Date.valueOf("2001-01-01"), "987", "iy");
            Book book2 = new Book((byte) 1,Category.CLASSIC, "969", 960, Date.valueOf("2006-01-01"), "9867", "iy6");

            Author author1 = new Author("iou", "oiu", "hhk");


            entityManager.persist(book1);
            entityManager.persist(book2);

            entityManager.persist(author1);

            author1.addBooks(book1);
            author1.addBooks(book2);

            entityManager.getTransaction().commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        try {
            main.OneToMany();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            main.close();
        }
    }

}

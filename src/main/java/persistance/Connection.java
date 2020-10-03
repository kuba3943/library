package persistance;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {

    private static Connection instance;
    public static EntityManagerFactory entityManagerFactory;


    public static Connection getInstance() {
        if (instance == null) {
            instance = new Connection();
        }
        return instance;
    }

    private Connection() {
        entityManagerFactory = Persistence.createEntityManagerFactory("domain.entity");
    }
}

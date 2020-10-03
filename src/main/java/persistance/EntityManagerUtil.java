package persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    private static final EntityManager ENTITY_MANAGER;

    static {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("domain.entity");
        ENTITY_MANAGER = entityManagerFactory.createEntityManager();
    }

    public static EntityManager entityManager() {
        return ENTITY_MANAGER;
    }
}

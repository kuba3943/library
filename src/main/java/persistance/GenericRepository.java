package persistance;

import domain.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericRepository<T, K> {

    protected final EntityManager em;
    protected final Class<T> entityClass;
    private final EntityTransaction transaction;

    protected GenericRepository() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
        this.em = EntityManagerUtil.entityManager();
        this.transaction = em.getTransaction();
    }

    public void create(T entity) {
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    public T read(K id) {
        return em.find(entityClass, id);
    }

    public T update(T entity) {
        transaction.begin();
        em.merge(entity);
        transaction.commit();
        return entity;
    }

    public void delete(K id) {
        transaction.begin();
        T read = read(id);
        em.remove(read);
        transaction.commit();
    }

    public List<T> findAll(){

        TypedQuery<T> typedQuery = em.createQuery("select b from " + entityClass.getSimpleName() + " b", entityClass);
        List<T> listOfAll = typedQuery.getResultList();

        return listOfAll;
    }

}

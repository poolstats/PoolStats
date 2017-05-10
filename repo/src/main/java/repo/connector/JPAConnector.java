package repo.connector;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.persistence.*;

/**
 * Created by guillaimejanssen on 04/05/2017.
 *
 * @author guillaimejanssen
 */
public class JPAConnector {

    private static final String PERSISTENCE_UNIT_NAME = "PoolStatsDB";
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public JPAConnector() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        entityManager = entityManagerFactory.createEntityManager();
    }

    /**
     * @return the entityManager
     */
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    /**
     * Start a transaction with the entityManager
     */
    public void beginTransaction() {
        this.entityManager.getTransaction().begin();
    }

    /**
     * Persist a object with thi method
     *
     * @param object to persist
     */
    public void persist(Object object) {
        this.entityManager.persist(object);
    }

    /**
     * USe this to end a transaction with the entityManager
     */
    public void commitTransaction() {
        this.entityManager.getTransaction().commit();
    }

    /**
     * When done with the application, close the entityManager + Factory
     */
    public void closeEntityManager() {
        entityManager.close();
        entityManagerFactory.close();
    }
}

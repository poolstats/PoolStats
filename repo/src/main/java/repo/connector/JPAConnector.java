package repo.connector;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by guillaimejanssen on 04/05/2017.
 *
 * @author guillaimejanssen
 */
public class JPAConnector implements AutoCloseable {

    private static JPAConnector instance;

    private static final String PERSISTENCE_UNIT_NAME = "PoolStatsDB";
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    private JPAConnector() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    public static JPAConnector getInstance() {
        if (instance == null) {
            instance = new JPAConnector();
        }
        return instance;
    }

    /**
     * @return the entityManager
     */
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public void commitTransaction() {
        this.entityManager.getTransaction().commit();
        this.entityManager.getTransaction().begin();
    }

    /**
     * When done with the application, close the entityManager + Factory
     */
    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}

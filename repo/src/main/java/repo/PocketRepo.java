package repo;

import library.Pocket;
import repo.connector.JPAConnector;

/**
 * Created by Jandie on 2017-05-16.
 */
public class PocketRepo {

    private JPAConnector connector;

    public PocketRepo() {
        this.connector = JPAConnector.getInstance();
    }

    public Pocket createPocket(Pocket pocket) {
        connector.getEntityManager().getTransaction().begin();
        connector.getEntityManager().persist(pocket);

        connector.getEntityManager().getTransaction().commit();

        return pocket;
    }

    public Pocket updatePocket(Pocket pocket) {
        connector.getEntityManager().getTransaction().begin();
        connector.getEntityManager().persist(pocket);

        connector.getEntityManager().getTransaction().commit();

        return pocket;
    }

    public void removePocket(Pocket pocket) {
        connector.getEntityManager().getTransaction().begin();
        connector.getEntityManager().remove(pocket);

        connector.getEntityManager().getTransaction().commit();
    }
}

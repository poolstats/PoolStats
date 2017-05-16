package repo;

import library.Pocket;
import repo.connector.JPAConnector;

/**
 * Created by Jandie on 2017-05-16.
 */
public class PocketRepo {

    private JPAConnector connector;

    public PocketRepo() {
        this.connector = new JPAConnector();
    }

    public Pocket createPocket(Pocket pocket) {
        connector.getEntityManager().persist(pocket);

        connector.commitTransaction();

        return pocket;
    }

    public Pocket updatePocket(Pocket pocket) {
        connector.getEntityManager().persist(pocket);

        connector.commitTransaction();

        return pocket;
    }

    public void removePocket(Pocket pocket) {
        connector.getEntityManager().remove(pocket);

        connector.commitTransaction();
    }
}

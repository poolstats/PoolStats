package repo;

import library.Turn;
import repo.connector.JPAConnector;

/**
 * Created by Jandie on 2017-05-16.
 */
public class TurnRepo {

    private JPAConnector connector;

    public TurnRepo() {
        this.connector = new JPAConnector();
    }

    public Turn createTurn(Turn turn) {
        connector.getEntityManager().persist(turn);

        connector.commitTransaction();

        return turn;
    }

    public Turn updateTurn(Turn turn) {
        connector.getEntityManager().persist(turn);

        connector.commitTransaction();

        return turn;
    }

    public void removeTurn(Turn turn) {
        connector.getEntityManager().persist(turn);

        connector.commitTransaction();
    }
}

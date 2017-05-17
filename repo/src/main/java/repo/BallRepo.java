package repo;

import library.Ball;
import repo.connector.JPAConnector;

/**
 * Created by Jandie on 2017-05-16.
 */
public class BallRepo {
    private JPAConnector connector;

    public BallRepo() {
        this.connector = new JPAConnector();
    }

    public Ball createBall(Ball ball) {
        connector.getEntityManager().persist(ball);

        connector.commitTransaction();

        return ball;
    }

    public Ball updateBall(Ball ball) {
        connector.getEntityManager().persist(ball);

        connector.commitTransaction();

        return ball;
    }

    public void removeBall(Ball ball) {
        connector.getEntityManager().remove(ball);

        connector.commitTransaction();
    }
}

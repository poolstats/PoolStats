package repo;

import library.Ball;
import repo.connector.JPAConnector;

/**
 * Created by Jandie on 2017-05-16.
 */
public class BallRepo {
    private JPAConnector connector;

    public BallRepo() {
        this.connector = JPAConnector.getInstance();
    }

    public Ball createBall(Ball ball) {
        connector.getEntityManager().getTransaction().begin();
        connector.getEntityManager().persist(ball);

        connector.getEntityManager().getTransaction().commit();

        return ball;
    }

    public Ball updateBall(Ball ball) {
        connector.getEntityManager().getTransaction().begin();
        connector.getEntityManager().persist(ball);

        connector.getEntityManager().getTransaction().commit();

        return ball;
    }

    public void removeBall(Ball ball) {
        connector.getEntityManager().getTransaction().begin();
        connector.getEntityManager().remove(ball);

        connector.getEntityManager().getTransaction().commit();
    }
}

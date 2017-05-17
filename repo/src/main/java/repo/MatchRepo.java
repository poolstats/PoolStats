package repo;

import library.Match;
import repo.connector.JPAConnector;

/**
 * Created by Jandie on 2017-05-16.
 */
public class MatchRepo {
    private JPAConnector connector;

    public MatchRepo() {
        this.connector = new JPAConnector();
    }

    public Match createMatch(Match match) {
        connector.getEntityManager().getTransaction().begin();
        connector.getEntityManager().persist(match);

        connector.getEntityManager().getTransaction().commit();

        return match;
    }

    public Match updateMatch(Match match) {
        connector.getEntityManager().getTransaction().begin();
        connector.getEntityManager().persist(match);

        connector.getEntityManager().getTransaction().commit();

        return match;
    }

    public void removeMatch(Match match) {
        connector.getEntityManager().getTransaction().begin();
        connector.getEntityManager().remove(match);

        connector.getEntityManager().getTransaction().commit();
    }
}

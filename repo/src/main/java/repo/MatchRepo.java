package repo;

import library.Match;
import repo.connector.JPAConnector;

/**
 * Created by Jandie on 2017-05-16.
 */
public class MatchRepo {
    private JPAConnector connector;

    public MatchRepo() {
        this.connector = JPAConnector.getInstance();
    }

    public Match createMatch(Match match) {
        connector.getEntityManager().getTransaction().begin();
        connector.getEntityManager().persist(match);

        connector.getEntityManager().getTransaction().commit();

        return match;
    }
}

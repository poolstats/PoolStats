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
        connector.getEntityManager().persist(match);

        connector.commitTransaction();

        return match;
    }

    public Match updateMatch(Match match) {
        connector.getEntityManager().persist(match);

        connector.commitTransaction();

        return match;
    }

    public void removeMatch(Match match) {
        connector.getEntityManager().remove(match);

        connector.commitTransaction();
    }
}

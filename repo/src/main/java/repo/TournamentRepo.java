package repo;

import library.Tournament;
import repo.connector.JPAConnector;

/**
 * Created by Jandie on 2017-05-16.
 */
public class TournamentRepo {
    private JPAConnector connector;

    public TournamentRepo() {
        this.connector = JPAConnector.getInstance();
    }

    public Tournament createTournament(Tournament tournament) {
        connector.getEntityManager().persist(tournament);

        connector.getEntityManager().getTransaction().commit();

        return tournament;
    }
}

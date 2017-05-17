package repo;

import library.Tournament;
import repo.connector.JPAConnector;

/**
 * Created by Jandie on 2017-05-16.
 */
public class TournamentRepo {
    private JPAConnector connector;

    public TournamentRepo() {
        this.connector = new JPAConnector();
    }

    public Tournament createTournament(Tournament tournament) {
        connector.getEntityManager().persist(tournament);

        connector.commitTransaction();

        return tournament;
    }

    public Tournament updateTournament(Tournament tournament) {
        connector.getEntityManager().persist(tournament);

        connector.commitTransaction();

        return tournament;
    }

    public void removeTournament(Tournament tournament) {
        connector.getEntityManager().persist(tournament);

        connector.commitTransaction();
    }
}

package repo;

import library.Team;
import repo.connector.JPAConnector;

/**
 * Created by Jandie on 2017-05-16.
 */
public class TeamRepo {
    private JPAConnector connector;

    public TeamRepo() {
        this.connector = new JPAConnector();
    }

    public Team createTeam(Team team) {
        connector.getEntityManager().persist(team);

        connector.commitTransaction();

        return team;
    }

    public Team updateTeam(Team team) {
        connector.getEntityManager().persist(team);

        connector.commitTransaction();

        return team;
    }

    public void removeTeam(Team team) {
        connector.getEntityManager().remove(team);

        connector.commitTransaction();
    }
}

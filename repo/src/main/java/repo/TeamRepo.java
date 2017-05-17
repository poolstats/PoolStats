package repo;

import library.Team;
import library.User;
import repo.connector.JPAConnector;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Jandie on 2017-05-16.
 */
public class TeamRepo {
    private JPAConnector connector;

    public TeamRepo() {
        this.connector = new JPAConnector();
    }

    public void addTeam(Team team) {
        connector.getEntityManager().getTransaction().begin();

        connector.getEntityManager().persist(team);

        connector.getEntityManager().getTransaction().commit();
    }

    public void addUserToTeam(Team team, User user) {
        connector.getEntityManager().getTransaction().begin();

        connector.getEntityManager().persist(team);
        connector.getEntityManager().persist(user);

        connector.getEntityManager().getTransaction().commit();
    }

    public Team getTeamByName(String teamName) {
        Query query = (Query) connector.getEntityManager().createQuery("SELECT t FROM Team t WHERE t.name = :teamname ");
        query.setParameter("teamname", teamName);
        return (Team) query.getSingleResult();
    }

    public Team getTeamByUser(User user) {
        Query query = (Query) connector.getEntityManager().createQuery("SELECT u FROM User u WHERE u.id = :id");
        query.setParameter("id", user.getId());
        User u = (User) query.getSingleResult();
        return u.getTeam();
    }

    public void removeUserFromTeam(Team t, User user) {
        t.getPlayers().remove(user);
        connector.getEntityManager().getTransaction().begin();

        connector.getEntityManager().persist(t);

        user.setTeam(null);
        connector.getEntityManager().persist(user);

        connector.getEntityManager().getTransaction().commit();
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

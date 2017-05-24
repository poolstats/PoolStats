package repo;

import library.Team;
import library.User;
import repo.connector.JPAConnector;

import javax.persistence.Query;

/**
 * Created by Jandie on 2017-05-16.
 */
public class TeamRepo {
    private JPAConnector connector;

    public TeamRepo() {
        this.connector = JPAConnector.getInstance();
    }

    public Team getTeamByName(String teamName) {
        Query query = (Query) connector.getEntityManager().createQuery("SELECT t FROM Team t WHERE t.name = :teamname ");
        query.setParameter("teamname", teamName);
        return (Team) query.getSingleResult();
    }

    public Team getTeamByUser(User user) {
        Query query = (Query) connector.getEntityManager().createQuery("SELECT u FROM User u WHERE u.username = :username");
        query.setParameter("username", user.getUsername());
        User u = (User) query.getSingleResult();
        return u.getTeam();
    }
  
    public Team createTeam(Team team) {
        connector.getEntityManager().persist(team);

        connector.getEntityManager().getTransaction().commit();

        return team;
    }
}

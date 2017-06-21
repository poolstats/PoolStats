package repo;

import library.Player;
import library.Team;
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
        Query query = connector.getEntityManager().createQuery("SELECT t FROM Team t WHERE t.name = :teamname ");
        query.setParameter("teamname", teamName);
        return (Team) query.getSingleResult();
    }

    public Team getTeamByUser(Player player) {
        Query query = connector.getEntityManager().createQuery("SELECT u FROM User u WHERE u.username = :username");
        query.setParameter("username", player.getUsername());
        Player p = (Player) query.getSingleResult();
        return p.getTeam();
    }
  
    public Team createTeam(Team team) {
        connector.getEntityManager().getTransaction().begin();

        connector.getEntityManager().persist(team);
        connector.getEntityManager().getTransaction().commit();
        return team;
    }
}

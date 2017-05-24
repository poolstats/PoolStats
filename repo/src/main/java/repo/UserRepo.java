package repo;

import library.Player;
import repo.connector.JPAConnector;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;


/**
 * Created by Jandie on 2017-05-03.
 */
public class UserRepo {

    private JPAConnector connector;

    public UserRepo() {
        this.connector = JPAConnector.getInstance();
    }

    public Player getUser(String username) throws NoResultException {
        return connector.getEntityManager().find(Player.class, username);
    }

    public List<Player> searchUser(String username) {
        String search = "%" + username + "%";

        Query query = connector.getEntityManager()
                .createQuery("SELECT u FROM User u WHERE u.username LIKE :username");

        query.setParameter("username", search);

        return (List<Player>) query.getResultList();
    }

    public void addUser(Player player) {
        connector.getEntityManager().persist(player.getUserStats());
        connector.getEntityManager().persist(player);

        JPAConnector.getInstance().commitTransaction();
    }
}

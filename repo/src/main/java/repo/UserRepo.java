package repo;

import library.Jury;
import library.Player;
import library.User;
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

    public List<Player> getAllUsers() {
        Query q = connector.getEntityManager().createQuery(
                "SELECT u FROM User u");
        return (List<Player>) q.getResultList();
    }

    public User getUser(String username) throws NoResultException {
        return connector.getEntityManager().find(User.class, username);
    }

    public List<Player> searchUser(String username) {
        String search = "%" + username + "%";

        Query query = connector.getEntityManager()
                .createQuery("SELECT u FROM User u WHERE u.username LIKE :username");

        query.setParameter("username", search);

        return (List<Player>) query.getResultList();
    }

    public void addJury(Jury jury) {
        connector.getEntityManager().getTransaction().begin();
        connector.getEntityManager().persist(jury);
        connector.getEntityManager().getTransaction().commit();
    }
}

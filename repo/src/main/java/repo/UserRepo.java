package repo;

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

    public User getUser(String username) throws NoResultException {
        Query query = connector.getEntityManager().createQuery("select u from User as u where u.username = :username");
        query.setParameter("username", username);
        return (User) query.getSingleResult();
    }

    public List<User> searchUser(String username) {
        String search = "%" + username + "%";

        Query query = connector.getEntityManager()
                .createQuery("SELECT u FROM User u WHERE u.username LIKE :username");

        query.setParameter("username", search);

        return (List<User>) query.getResultList();
    }

    public void addUser(User user) {
        connector.getEntityManager().persist(user.getUserStats());
        connector.getEntityManager().persist(user);
    }
}

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
        return connector.getEntityManager().find(User.class, username);
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

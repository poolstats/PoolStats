package repo;

import library.User;
import library.UserStats;
import repo.connector.JPAConnector;

import javax.persistence.NoResultException;
import javax.persistence.Query;


/**
 * Created by Jandie on 2017-05-03.
 */
public class UserRepo {

    private JPAConnector connector;

    public UserRepo() {
        this.connector = new JPAConnector();
    }

    public User getUser(String username) throws NoResultException {
        Query query = connector.getEntityManager()
                .createQuery("SELECT u FROM User u WHERE u.username = :username");

        query.setParameter("username", username);

        User returnValue = (User) query.getSingleResult();

        return returnValue;
    }

    public void updateUser(User user) {
        connector.getEntityManager().persist(user);

        connector.commitTransaction();
    }

    public void addUser(String username) {
        UserStats userStats = new UserStats(0, 0, 0, 0, 0, 0, 0, 0);
        User user = new User(username, userStats);

        connector.getEntityManager().persist(userStats);
        connector.getEntityManager().persist(user);

        connector.commitTransaction();
    }

    public void deleteUser(String username) {
        Query query = connector.getEntityManager()
                .createQuery("SELECT u FROM User u WHERE u.username = :username");

        query.setParameter("username", username);
        User users = (User) query.getSingleResult();

        connector.getEntityManager().remove(users);
        connector.getEntityManager().remove(users.getUserStats());

        connector.commitTransaction();
    }
}

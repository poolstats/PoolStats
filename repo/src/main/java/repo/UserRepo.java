package repo;

import library.User;
import library.UserStats;
import logic.interfaces.IUser;
import repo.connector.JPAConnector;

import javax.persistence.NoResultException;
import javax.persistence.Query;


/**
 * Created by Jandie on 2017-05-03.
 */
public class UserRepo implements IUser {

    private JPAConnector connector;

    public UserRepo() {
        this.connector = new JPAConnector();
    }

    @Override
    public User getUser(String username) throws NoResultException {
        Query query = connector.getEntityManager()
                .createQuery("SELECT u FROM User u WHERE u.username = :username");
        query.setParameter("username", username);
        User returnValue = (User) query.getSingleResult();
        return returnValue;
    }

    @Override
    public void addUser(String username) {
        UserStats userStats = new UserStats(0, 0, 0, 0, 0, 0, 0, 0);
        connector.getEntityManager().persist(userStats);
        User user = new User(username, userStats);
        connector.getEntityManager().persist(user);
        connector.commitTransaction();
    }

    @Override
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

package logic;

import library.User;
import library.UserStats;
import repo.UserRepo;
import repo.connector.JPAConnector;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by Jandie on 2017-05-10.
 */
public class UserLogic {
    private UserRepo userRepo;

    public UserLogic() {
        userRepo = new UserRepo();
    }

    public User loginUser(String username) {

        try {
            return userRepo.getUser(username);
        } catch (NoResultException e) {

            UserStats userStats = new UserStats(0, 0, 0, 0, 0, 0, 0, 0);
            User user = new User(username, userStats);

            userRepo.addUser(user);
            JPAConnector.getInstance().commitTransaction();
            return user;
        }
    }

    public List<User> searchUser(String username) {
        return userRepo.searchUser(username);
    }
}

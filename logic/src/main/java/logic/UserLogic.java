package logic;

import library.User;
import library.UserStats;
import repo.UserRepo;

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
        User user = userRepo.getUser(username);

        if (user == null) {
            UserStats userStats = new UserStats(0, 0, 0, 0, 0, 0, 0, 0);
            user = new User(username, userStats);

            userRepo.addUser(user);

            return user;
        }

        return user;
    }

    public List<User> searchUser(String username) {
        return userRepo.searchUser(username);
    }
}

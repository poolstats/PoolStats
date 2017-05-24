package logic;

import library.Player;
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

    public Player loginUser(String username) {
        Player player = userRepo.getUser(username);

        if (player == null) {
            UserStats userStats = new UserStats(0, 0, 0, 0, 0, 0, 0, 0);
            player = new Player(username, userStats);

            userRepo.addUser(player);

            return player;
        }

        return player;
    }

    public List<Player> searchUser(String username) {
        return userRepo.searchUser(username);
    }
}

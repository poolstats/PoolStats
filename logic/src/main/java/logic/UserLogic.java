package logic;

import library.Jury;
import library.Player;
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

    public Jury loginUser
            (String username, String password) {
        Jury jury = (Jury) userRepo.getUser(username);

        if (jury == null) {
            jury = new Jury(username, password);

            userRepo.addJury(jury);

            return jury;
        }

        if (!jury.getPassword().equals(password)) {
            return null;
        }

        return jury;
    }

    public List<Player> searchUser(String username) {
        return userRepo.searchUser(username);
    }
}

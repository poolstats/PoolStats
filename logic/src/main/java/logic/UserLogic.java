package logic;

import library.User;
import repo.UserRepo;

import javax.persistence.NoResultException;

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
            userRepo.addUser(username);

            return userRepo.getUser(username);
        }
    }
}

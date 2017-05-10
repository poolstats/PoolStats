package logic;

import library.User;
import logic.interfaces.IUser;
import repo.UserRepo;

import javax.persistence.NoResultException;

/**
 * Created by Jandie on 2017-05-10.
 */
public class UserLogic implements IUser {
    private UserRepo userRepo;

    public UserLogic() {
        userRepo = new UserRepo();
    }

    @Override
    public User getUser(String username) throws NoResultException {
        return userRepo.getUser(username);
    }

    @Override
    public void addUser(String username) {
        userRepo.addUser(username);
    }

    @Override
    public void deleteUser(String username) {
        userRepo.deleteUser(username);
    }
}

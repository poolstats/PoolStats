package logic.interfaces;

import library.User;

import javax.persistence.NoResultException;

/**
 * Created by guillaimejanssen on 04/05/2017.
 */
public interface IUser {

    User getUser(String username) throws NoResultException;
    void addUser(String username);
    void deleteUser(String username);
}

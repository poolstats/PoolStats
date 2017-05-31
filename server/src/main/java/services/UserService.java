package services;

import library.User;
import logic.UserLogic;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by Jandie on 2017-05-31.
 */
@WebService
public class UserService {
    public User loginUser(@WebParam(name = "username") String username,
                          @WebParam(name = "password") String password) {
        UserLogic userLogic = new UserLogic();

        return userLogic.loginUser(username, password);
    }
}

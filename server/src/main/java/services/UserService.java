package services;

import library.Jury;
import library.Player;
import logic.UserLogic;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Jandie on 2017-05-31.
 */
@WebService
public class UserService {

    UserLogic userLogic;

    public UserService() {
        this.userLogic = new UserLogic();
    }

    public Jury loginUser(@WebParam(name = "username") String username,
                          @WebParam(name = "password") String password) {
        return userLogic.loginUser(username, password);
    }

    public List<Player> getAllPlayers() {
        return userLogic.getAllUsers();
    }
}

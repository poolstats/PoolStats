package services;

import library.Jury;
import logic.UserLogic;
import repo.utils.EncryptionUtil;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by Jandie on 2017-05-31.
 */
@WebService
public class UserService {
    public Jury loginUser(@WebParam(name = "username") String username,
                          @WebParam(name = "password") String password) {
        UserLogic userLogic = new UserLogic();

        Jury jury = userLogic.loginUser(username, password);

        if (jury != null) {
            jury.getUserStats().setBallsPotted(EncryptionUtil.encrypt(password, jury.getUserStats().getBallsPotted()));
            jury.getUserStats().setMatchesPlayed(EncryptionUtil.encrypt(password, jury.getUserStats().getMatchesPlayed()));
            jury.getUserStats().setMatchesWon(EncryptionUtil.encrypt(password, jury.getUserStats().getMatchesWon()));
            jury.getUserStats().setMatchesLost(EncryptionUtil.encrypt(password, jury.getUserStats().getMatchesLost()));
            jury.getUserStats().setTournamentsPlayed(EncryptionUtil.encrypt(password, jury.getUserStats().getTournamentsPlayed()));
            jury.getUserStats().setTournamentsWon(EncryptionUtil.encrypt(password, jury.getUserStats().getTournamentsWon()));
            jury.getUserStats().setTournamentsLost(EncryptionUtil.encrypt(password, jury.getUserStats().getTournamentsLost()));
            jury.getUserStats().setShots(EncryptionUtil.encrypt(password, jury.getUserStats().getShots()));
        }

        return userLogic.loginUser(username, password);
    }
}
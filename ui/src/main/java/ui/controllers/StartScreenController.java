package ui.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import repo.utils.EncryptionUtil;
import ui.Application;
import ui.SessionData;
import ui.zeep.Jury;
import ui.zeep.UserService;
import ui.zeep.UserServiceService;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by guillaimejanssen on 03/05/2017.
 *
 * @author guillaimejanssen
 */
public class StartScreenController implements Initializable {

    @FXML
    public JFXTextField usernameField;

    @FXML
    public JFXButton startButton;

    @FXML
    public JFXTextField passwordField;

    private Application application;

    public StartScreenController(Application application) {
        this.application = application;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameField.setStyle("-fx-text-fill: black; -fx-font-size: 18;");

        startButton.setOnAction(this::login);
    }

    public void login(ActionEvent event) {

        // If none username filled in: Send alert
        if (usernameField.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning");
            a.setHeaderText("No username!");
            a.setResizable(true);
            String content = "Please fill in a valid username";
            a.setContentText(content);
            a.showAndWait();

        } else {
            UserServiceService service = new UserServiceService();
            UserService port = service.getUserServicePort();

            Jury user = port.loginUser(usernameField.getText(), passwordField.getText());

            if (user != null) {
                user.getUserStats().setBallsPotted(EncryptionUtil.decrypt(passwordField.getText(), user.getUserStats().getBallsPotted()));
                user.getUserStats().setMatchesPlayed(EncryptionUtil.decrypt(passwordField.getText(), user.getUserStats().getMatchesPlayed()));
                user.getUserStats().setMatchesWon(EncryptionUtil.decrypt(passwordField.getText(), user.getUserStats().getMatchesWon()));
                user.getUserStats().setMatchesLost(EncryptionUtil.decrypt(passwordField.getText(), user.getUserStats().getMatchesLost()));
                user.getUserStats().setTournamentsPlayed(EncryptionUtil.decrypt(passwordField.getText(), user.getUserStats().getTournamentsPlayed()));
                user.getUserStats().setTournamentsWon(EncryptionUtil.decrypt(passwordField.getText(), user.getUserStats().getTournamentsWon()));
                user.getUserStats().setTournamentsLost(EncryptionUtil.decrypt(passwordField.getText(), user.getUserStats().getTournamentsLost()));
                user.getUserStats().setShots(EncryptionUtil.decrypt(passwordField.getText(), user.getUserStats().getShots()));
            }

            application.getSessionData().addData(SessionData.CURRENT_USER, user);

            try {
                if (user != null) {
                    application.loadMainScreen();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

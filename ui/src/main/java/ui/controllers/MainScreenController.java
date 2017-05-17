package ui.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import logic.TeamLogic;
import ui.Application;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by guillaimejanssen on 04/05/2017.
 */
public class MainScreenController implements Initializable {

    private Application application;
    private TeamLogic teamLogic;

    @FXML
    private JFXButton logoutButton;
    @FXML
    private ImageView createMatchImageView;

    public MainScreenController(Application application) {
        this.application = application;
        this.teamLogic = new TeamLogic();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logoutButton.setOnAction(this::handleLogoutAction);
        initializeTeam();
    }

    private void goToMatchScreen(ActionEvent actionEvent) {

    }

    private void handleLogoutAction(ActionEvent actionEvent) {
        try {
            application.clearSessionData();
            application.loadStartScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeTeam() {

    }
}


package ui.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import logic.TeamLogic;
import ui.Application;
import ui.SessionData;

import java.net.URL;
import java.util.Objects;
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
    private JFXButton teamConfirmButton;
    @FXML
    private JFXTextField teamNameField;

    public MainScreenController(Application application) {
        this.application = application;
        this.teamLogic = new TeamLogic();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logoutButton.setOnAction(this::handleLogoutAction);
        teamConfirmButton.setOnAction(this::handleConfirmTeamAction);
        initializeTeam();
    }

    private void handleConfirmTeamAction(ActionEvent actionEvent) {
        if(Objects.equals(teamConfirmButton.getText(), "OK")) {
            application.getSessionData().userTeam = teamLogic.addToTeam(teamNameField.getText(), application.getSessionData().currentUser);

            teamConfirmButton.setText("X");
            teamNameField.setDisable(true);

        } else if(Objects.equals(teamConfirmButton.getText(), "X")) {
            teamLogic.deleteFromTeam(application.getSessionData().userTeam, application.getSessionData().currentUser);
            application.getSessionData().userTeam = null;

            teamConfirmButton.setText("OK");
            teamNameField.setDisable(false);
        }
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
        application.getSessionData().userTeam = teamLogic.getTeamByUser(application.getSessionData().currentUser);

        if(application.getSessionData().userTeam != null) {
            teamNameField.setDisable(true);
            teamNameField.setText(application.getSessionData().userTeam.getName());
            teamConfirmButton.setText("X");
        }
    }
}


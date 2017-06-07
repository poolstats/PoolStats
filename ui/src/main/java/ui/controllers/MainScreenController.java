package ui.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import ui.Application;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by guillaimejanssen on 04/05/2017.
 */
public class MainScreenController implements Initializable {

    private Application application;

    @FXML
    private JFXButton logoutButton;
    @FXML
    private ImageView createMatchImageView;
    @FXML
    private ImageView teamOverviewImageView;

    public MainScreenController(Application application) {
        this.application = application;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logoutButton.setOnAction(this::handleLogoutAction);
        teamOverviewImageView.setOnMouseClicked(this::goToTeamScreen);
        initializeTeam();
    }

    private void goToMatchScreen(ActionEvent actionEvent) {

    }

    private void goToTeamScreen(MouseEvent mouseEvent) {
        try {
            application.loadTeamScreen();
        } catch (Exception e) {
            e.printStackTrace();
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

    }
}


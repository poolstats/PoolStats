package ui.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import ui.Application;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Jandie on 2017-05-17.
 */
public class TeamScreenController implements Initializable {

    private Application application;

    @FXML
    private JFXListView teamListView;
    @FXML
    private JFXListView playerListView;
    @FXML
    private JFXTextField teamNameTextField;
    @FXML
    private JFXTextField userNameTextField;
    @FXML
    private JFXButton createTeamButton;
    @FXML
    private JFXButton removeUserFromTeamButton;
    @FXML
    private JFXButton addUserToTeamButton;

    List<String> playerNames;
    List<String> teams;
    HashMap<String, String> teamsWithUsers;

    public TeamScreenController(Application application) {
        this.application = application;
        this.playerNames = new ArrayList<>();
        this.teams = new ArrayList<>();
        this.teamsWithUsers = new HashMap<>();

        //this.playerListView.setItems(FXCollections.observableArrayList(this.playerNames));
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createTeamButton.setOnAction(this::addTeamAction);
        addUserToTeamButton.setOnAction(this::addUserAction);
    }

    private void addUserAction(ActionEvent actionEvent) {
        if (userNameTextField.getText().isEmpty()) {
            sendAlert("Fill valid user",
                    "Please fill in a valid name for the user");
        } else {
            this.playerNames.add(userNameTextField.getText());
            this.playerListView.refresh();
        }
    }

    private void addTeamAction(ActionEvent actionEvent) {
        if (playerNames.size() == 0 && teamsWithUsers.containsKey(teamNameTextField.getText())) {
            sendAlert("Cannot add team!",
                    "There is already a team with this name or there are no players added to the team");
        } else {
            //TODO Send team to server
        }
    }

    private void sendAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("Warning");
        a.setHeaderText(title);
        a.setResizable(true);
        String content = message;
        a.setContentText(content);
        a.showAndWait();
    }
}

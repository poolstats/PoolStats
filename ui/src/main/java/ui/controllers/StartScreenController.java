package ui.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import repo.UserRepo;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameField.setStyle("-fx-text-fill: white; -fx-font-size: 18;");
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                // If none username filled in: Send alert
                if(usernameField.getText().isEmpty()){
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setTitle("Warning");
                    a.setHeaderText("No username!");
                    a.setResizable(true);
                    String content = "Please fill in a valid username";
                    a.setContentText(content);
                    a.showAndWait();
                } else {
                    UserRepo userRepo = new UserRepo();
                    userRepo.addUser(usernameField.getText());
                }
            }
        });
    }
}

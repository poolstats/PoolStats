package ui.controllers;

import javafx.fxml.Initializable;
import ui.Application;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by guillaimejanssen on 04/05/2017.
 */
public class MainScreenController implements Initializable {

    private Application application;

    public MainScreenController(Application application) {
        this.application = application;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

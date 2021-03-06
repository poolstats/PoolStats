package ui.controllers;

import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ui.Application;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Jandie on 2017-05-17.
 */
public class TeamScreenController implements Initializable {

    private Application application;

    @FXML
    private JFXListView teamsListView;

    public TeamScreenController(Application application) {
        this.application = application;
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

    }

    private void loadTeamsInSession() {

    }
}

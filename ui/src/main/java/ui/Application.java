package ui;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import ui.controllers.MainScreenController;
import ui.controllers.StartScreenController;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * Created by guillaimejanssen on 03/05/2017.
 */
public class Application extends javafx.application.Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Stage primaryStage;
    private SessionData sessionData;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.sessionData = new SessionData();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/StartScreen.fxml"));
        StartScreenController controller = new StartScreenController(this);
        fxmlLoader.setController(controller);
        setStage(fxmlLoader.load());
    }

    public void loadMainScreen() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MainScreen.fxml"));
        MainScreenController controller = new MainScreenController(this);
        fxmlLoader.setController(controller);
        setStage(fxmlLoader.load());
    }

    public SessionData getSessionData() {
        return this.sessionData;
    }

    private void setStage(Parent root) {
        Scene scene = new Scene(root);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Poolstats");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Center it
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
    }
}

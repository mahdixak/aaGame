package aagame.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;

public class MainMenu extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL url = MainMenu.class.getResource("/Fxml/mainMenu.fxml");
        GridPane gridPane = FXMLLoader.load(url);
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }
}

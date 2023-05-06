package aagame.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
public class LoginMenu extends Application {
    public static Stage stage;
    public static void main(String[] args) {
        System.out.println("slam pedasag!");
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        LoginMenu.stage = stage;
        URL url = LoginMenu.class.getResource("/Fxml/loginMenu.fxml");
        BorderPane borderPane = FXMLLoader.load(url);
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }
}

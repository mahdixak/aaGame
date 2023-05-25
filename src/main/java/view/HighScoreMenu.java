package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.GameStage;

public class HighScoreMenu extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = FXMLLoader.load(HighScoreMenu.class.getResource("/FXML/highScoreMenu.fxml"));
        Scene scene = new Scene(borderPane);
        GameStage.setGameStage(stage);
        GameStage.setStageScene(scene);
        GameStage.getGameStage().show();
    }
}

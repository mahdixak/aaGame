package view;

import controller.SinglePlayerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.GameStage;
import model.SinglePlayerGame;

public class SinglePlayerModePage extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        String playerName = null;
        Pane gamePane = FXMLLoader.load(SinglePlayerGame.class.getResource("/FXML/singlePlayerPane.fxml"));
        //TODO: most add the player name to create panel
        new SinglePlayerController("mahdi").createPanel(gamePane);
        Scene scene = new Scene(gamePane);
        GameStage.setGameStage(primaryStage);
        GameStage.setStageScene(scene);
        GameStage.getGameStage().show();
    }
}

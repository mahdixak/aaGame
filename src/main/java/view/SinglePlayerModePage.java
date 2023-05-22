package view;

import controller.SinglePlayerController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.GameStage;

import java.io.IOException;

import static view.Controllers.singlePlayerController;

public class SinglePlayerModePage extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane gamePane = FXMLLoader.load(SinglePlayerModePage.class.getResource("/FXML/singlePlayerPane.fxml"));
        singlePlayerController.createPanel(gamePane);
        Scene scene = new Scene(gamePane);
        scene.setFill(Color.MINTCREAM);
        GameStage.setGameStage(primaryStage);
        GameStage.setStageScene(scene);
        GameStage.getGameStage().show();
        singlePlayerController.setBall(gamePane);
    }

    public void setName(String playerName) {
        singlePlayerController.setCurrentPlayer(playerName);
        System.out.println(singlePlayerController);
    }
}

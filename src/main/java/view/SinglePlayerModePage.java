package view;

import controller.SinglePlayerController;
import controller.UserProfileController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.GameStage;
import static view.Controllers.*;


import java.io.IOException;

import static view.Controllers.singlePlayerController;
import static view.Controllers.userProfileController;

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
        sidebarNodes(gamePane);
        HBox hBox = new HBox();
        Text remainingBalls = new Text(360, 50, singlePlayerController.getCurrentPlayer()+ "'s remaining balls : "+20);
        remainingBalls.setFill(Color.AQUA);
        ProgressBar progressBar = new ProgressBar();
        createHbox(hBox,remainingBalls,progressBar);
        gamePane.getChildren().add(hBox);
    }

    private void sidebarNodes(Pane pane) {
        VBox sideBar = new VBox();
        sideBar.setLayoutX(720);
        sideBar.setLayoutY(400);
        sideBar.setSpacing(20);
        sideBar.setAlignment(Pos.CENTER_RIGHT);
        Button backToMainMenu = new Button();
        backToMainMenu.setText("back");
        backToMainMenu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    new UserMenu().start(GameStage.getGameStage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        sideBar.getChildren().add(backToMainMenu);
        Button exitFromGame = new Button();
        exitFromGame.setText("exit");
        exitFromGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("exiting from game");
                System.exit(0);
            }
        });
        sideBar.getChildren().add(exitFromGame);
        pane.getChildren().add(sideBar);
    }

    private void createHbox(HBox hBox, Text remainingBalls, ProgressBar progressBar) {
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(remainingBalls);
        hBox.setSpacing(50);
        hBox.getChildren().add(progressBar);
    }

}

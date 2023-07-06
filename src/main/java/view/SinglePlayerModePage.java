package view;

import controller.SinglePlayerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.GameStage;
import view.userMenu.UserMenu;

public class SinglePlayerModePage extends Application {
    SinglePlayerController singlePlayerController = new SinglePlayerController(UserMenu.getUsername());
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane gamePane = FXMLLoader.load(SinglePlayerModePage.class.getResource("/FXML/singlePlayerPane.fxml"));
        singlePlayerController.setGamePane(gamePane);
        singlePlayerController.createPanel();
        Scene scene = new Scene(gamePane);
        scene.setUserAgentStylesheet(GameStage.getCurrentTheme().getTheme());
        scene.setFill(Color.MINTCREAM);
        GameStage.setGameStage(primaryStage);
        GameStage.setStageScene(scene);
        GameStage.getGameStage().show();
        singlePlayerController.setBall();
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
        sideBar.setLayoutX(830);
        sideBar.setLayoutY(500);
        sideBar.setSpacing(20);
        sideBar.setAlignment(Pos.TOP_RIGHT);
        Button pause = new Button();
        pause.setText("pause");
        pause.setOnMouseClicked(mouseEvent -> {
            try {
                new PauseMenu().start(GameStage.getGameStage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        sideBar.getChildren().add(pause);
        pane.getChildren().add(sideBar);
    }

    private void createHbox(HBox hBox, Text remainingBalls, ProgressBar progressBar) {
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(remainingBalls);
        hBox.setSpacing(50);
        hBox.getChildren().add(progressBar);
    }

}

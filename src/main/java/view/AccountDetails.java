package view;

import controller.UserProfileController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.GameStage;

public class AccountDetails extends Application {
    private static String currentPlayer;
    private UserProfileController userProfileController = new UserProfileController();
    @Override
    public void start(Stage stage) throws Exception {
        userProfileController.setCurrentPlayer(currentPlayer);
        BorderPane borderPane = new BorderPane();
        VBox vBox = new VBox();
        Label title = new Label("Account Details");
        Text username = new Text(userProfileController.getPlayerName());
        Text password = new Text(userProfileController.getPlayerPassword());
        Circle userAvatar = new Circle();
        userAvatar.setFill(userProfileController.getPlayerAvatar());
        Text highScore = new Text(userProfileController.getPlayerHighScore());
        Text difficulty = new Text(userProfileController.getPlayerDifficulty());
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);
        borderPane.setCenter(vBox);
        vBox.getChildren().add(title);
        vBox.getChildren().add(userAvatar);
        vBox.getChildren().add(username);
        vBox.getChildren().add(password);
        vBox.getChildren().add(highScore);
        vBox.getChildren().add(difficulty);
        Scene scene = new Scene(borderPane,600,600);
        GameStage.setGameStage(stage);
        GameStage.setStageScene(scene);
        GameStage.getGameStage().show();
    }
    public void setCurrentPlayer(String username) {
        currentPlayer = username;
    }
}

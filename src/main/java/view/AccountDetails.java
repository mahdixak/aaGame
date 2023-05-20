package view;

import controller.UserProfileController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
        BorderPane borderPane = new BorderPane();
        VBox vBox = new VBox();
        Text username = new Text(userProfileController.getPlayerName());
        Text password = new Text(userProfileController.getPlayerPassword());
        Circle userAvatar = new Circle();
        userAvatar.setFill(userProfileController.getPlayerAvatar());
        Text highScore = new Text(userProfileController.getPlayerHighScore());
        Text difficulty = new Text(userProfileController.getPlayerDifficulty());
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);
        borderPane.setCenter(vBox);
        vBox.getChildren().add(userAvatar);
        vBox.getChildren().add(username);
        vBox.getChildren().add(password);
        vBox.getChildren().add(highScore);
        vBox.getChildren().add(difficulty);
        Scene scene = new Scene(borderPane);
        GameStage.setGameStage(stage);
        GameStage.setStageScene(scene);
        GameStage.getGameStage().show();
    }
    public void setCurrentPlayer(String username) {
        userProfileController.setCurrentPlayer(username);
        currentPlayer = username;
    }
}

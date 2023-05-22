package view;

import controller.UserProfileController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.GameStage;

import static view.Controllers.userProfileController;

public class AccountDetails extends Application {
    private String currentPlayer;
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
        Button goBackButton = new Button();
        goBackButton.setText("Back");
        goBackButton.setOnMouseClicked(mouseEvent -> {
            try {
                goBack();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
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
    public void setName(String username) {
        this.currentPlayer = username;
    }

    public void goBack() throws Exception {
        AccountSettings accountSettings = new AccountSettings();
        accountSettings.setName(currentPlayer);
        accountSettings.start(GameStage.getGameStage());
    }
}

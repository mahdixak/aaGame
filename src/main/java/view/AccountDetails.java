package view;

import controller.UserProfileController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Avatar;
import model.GameStage;

import static view.Controllers.userProfileController;

public class AccountDetails extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = new BorderPane();
        VBox vBox = new VBox();
        Label title = new Label("Account Details");
        Text username = new Text(userProfileController.getPlayerName());
        Text password = new Text(userProfileController.getPlayerPassword());
        Circle userAvatar = new Circle();
        userAvatar.setRadius(50);
        userAvatar.setFill(new ImagePattern(new Image(userProfileController.getPlayerAvatar())));
        Text highScore = new Text(userProfileController.getPlayerHighScore());
        Text difficulty = new Text(userProfileController.getPlayerDifficulty().getDifficulty());
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
        vBox.getChildren().add(goBackButton);
        Scene scene = new Scene(borderPane,800,800);
        scene.setUserAgentStylesheet(GameStage.getCurrentTheme().getTheme());
        GameStage.setGameStage(stage);
        GameStage.setStageScene(scene);
        GameStage.getGameStage().show();
    }

    public void goBack() throws Exception {
        AccountSettings accountSettings = new AccountSettings();
        accountSettings.start(GameStage.getGameStage());
    }
}

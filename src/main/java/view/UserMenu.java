package view;

import controller.UserProfileController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.GameStage;
import view.controllers.UserMenuController;

public class UserMenu extends Application {
    private final UserProfileController userProfileController;
    public UserMenu(String username) {
        this.userProfileController = new UserProfileController(username);
        new UserMenuController(username);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = FXMLLoader.load(UserMenu.class.getResource("/FXML/userMenu.fxml"));
        Scene scene = new Scene(borderPane);
        GameStage.setGameStage(stage);
        GameStage.setStageScene(scene);
        GameStage.getGameStage().show();
    }
}

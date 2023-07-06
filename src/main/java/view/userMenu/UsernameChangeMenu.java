package view.userMenu;

import controller.UserProfileController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.GameStage;
import view.enums.status.UserProfileStatus;


public class UsernameChangeMenu extends Application {
    UserProfileController userProfileController = AccountSettings.getUserProfileController();
    @FXML
    private TextField newUsername;
    @FXML
    private PasswordField password;


    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = FXMLLoader.load(UsernameChangeMenu.class.getResource("/FXML/usernameChangeMenu.fxml"));
        Scene scene = new Scene(borderPane);
        scene.setUserAgentStylesheet(GameStage.getCurrentTheme().getTheme());
        GameStage.setGameStage(stage);
        GameStage.setStageScene(scene);
        GameStage.getGameStage().show();
    }
    public void goBackToAccountSettings() throws Exception {
        new AccountSettings().start(GameStage.getGameStage());
    }
    public void changingPlayerUsername() throws Exception {
        UserProfileStatus status = userProfileController.changePlayerUsernameCheck(newUsername.getText(), password.getText());
        if (status.equals(UserProfileStatus.ALL_ELEMENTS_ARE_VALID)) {
            userProfileController.changeUsername(newUsername.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("password changed successfully");
            alert.setContentText("you password changed successfully!");
            alert.showAndWait();
            new AccountSettings().start(GameStage.getGameStage());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error while changing username");
            alert.setContentText(status.getStatus());
            alert.showAndWait();
        }
    }

}

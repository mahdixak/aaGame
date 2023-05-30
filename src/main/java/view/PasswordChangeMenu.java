package view;

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

import static view.Controllers.userProfileController;

public class PasswordChangeMenu extends Application {
    @FXML
    private PasswordField newPassword;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = FXMLLoader.load(UsernameChangeMenu.class.getResource("/FXML/passwordChangeMenu.fxml"));
        Scene scene = new Scene(borderPane);
        scene.setUserAgentStylesheet(GameStage.getCurrentTheme().getTheme());
        GameStage.setGameStage(stage);
        GameStage.setStageScene(scene);
        GameStage.getGameStage().show();
    }
    public void goBackToAccountSettings() throws Exception {
        AccountSettings accountSettings = new AccountSettings();
        accountSettings.start(GameStage.getGameStage());
    }

    public void changingPlayerPassword() throws Exception {
        userProfileController.setCurrentPlayer(username.getText());
        UserProfileStatus status = userProfileController.changePlayerPasswordCheck(username.getText(), password.getText(), newPassword.getText());
        if (status.equals(UserProfileStatus.ALL_ELEMENTS_ARE_VALID)) {
            userProfileController.changePassword(newPassword.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("password changed successfully");
            alert.setContentText("you password changed successfully!");
            alert.showAndWait();
            new AccountSettings().start(GameStage.getGameStage());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error while changing password!");
            alert.setContentText(status.getStatus());
            alert.showAndWait();
        }
    }
}

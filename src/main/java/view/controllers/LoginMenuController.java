package view.controllers;

import controller.RegistrationAndLoginController;
import controller.UserProfileController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.GameStage;
import view.AccountSettings;
import view.StartMenu;
import view.UserMenu;
import view.enums.status.RegisterationAndLoginStatus;
import view.enums.status.UserProfileStatus;

public class LoginMenuController {
    @FXML
    private PasswordField newPassword;
    @FXML
    private TextField newUsername;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    private RegistrationAndLoginController registrationAndLoginController = new RegistrationAndLoginController();
    private UserProfileController userProfileController = new UserProfileController();
    public void checkTextFieldsForLoggingIn() throws Exception {
        registrationAndLoginController.setCurrentUsername(username.getText());
        RegisterationAndLoginStatus status = registrationAndLoginController.checkLoggingInParameters(password.getText());
        if (status.equals(RegisterationAndLoginStatus.LOGIN_PARAMETERS_ARE_VALID)) {
            UserProfileController userProfileController = new UserProfileController();
            userProfileController.setCurrentPlayer(username.getText());
            new UserMenu().start(GameStage.getGameStage());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error while logging in!");
            alert.setContentText(status.getStatus());
            alert.showAndWait();
        }
    }

    public void clearFields() {
        username.setText("");
        password.setText("");
    }

    public void goBack() throws Exception {
        new StartMenu().start(GameStage.getGameStage());
    }

    public void goBackToAccountSettings() throws Exception {
        new AccountSettings().start(GameStage.getGameStage());
    }

    public void terminateProgram() {
        System.exit(0);
    }

    public void changingPlayerUsername() {
        UserProfileStatus status = userProfileController.changePlayerUsernameCheck(newUsername.getText(),password.getText());
        if (status.equals(UserProfileStatus.ALL_ELEMENTS_ARE_VALID)) {
            userProfileController.changeUsername(newUsername.getText());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error while changing username");
            alert.setContentText(status.getStatus());
            alert.showAndWait();
        }
    }

    public void changingPlayerPassword() {
        userProfileController.setCurrentPlayer(username.getText());
        UserProfileStatus status = userProfileController.changePlayerPasswordCheck(username.getText(),password.getText(),newPassword.getText());
        if (status.equals(UserProfileStatus.ALL_ELEMENTS_ARE_VALID)) {
            userProfileController.changePassword(newPassword.getText());
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error while changing password!");
            alert.setContentText(status.getStatus());
            alert.showAndWait();
        }
    }
}

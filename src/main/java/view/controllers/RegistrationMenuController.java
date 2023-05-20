package view.controllers;

import controller.RegistrationAndLoginController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.GameStage;
import view.AvatarMenu;
import view.StartMenu;
import view.enums.status.RegisterationAndLoginStatus;

public class RegistrationMenuController {
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;
    RegistrationAndLoginController registrationAndLoginController = new RegistrationAndLoginController();

    public void checkTextFieldsForCreatingAccount() throws Exception {
        registrationAndLoginController.setCurrentUsername(username.getText());
        RegisterationAndLoginStatus status = registrationAndLoginController.checkUsernameField();
        if (status.equals(RegisterationAndLoginStatus.USERNAME_CHECKED_SUCCESSFULLY)) {
            status = registrationAndLoginController.checkPasswordField(password.getText());
            if (status.equals(RegisterationAndLoginStatus.PASSWORD_CHECKED_SUCCESSFULLY)) {
                registrationAndLoginController.signingUser(password.getText());
                AvatarMenuController.setCurrentUser(username.getText());
                new AvatarMenu().start(GameStage.getGameStage());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error while signing up!");
                alert.setHeaderText("password is invalid!");
                alert.setContentText(status.getStatus());
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error while signing up!");
            alert.setHeaderText("username is invalid!");
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

}

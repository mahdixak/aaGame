package view.controllers;

import controller.RegistrationAndLoginController;
import controller.UserProfileController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import model.GameStage;
import view.StartMenu;
import view.UserMenu;
import view.enums.status.RegisterationAndLoginStatus;
import view.enums.status.UserProfileStatus;

public class LoginMenuController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    RegistrationAndLoginController registrationAndLoginController;
    public void checkTextFieldsForLoggingIn(MouseEvent mouseEvent) throws Exception {
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

    public void terminateProgram() {
        System.exit(0);
    }
}

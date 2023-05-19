package view.controllers;

import controller.RegistrationAndLoginController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import view.enums.status.RegisterationAndLoginStatus;

public class StartMenuController {
    private final RegistrationAndLoginController registrationAndLoginController = new RegistrationAndLoginController();

    @FXML
    private Label label;
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;

    public void checkTextFieldsForCreatingAccount(MouseEvent mouseEvent) {
        RegisterationAndLoginStatus status = registrationAndLoginController.checkUsernameField(username.getText());
        if (status.equals(RegisterationAndLoginStatus.USERNAME_CHECKED_SUCCESSFULLY)) {
            status = registrationAndLoginController.checkPasswordField(password.getText());
            if (status.equals(RegisterationAndLoginStatus.PASSWORD_CHECKED_SUCCESSFULLY)) {
                registrationAndLoginController.signingUser(username.getText(),password.getText());
                System.out.println(RegisterationAndLoginStatus.USER_CREATED_SUCCESSFULLY.getStatus());
//                new UserGameMenu().start();
            } else
                System.out.println(status.getStatus());
        } else
            System.out.println(status.getStatus());
    }

    public void clearFields(MouseEvent mouseEvent) {
        username.setText("");
        password.setText("");
    }

    public void registrationPage(MouseEvent mouseEvent) {

    }

    public void loginPage(MouseEvent mouseEvent) {
    }

    public void playAsGuest(MouseEvent mouseEvent) {
    }

    public void terminateProgram() {
        System.exit(0);
    }

    public void goBack(MouseEvent mouseEvent) {
    }
}

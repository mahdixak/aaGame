package controller;

import javafx.scene.shape.Circle;
import model.User;
import view.Controllers;
import view.enums.status.RegisterationAndLoginStatus;

import static view.Controllers.userProfileController;

public class RegistrationAndLoginController {
    private String currentUsername;
    public RegisterationAndLoginStatus checkUsernameField() {
        if (this.currentUsername.length() != 0) {
            User user = User.findUserWithUsername(this.currentUsername);
            if (user == null) {
                return this.currentUsername.matches(".*\\s+.*") ? RegisterationAndLoginStatus.INVALID_USERNAME_FORMAT : RegisterationAndLoginStatus.USERNAME_CHECKED_SUCCESSFULLY;
            }
            return RegisterationAndLoginStatus.USERNAME_EXISTS;
        }
        return RegisterationAndLoginStatus.EMPTY_USERNAME_FIELD;
    }

    public RegisterationAndLoginStatus checkPasswordField(String password) {
        if (password.length() != 0) {
            if (password.length() >= 6) {
                if (password.matches(".*\\d+.*")) {
                    if (!password.matches(".*\\s+.*")) {
                        return RegisterationAndLoginStatus.PASSWORD_CHECKED_SUCCESSFULLY;
                    }
                    return RegisterationAndLoginStatus.INVALID_PASSWORD_FORMAT;
                }
                return RegisterationAndLoginStatus.INVALID_PASSWORD_NO_DIGITS;
            }
            return RegisterationAndLoginStatus.INVALID_PASSWORD_T0O_SHORT;
        }
        return RegisterationAndLoginStatus.EMPTY_PASSWORD_FIELD;
    }

    public void signingUser(String password) throws Exception {
        User user = new User(this.currentUsername, password);
        user.addUser();
    }

    public void setUserAvatar(Circle circle) {
        User user = User.findUserWithUsername(this.currentUsername);
        user.setAvatar(circle.getId());
        userProfileController.setCurrentPlayer(user.getUsername());
        JsonController.setUserInformationToJson();
    }

    public String getCurrentUsername() {
        return this.currentUsername;
    }
    public void setCurrentUsername(String currentUsername) {
        this.currentUsername = currentUsername;
    }

    public RegisterationAndLoginStatus checkLoggingInParameters(String password) {
        if (this.currentUsername.length() != 0) {
            if (password.length() != 0) {
                User user = User.findUserWithUsername(this.currentUsername);
                if (user != null) {
                    return user.getPassword().equals(password) ? RegisterationAndLoginStatus.LOGIN_PARAMETERS_ARE_VALID : RegisterationAndLoginStatus.INCORRECT_PASSWORD;
                }
                return RegisterationAndLoginStatus.USERNAME_DOES_NOT_EXISTS;
            }
            return RegisterationAndLoginStatus.EMPTY_PASSWORD_FIELD;
        }
        return RegisterationAndLoginStatus.EMPTY_USERNAME_FIELD;
    }
}

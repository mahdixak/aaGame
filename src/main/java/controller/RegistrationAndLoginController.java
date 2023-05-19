package controller;

import model.User;
import view.enums.status.RegisterationAndLoginStatus;

public class RegistrationAndLoginController {

    public RegisterationAndLoginStatus checkUsernameField(String username) {
        if (username.length() != 0) {
            User user = User.findUserWithUsername(username);
            if (user == null) {
                return username.matches(".*\\s+.*") ? RegisterationAndLoginStatus.INVALID_USERNAME_FORMAT : RegisterationAndLoginStatus.USERNAME_CHECKED_SUCCESSFULLY;
            }
            return RegisterationAndLoginStatus.USERNAME_EXISTS;
        }
        return RegisterationAndLoginStatus.EMPTY_USERNAME_FIELD;
    }

    public RegisterationAndLoginStatus checkPasswordField(String password) {
        if (password.length() != 0) {
            if (password.length() > 6) {
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

    public void signingUser(String username, String password) {
        User user = new User(username, password);
        user.addUser();
    }
}

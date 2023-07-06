package controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import model.Avatar;
import model.User;
import view.enums.status.RegisterationAndLoginStatus;

import java.net.MalformedURLException;

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

    public void setOwnAvatarForUser(String avatarAddress) {
        Avatar.uploadedAvatar.setUploadedAvatar(avatarAddress);
        User user = User.findUserWithUsername(this.currentUsername);
        user.setAvatar(Avatar.uploadedAvatar);
        JsonController.setUserInformationToJson();
    }

    public boolean avatarAddressCheck(String avatarAddress) throws MalformedURLException {
        if (avatarAddress.length() != 0) {
            //todo: irad dre
//            URL url = new URL(avatarAddress);
            System.out.println(avatarAddress);
            System.out.println(getClass().getResource(avatarAddress));
            System.out.println(getClass().getResource(avatarAddress).toExternalForm());
            Image image = new Image(avatarAddress);
            ImageView imageView = new ImageView(image);
            System.out.println(imageView.getImage());
            System.out.println(image.getUrl());
            System.out.println(image.getUrl());
            return true;
        }
        return false;
    }
}

package controller;

import javafx.scene.paint.Paint;
import model.User;
import view.enums.status.UserProfileStatus;

public class UserProfileController {
    private User currentPlayer ;
    public void setCurrentPlayer(String currentPlayerName) {
        this.currentPlayer = User.findUserWithUsername(currentPlayerName);
    }
    public void deleteAccount() {
        currentPlayer.setUsername("");
        currentPlayer.setPassword("");
        User.allUsers().remove(currentPlayer);
    }

    public String getPlayerName() {
        return currentPlayer.getUsername();
    }

    public String getPlayerPassword() {
        return currentPlayer.getPassword();
    }

    public Paint getPlayerAvatar() {
        return currentPlayer.getAvatar().getFill();
    }

    public String getPlayerHighScore() {
        return String.valueOf(currentPlayer.getHighScore());
    }

    public String getPlayerDifficulty() {
        return currentPlayer.getDifficulty().getDifficulty();
    }

    public UserProfileStatus changePlayerUsernameCheck(String newUsername, String userPassword) {
        if (newUsername.length() != 0) {
            if (userPassword.length() != 0) {
                if (currentPlayer.getPassword().equals(userPassword)) {
                    if (!newUsername.equals(currentPlayer.getUsername())) {
                        User user = User.findUserWithUsername(newUsername);
                        if (user == null) {
                            return UserProfileStatus.ALL_ELEMENTS_ARE_VALID;
                        }
                        return UserProfileStatus.USERNAME_EXISTS;
                    }
                    return UserProfileStatus.DUPLICATE_NEW_USERNAME;
                }
                return UserProfileStatus.INCORRECT_PASSWORD;
            }
            return UserProfileStatus.PASSWORD_FIELD_IS_EMPTY;
        }
        return UserProfileStatus.NEW_USERNAME_FIELD_IS_EMPTY;
    }

    public void changeUsername(String newUsername) {
        User user = currentPlayer;
        user.setUsername(newUsername);
        currentPlayer.setUsername(newUsername);
    }

    public UserProfileStatus changePlayerPasswordCheck(String username,String oldPassword, String newPassword) {
        if (username.length() != 0 ) {
            if (oldPassword.length() != 0 ) {
                if (newPassword.length() != 0) {
                    if (currentPlayer != null) {
                        if (currentPlayer.getPassword().equals(oldPassword)) {
                            if (!currentPlayer.getPassword().equals(newPassword)) {
                                return UserProfileStatus.ALL_ELEMENTS_ARE_VALID;
                            }
                            return UserProfileStatus.NEW_PASSWORD_AND_CURRENT_PASSWORD_ARE_EQUAL;
                        }
                        return UserProfileStatus.INCORRECT_PASSWORD;
                    }
                    return UserProfileStatus.INVALID_USERNAME;
                }
                return UserProfileStatus.NEW_PASSWORD_FIELD_IS_EMPTY;
            }
            return UserProfileStatus.PASSWORD_FIELD_IS_EMPTY;
        }
        return UserProfileStatus.USERNAME_FIELD_IS_EMPTY;
    }

    public void changePassword(String newPassword) {
        User user = currentPlayer;
        user.setPassword(newPassword);
        currentPlayer.setPassword(newPassword);
    }
}

package controller;

import model.User;
import view.enums.status.UserProfileStatus;

public class UserProfileController {
    private final User currentPlayer ;

    public UserProfileController(String currentPlayer) {
        this.currentPlayer = User.findUserWithUsername(currentPlayer);
    }

    private void deleteAccount() {
        currentPlayer.setUsername("");
        currentPlayer.setPassword("");
        User.allUsers().remove(currentPlayer);
    }
}

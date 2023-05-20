package controller;

import javafx.scene.paint.Paint;
import model.User;

public class UserProfileController {
    private User currentPlayer ;
    public void setCurrentPlayer(String currentPlayerName) {
        this.currentPlayer = User.findUserWithUsername(currentPlayerName);
    }
    private void deleteAccount() {
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
}

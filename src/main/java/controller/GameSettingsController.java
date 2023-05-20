package controller;

import model.User;

public class GameSettingsController {
    private User currentPlayer;
    public void setCurrentPlayer(String playerUsername) {
        this.currentPlayer = User.findUserWithUsername(playerUsername);
    }

}

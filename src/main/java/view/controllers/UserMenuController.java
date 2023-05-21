package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.GameStage;
import view.AccountSettings;
import view.NewGameMenu;
import view.StartMenu;

public class UserMenuController {
    private static String currentPlayer;

    public void newGame() throws Exception {
        new NewGameMenu().start(GameStage.getGameStage());
    }

    public void loadGame(MouseEvent mouseEvent) {
    }

    public void showHighScore(MouseEvent mouseEvent) {
    }

    public void logoutUser() throws Exception{
        new StartMenu().start(GameStage.getGameStage());
    }

    public void terminateProgram() {
        System.exit(0);
    }

    public static void setCurrentPlayer(String username) {
        currentPlayer = username;
    }

    public void accountSettings() throws Exception {
        AccountSettingsMenuController.setCurrentUser(currentPlayer);
        new AccountSettings().start(GameStage.getGameStage());
    }

}

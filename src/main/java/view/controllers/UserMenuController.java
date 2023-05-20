package view.controllers;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.GameStage;
import view.AccountSettings;

public class UserMenuController {
    private static String currentPlayer;

    public void move(KeyEvent keyEvent) {
        String key = keyEvent.getCode().getName();
        if (key.equals("Left"))
            System.out.println("left");
        else if (key.equals("Right"))
            System.out.println("right");
        else if (key.equals("Down"))
            System.out.println("down");
        else if (key.equals("Up"))
            System.out.println("up");
    }

    public void newGame(MouseEvent mouseEvent) {
    }

    public void loadGame(MouseEvent mouseEvent) {
    }

    public void showHighScore(MouseEvent mouseEvent) {
    }

    public void logoutUser(MouseEvent mouseEvent) {
    }

    public void terminateProgram() {
        System.exit(0);
    }

    public static void setCurrentPlayer(String username) {
        currentPlayer = username;
    }

    public void accountSettings() throws Exception {
        new AccountSettings().start(GameStage.getGameStage());
    }
}

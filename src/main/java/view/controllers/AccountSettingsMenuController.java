package view.controllers;

import controller.UserProfileController;
import javafx.scene.input.MouseEvent;
import model.GameStage;
import view.AccountDetails;
import view.AccountSettings;
import view.UserMenu;

public class AccountSettingsMenuController {
    private String currentUser;

    private UserProfileController userProfileController = new UserProfileController();
    public void showHighScore(MouseEvent mouseEvent) {
    }

    public void deleteAccount(MouseEvent mouseEvent) {
    }

    public void setGameDifficulty(MouseEvent mouseEvent) {
    }

    public void goBack() throws Exception {
        new UserMenu().start(GameStage.getGameStage());
    }

    public void accountDetails() throws Exception {
        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setCurrentPlayer(currentUser);
        accountDetails.start(GameStage.getGameStage());
    }

    public void changePlayerUsername(MouseEvent mouseEvent) {
    }

    public void changePlayerPassword(MouseEvent mouseEvent) {
    }
}

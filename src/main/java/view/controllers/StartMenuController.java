package view.controllers;

import javafx.scene.input.MouseEvent;
import model.GameStage;
import view.LoginMenu;
import view.RegistrationMenu;

public class StartMenuController {

    public void registrationPage() throws Exception {
        new RegistrationMenu().start(GameStage.getGameStage());
    }

    public void loginPage() throws Exception {
        new LoginMenu().start(GameStage.getGameStage());
    }

    public void playAsGuest(MouseEvent mouseEvent) {
        //TODO: later ...
    }

    public void terminateProgram() {
        System.exit(0);
    }


}

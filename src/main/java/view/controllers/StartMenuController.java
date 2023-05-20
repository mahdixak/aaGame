package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import model.GameStage;
import view.LoginMenu;
import view.RegistrationMenu;

public class StartMenuController {


    public void registrationPage() throws Exception {
        RegistrationMenu registrationMenu = new RegistrationMenu();
        registrationMenu.start(GameStage.getGameStage());
    }

    public void loginPage() throws Exception {
        new LoginMenu().start(GameStage.getGameStage());
    }

    public void playAsGuest() {
        //TODO: later ...
    }

    public void terminateProgram() {
        System.exit(0);
    }
}

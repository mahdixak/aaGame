package view.controllers;

import controller.RegistrationAndLoginController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.GameStage;
import view.RegistrationMenu;
import view.enums.status.RegisterationAndLoginStatus;

public class StartMenuController {

    @FXML
    private Label label;


    public void registrationPage(MouseEvent mouseEvent) throws Exception {
        new RegistrationMenu().start(GameStage.getGameStage());
    }

    public void loginPage(MouseEvent mouseEvent) {
    }

    public void playAsGuest(MouseEvent mouseEvent) {
        //TODO: later ...
    }

    public void terminateProgram() {
        System.exit(0);
    }


}

package view.controllers;

import controller.UserProfileController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import model.GameStage;
import view.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountSettingsMenuController implements Initializable {
    private static String currentUser;
    @FXML
    private ComboBox<String> comboBox;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.setValue("difficulty");
        comboBox.setItems(FXCollections.observableArrayList("easy","medium","hard"));
    }

    private UserProfileController userProfileController = new UserProfileController();
    public void showHighScore(MouseEvent mouseEvent) {
    }

    public void deleteAccount(MouseEvent mouseEvent) throws Exception {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Deleting Account Confirmation");
        alert.setHeaderText("Are you SURE to delete your account?");
        alert.showAndWait();
        Button answer = (Button) mouseEvent.getSource();
        if (answer.getText().equals("ok")) {
            userProfileController.setCurrentPlayer(currentUser);
            userProfileController.deleteAccount();
            new StartMenu().start(GameStage.getGameStage());
        }
    }

    public void changeGameDifficulty(InputMethodEvent mouseEvent) {
        ComboBox<String> comboBox1 = (ComboBox<String>) mouseEvent.getSource();
    }

    public void goBack() throws Exception {
        new UserMenu().start(GameStage.getGameStage());
    }

    public void accountDetails() throws Exception {
        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setCurrentPlayer(currentUser);
        accountDetails.start(GameStage.getGameStage());
    }

    public void changePlayerUsername() throws Exception {
        new UsernameChangeMenu().start(GameStage.getGameStage());
    }

    public void changePlayerPassword() throws Exception {
        new PasswordChangeMenu().start(GameStage.getGameStage());
    }

    public static void setCurrentUser(String currentUser) {
        AccountSettingsMenuController.currentUser = currentUser;
    }
}

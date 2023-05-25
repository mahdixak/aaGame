package view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.GameStage;

import java.net.URL;
import java.util.ResourceBundle;

import static view.Controllers.currentPlayer;
import static view.Controllers.userProfileController;

public class AccountSettings extends Application implements Initializable {
    @FXML
    private ComboBox<String> comboBox;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = FXMLLoader.load(AccountSettings.class.getResource("/FXML/accountSettings.fxml"));
        Scene scene = new Scene(borderPane);
        GameStage.setStageScene(scene);
        GameStage.setGameStage(stage);
        GameStage.getGameStage().show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.setValue("difficulty");
        comboBox.setItems(FXCollections.observableArrayList("easy","medium","hard"));
    }

    public void showHighScore() {
    }

    public void deleteAccount() throws Exception {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Deleting Account Confirmation");
        alert.setHeaderText("Are you SURE to delete your account?");
        alert.showAndWait();
        if (alert.getResult().getText().equals("OK")) {
            userProfileController.deleteAccount();
            new StartMenu().start(GameStage.getGameStage());
        }
    }

    public void changeGameDifficulty(InputMethodEvent mouseEvent) {
        //TODO:
        ComboBox<String> comboBox1 = (ComboBox<String>) mouseEvent.getSource();
    }

    public void goBack() throws Exception {
        UserMenu userMenu = new UserMenu();
        userMenu.start(GameStage.getGameStage());
    }

    public void accountDetails() throws Exception {
        AccountDetails accountDetails = new AccountDetails();
        accountDetails.start(GameStage.getGameStage());
    }

    public void changePlayerUsername() throws Exception {
        UsernameChangeMenu usernameChangeMenu = new UsernameChangeMenu();
            usernameChangeMenu.start(GameStage.getGameStage());
    }

    public void changePlayerPassword() throws Exception {
        new PasswordChangeMenu().start(GameStage.getGameStage());
    }

}

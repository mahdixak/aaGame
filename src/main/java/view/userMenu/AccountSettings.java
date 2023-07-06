package view.userMenu;

import controller.UserProfileController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.GameStage;

import java.net.URL;
import java.util.ResourceBundle;


public class AccountSettings extends Application implements Initializable {
    static UserProfileController userProfileController = new UserProfileController(UserMenu.getUsername());
    @FXML
    private ComboBox<String> comboBox;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = FXMLLoader.load(AccountSettings.class.getResource("/FXML/accountSettings.fxml"));
        Scene scene = new Scene(borderPane);
        scene.setUserAgentStylesheet(GameStage.getCurrentTheme().getTheme());
        GameStage.setStageScene(scene);
        GameStage.setGameStage(stage);
        GameStage.getGameStage().show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.setValue("change difficulty");
        comboBox.setItems(FXCollections.observableArrayList("easy","medium","hard"));
        comboBox.setOnAction(this::setDifficulty);
    }

    private void setDifficulty(ActionEvent actionEvent) {
        String difficulty = comboBox.getValue();
        userProfileController.setPlayerDifficulty(difficulty);
//        singlePlayerController.setBallsRemaining(Controllers.userProfileController.getPlayerDifficulty().getNumberOfBalls());
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

    public void goBack() throws Exception {
        new UserMenu().start(GameStage.getGameStage());
    }

    public void accountDetails() throws Exception {
        new AccountDetails().start(GameStage.getGameStage());
    }

    public void changePlayerUsername() throws Exception {
        new UsernameChangeMenu().start(GameStage.getGameStage());
    }

    public void changePlayerPassword() throws Exception {
        new PasswordChangeMenu().start(GameStage.getGameStage());
    }

    public static UserProfileController getUserProfileController() {
        return userProfileController;
    }
}

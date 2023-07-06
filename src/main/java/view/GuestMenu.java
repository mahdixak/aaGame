package view;

import controller.SinglePlayerController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Difficulty;
import model.GameStage;
import view.userMenu.StartMenu;

import java.net.URL;
import java.util.ResourceBundle;

public class GuestMenu extends Application implements Initializable {
    SinglePlayerController singlePlayerController = new SinglePlayerController("guest");
    @FXML
    private ComboBox<String> comboBox;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = FXMLLoader.load(NewGameMenu.class.getResource("/FXML/guestNewGameMenu.fxml"));
        Scene scene = new Scene(borderPane);
        scene.setUserAgentStylesheet(GameStage.getCurrentTheme().getTheme());
        GameStage.setGameStage(stage);
        GameStage.setStageScene(scene);
        GameStage.getGameStage().show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.setValue("difficulty");
        comboBox.setItems(FXCollections.observableArrayList("easy","medium","hard"));
        comboBox.setOnAction(this::setDifficulty);
    }

    private void setDifficulty(ActionEvent actionEvent) {
        String difficulty = comboBox.getValue();
        singlePlayerController.setBallsRemaining(Difficulty.findBallsWithDifficulty(difficulty));
    }

    public void singlePlayerMode() throws Exception {
        if (singlePlayerController.getBallsRemaining()!=0) {
            SinglePlayerModePage singlePlayerModePage = new SinglePlayerModePage();
            singlePlayerModePage.start(GameStage.getGameStage());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error while entering game");
            alert.setContentText("you most select the difficulty first");
            alert.showAndWait();
        }
    }

    public void playWithFriend() throws Exception {
        PlayWithFriendPage playWithFriend = new PlayWithFriendPage();
        playWithFriend.start(GameStage.getGameStage());
    }

    public void goBack() throws Exception {
        new StartMenu().start(GameStage.getGameStage());
    }

    public void changeGameDifficulty(InputMethodEvent inputMethodEvent) {
    }
}

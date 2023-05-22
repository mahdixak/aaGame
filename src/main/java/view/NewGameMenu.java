package view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.GameStage;

import java.net.URL;
import java.util.ResourceBundle;

public class NewGameMenu extends Application implements Initializable {
    private String currentPlayer;
    @FXML
    private ComboBox<String> comboBox;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = FXMLLoader.load(NewGameMenu.class.getResource("/FXML/newGameMenu.fxml"));
        Scene scene = new Scene(borderPane);
        GameStage.setGameStage(stage);
        GameStage.setStageScene(scene);
        GameStage.getGameStage().show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.setValue("difficulty");
        comboBox.setItems(FXCollections.observableArrayList("easy","medium","hard"));
    }

    public void singlePlayerMode() throws Exception {
        SinglePlayerModePage singlePlayerModePage = new SinglePlayerModePage();
        singlePlayerModePage.setName(currentPlayer);
        singlePlayerModePage.start(GameStage.getGameStage());
    }

    public void playWithFriend() throws Exception {
        PlayWithFriendPage playerWithFriend = new PlayWithFriendPage();
        playerWithFriend.setName(currentPlayer);
        playerWithFriend.start(GameStage.getGameStage());
    }

    public void goBack() throws Exception {
        UserMenu userMenu = new UserMenu();
        userMenu.setName(currentPlayer);
        userMenu.start(GameStage.getGameStage());
    }

    public void changeGameDifficulty(InputMethodEvent inputMethodEvent) {
    }

    public void setName(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}

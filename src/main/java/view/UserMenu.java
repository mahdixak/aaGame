package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.GameStage;

public class UserMenu extends Application {
    private String currentPlayer;


    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = FXMLLoader.load(UserMenu.class.getResource("/FXML/userMenu.fxml"));
        Scene scene = new Scene(borderPane);
        GameStage.setGameStage(stage);
        GameStage.setStageScene(scene);
        GameStage.getGameStage().show();
    }

    public void newGame() throws Exception {
        NewGameMenu newGameMenu = new NewGameMenu();
        newGameMenu.setName(currentPlayer);
        newGameMenu.start(GameStage.getGameStage());
    }

    public void loadGame() {
    }

    public void showHighScore() {
    }

    public void logoutUser() throws Exception {
        new StartMenu().start(GameStage.getGameStage());
    }

    public void terminateProgram() {
        System.exit(0);
    }

    public void accountSettings() throws Exception {
        AccountSettings accountSettings = new AccountSettings();
        accountSettings.setName(currentPlayer);
        accountSettings.start(GameStage.getGameStage());
    }

    public void setName(String currentUser) {
        this.currentPlayer = currentUser;
    }
}

package view.userMenu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.GameStage;
import view.NewGameMenu;

public class UserMenu extends Application {
    static String username;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = FXMLLoader.load(UserMenu.class.getResource("/FXML/userMenu.fxml"));
        Scene scene = new Scene(borderPane);
        scene.setUserAgentStylesheet(GameStage.getCurrentTheme().getTheme());
        GameStage.setGameStage(stage);
        GameStage.setStageScene(scene);
        GameStage.getGameStage().show();
    }

    public void newGame() throws Exception {
        new NewGameMenu().start(GameStage.getGameStage());
    }

    public void loadGame() {
    }

    public void showHighScore() throws Exception {
        new HighScoreMenu().start(GameStage.getGameStage());
    }

    public void logoutUser() throws Exception {
        new StartMenu().start(GameStage.getGameStage());
    }

    public void terminateProgram() {
        System.exit(0);
    }

    public void accountSettings() throws Exception {
        new AccountSettings().start(GameStage.getGameStage());
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UserMenu.username = username;
    }
}

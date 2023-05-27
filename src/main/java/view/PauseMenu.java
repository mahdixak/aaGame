package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.GameStage;

public class PauseMenu extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = FXMLLoader.load(getClass().getResource("/FXML/pauseMenu.fxml"));
        Scene scene = new Scene(borderPane);
        GameStage.setGameStage(stage);
        GameStage.setStageScene(scene);
        GameStage.getGameStage().show();
    }
    public void resumeGame() throws Exception {
        //TODO:
    }

    public void restartNewGame() throws Exception {
        new NewGameMenu().start(GameStage.getGameStage());
    }

    public void keyBuildingsShow() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("key buildings");
        alert.setContentText("""
                to change ball position: use Left and Right arrow keys!
                for shooting ball to main ball: use Space
                for use freezing time: use TAB
                """);
        alert.showAndWait();
    }

    public void settings() throws Exception {
        new AccountSettings().start(GameStage.getGameStage());
    }

    public void backToGameMenu() throws Exception {
        new UserMenu().start(GameStage.getGameStage());
    }

    public void ExitTheGame() {
        System.exit(0);
    }
}

package model;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import view.StartMenu;

public class GameStage{
    private static Stage gameStage;
    private static Themes currentTheme;


    public static Stage getGameStage() {
        return gameStage;
    }

    public static void setGameStage(Stage gameStage) {
        GameStage.gameStage = gameStage;
        Image icon = new Image(String.valueOf(StartMenu.class.getResource("/images/icon.png")));
        GameStage.gameStage.getIcons().add(icon);
        GameStage.gameStage.setTitle("aa Game!");
        GameStage.gameStage.setResizable(false);
        GameStage.gameStage.setFullScreen(false);
    }
    public static void setStageScene(Scene scene) {
        gameStage.setScene(scene);
    }

    public static Themes getCurrentTheme() {
        return currentTheme;
    }

    public static void setCurrentTheme(Themes currentTheme) {
        GameStage.currentTheme = currentTheme;
    }
}

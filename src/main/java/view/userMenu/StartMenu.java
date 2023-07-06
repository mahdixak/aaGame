package view.userMenu;

import controller.JsonController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.GameStage;
import model.Themes;
import view.GuestMenu;

import java.util.Objects;



public class StartMenu extends Application {
    static JsonController jsonController = new JsonController();
    @FXML
    private ToggleButton toggleButtonMute;
    @FXML
    private ToggleButton toggleButtonTheme;
    private static Scene scene;
    private static MediaPlayer mediaPlayer;
    public static void main(String[] args) throws Exception {
        jsonController.checkJsonDirectory();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Media media = new Media(getClass().getResource("/media/bgsong1.wav").toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        BorderPane borderPane = FXMLLoader.load(Objects.requireNonNull(StartMenu.class.getResource("/FXML/startGame.fxml")));
        Scene scene = new Scene(borderPane);
        GameStage.setCurrentTheme(Themes.Light);
        scene.setUserAgentStylesheet(Themes.Light.getTheme());
        setScene(scene);
        GameStage.setGameStage(stage);
        GameStage.setStageScene(scene);
        GameStage.getGameStage().show();
    }

//    @FXML
//    public void initialize() {
//        Image image = new Image(SinglePlayerController.class.getResource("/images/icon.png").toExternalForm(),800,800,false,false);
//        BackgroundImage backgroundImage =  new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
//        Background background = new Background(backgroundImage);
//        toggleButtonMute.setBackground(background);
////        ToggleButton button = new ToggleButton();
////        button.set
//    }

    public void registrationPage() throws Exception {
        new RegistrationMenu().start(GameStage.getGameStage());
    }

    public void loginPage() throws Exception {
        new LoginMenu().start(GameStage.getGameStage());
    }

    public void playAsGuest() throws Exception {
        new GuestMenu().start(GameStage.getGameStage());
    }

    public void terminateProgram() {
        System.exit(0);
    }

    public void changeTheme() {
        if (toggleButtonTheme.getText().equals("dark theme")) {
            scene.setUserAgentStylesheet(Themes.Dark.getTheme());
            GameStage.setCurrentTheme(Themes.Dark);
            toggleButtonTheme.setText("light theme");
            return;
        }
        if (toggleButtonTheme.getText().equals("light theme")) {
            scene.setUserAgentStylesheet(Themes.Light.getTheme());
            GameStage.setCurrentTheme(Themes.Light);
            toggleButtonTheme.setText("dark theme");
        }
    }

    public void muteMusic() {
        if (toggleButtonMute.getText().equals("mute music")) {
            mediaPlayer.setAutoPlay(false);
            mediaPlayer.pause();
            toggleButtonMute.setText("unmute music");
            return;
        }
        if (toggleButtonMute.getText().equals("unmute music")) {
            Media media = new Media(getClass().getResource("/media/bgsong2.wav").toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
            toggleButtonMute.setText("mute music");
        }
    }

    public void setScene(Scene newScene) {
        scene = newScene;
    }
}

package view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.GameStage;

import java.util.Objects;

import static view.Controllers.jsonController;


public class StartMenu extends Application {
    @FXML
    private ToggleButton toggleButtonMute;
    @FXML
    private ToggleButton toggleButtonTheme;
    private static Scene scene;
    public static void main(String[] args) throws Exception {
        jsonController.checkJsonDirectory();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Media media = new Media(getClass().getResource("/media/bgsong1.wav").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        BorderPane borderPane = FXMLLoader.load(Objects.requireNonNull(StartMenu.class.getResource("/FXML/startGame.fxml")));
        Scene scene = new Scene(borderPane);
//        scene.setUserAgentStylesheet(getClass().getResource("/CSS/style1(1).css").toExternalForm());
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
        RegistrationMenu registrationMenu = new RegistrationMenu();
        registrationMenu.start(GameStage.getGameStage());
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

    public void changeTheme(MouseEvent mouseEvent) {
        if (toggleButtonTheme.getText().equals("dark theme")) {
            scene.setUserAgentStylesheet(getClass().getResource("/CSS/darkTheme.css").toExternalForm());
            toggleButtonTheme.setText("light theme");
            return;
        }
        if (toggleButtonTheme.getText().equals("light theme")) {
            scene.setUserAgentStylesheet(null);
            toggleButtonTheme.setText("dark theme");
        }
    }

    public void muteMusic(MouseEvent mouseEvent) {
        if (toggleButtonMute.getText().equals("mute music")) {
            //muting song
            toggleButtonMute.setText("unmute music");
            return;
        }
        if (toggleButtonMute.getText().equals("unmute music")) {
            //play song
            toggleButtonMute.setText("mute music");
        }
    }

    public void setScene(Scene newScene) {
        scene = newScene;
    }
}

package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.GameStage;

import java.util.Objects;

import static view.Controllers.jsonController;


public class StartMenu extends Application {

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
        GameStage.setGameStage(stage);
        GameStage.setStageScene(scene);
        GameStage.getGameStage().show();
    }

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
}

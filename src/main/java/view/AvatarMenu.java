package view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.GameStage;

import java.net.URL;

import static view.Controllers.*;

public class AvatarMenu extends Application {
    @FXML
    private Circle circle1 = new Circle();
    @FXML
    private Circle circle2 = new Circle();
    @FXML
    private Circle circle3 = new Circle();
    @FXML
    private Circle circle4 = new Circle();
    @FXML
    private Circle circle5 = new Circle();
    @FXML
    private Circle circle6 = new Circle();
    @FXML
    private Circle circle7 = new Circle();
    @FXML
    private Circle circle8 = new Circle();
    @FXML
    private Circle circle9 = new Circle();
    @FXML
    private Circle circle10 = new Circle();
    @FXML
    private Circle circle11 = new Circle();
    @FXML
    private Circle circle12 = new Circle();
    @Override
    public void start(Stage stage) throws Exception {
        URL url = AvatarMenu.class.getResource("/FXML/avatarMenu.fxml");
        BorderPane borderPane = FXMLLoader.load(url);
        Scene scene = new Scene(borderPane);
        GameStage.setStageScene(scene);
        GameStage.setGameStage(stage);
        GameStage.getGameStage().show();
    }

    @FXML
    public void initialize() {
        circle1.setFill(new ImagePattern(new Image(StartMenu.class.getResource("/images/avatars/avatar1.png").toExternalForm())));
        circle2.setFill(new ImagePattern(new Image(StartMenu.class.getResource("/images/avatars/avatar2.png").toExternalForm())));
        circle3.setFill(new ImagePattern(new Image(StartMenu.class.getResource("/images/avatars/avatar3.png").toExternalForm())));
        circle4.setFill(new ImagePattern(new Image(StartMenu.class.getResource("/images/avatars/avatar4.png").toExternalForm())));
        circle5.setFill(new ImagePattern(new Image(StartMenu.class.getResource("/images/avatars/avatar5.png").toExternalForm())));
        circle6.setFill(new ImagePattern(new Image(StartMenu.class.getResource("/images/avatars/avatar6.png").toExternalForm())));
        circle7.setFill(new ImagePattern(new Image(StartMenu.class.getResource("/images/avatars/avatar7.png").toExternalForm())));
        circle8.setFill(new ImagePattern(new Image(StartMenu.class.getResource("/images/avatars/avatar8.png").toExternalForm())));
        circle9.setFill(new ImagePattern(new Image(StartMenu.class.getResource("/images/avatars/avatar9.png").toExternalForm())));
        circle10.setFill(new ImagePattern(new Image(StartMenu.class.getResource("/images/avatars/avatar10.png").toExternalForm())));
        circle11.setFill(new ImagePattern(new Image(StartMenu.class.getResource("/images/avatars/avatar11.png").toExternalForm())));
        circle12.setFill(new ImagePattern(new Image(StartMenu.class.getResource("/images/avatars/avatar12.png").toExternalForm())));
    }

    public void selectAvatar(MouseEvent mouseEvent) throws Exception {
        Circle circle = (Circle) mouseEvent.getSource();
        registrationAndLoginController.setUserAvatar(circle);
        UserMenu userMenu = new UserMenu();
        userMenu.start(GameStage.getGameStage());
    }

    public void uploadAvatar(MouseEvent mouseEvent) {
    }

    public void randomAvatar(MouseEvent mouseEvent) {
    }
}

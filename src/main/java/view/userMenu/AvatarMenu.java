package view.userMenu;

import controller.RegistrationAndLoginController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.GameStage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;


public class AvatarMenu extends Application {
    RegistrationAndLoginController registrationAndLoginController;
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
        registrationAndLoginController = RegistrationMenu.getRegistrationAndLoginController();
        URL url = AvatarMenu.class.getResource("/FXML/avatarMenu.fxml");
        BorderPane borderPane = FXMLLoader.load(url);
        Scene scene = new Scene(borderPane);
        scene.setUserAgentStylesheet(GameStage.getCurrentTheme().getTheme());
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
        new UserMenu().start(GameStage.getGameStage());
    }

    public void uploadAvatar() {
        Stage popUpStage = new Stage();
        popUpStage.initModality(Modality.APPLICATION_MODAL);
        popUpStage.setWidth(400);
        popUpStage.setHeight(250);
        popUpStage.setFullScreen(false);
        popUpStage.setResizable(false);
        Label label = new Label();
        label.setText("enter your own avatar address");
        TextField textField = new TextField();
        textField.setPromptText("avatar address");
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(30);
        Button cancel = new Button();
        cancel.setOnMouseClicked(mouseEvent -> popUpStage.close());
        cancel.setText("cancel");
        Button setAvatar = new Button();
        setAvatar.setOnMouseClicked(mouseEvent -> {
            try {
                if (registrationAndLoginController.avatarAddressCheck(textField.getText())) {
                    registrationAndLoginController.setOwnAvatarForUser(textField.getText());
                    popUpStage.close();
                    try {
                        new UserMenu().start(GameStage.getGameStage());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error while set avatar");
                    alert.setHeaderText("address is invalid!");
                    alert.setContentText("you most set your avatar address here!");
                    alert.showAndWait();
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        });
        setAvatar.setText("set avatar");
        hBox.getChildren().addAll(setAvatar, cancel);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(30);
        vBox.getChildren().addAll(label, textField, hBox);
        Scene scene = new Scene(vBox);
        popUpStage.setScene(scene);
        popUpStage.show();

    }

    public void randomAvatar() throws Exception {
        Random random = new Random();
        int number = random.nextInt() % 12;
        switch (number) {
            case 1:
                registrationAndLoginController.setUserAvatar(circle1);
                break;
            case 2:
                registrationAndLoginController.setUserAvatar(circle2);
                break;
            case 3:
                registrationAndLoginController.setUserAvatar(circle3);
                break;
            case 4:
                registrationAndLoginController.setUserAvatar(circle4);
                break;
            case 5:
                registrationAndLoginController.setUserAvatar(circle5);
                break;
            case 6:
                registrationAndLoginController.setUserAvatar(circle6);
                break;
            case 7:
                registrationAndLoginController.setUserAvatar(circle7);
                break;
            case 8:
                registrationAndLoginController.setUserAvatar(circle8);
                break;
            case 9:
                registrationAndLoginController.setUserAvatar(circle9);
                break;
            case 10:
                registrationAndLoginController.setUserAvatar(circle10);
                break;
            case 11:
                registrationAndLoginController.setUserAvatar(circle11);
                break;
            case 12:
                registrationAndLoginController.setUserAvatar(circle12);
                break;
        }
        new UserMenu().start(GameStage.getGameStage());
    }
}

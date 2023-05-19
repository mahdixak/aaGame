package view.controllers;

import controller.RegistrationAndLoginController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import model.GameStage;
import view.AvatarMenu;
import view.StartMenu;
import view.UserMenu;
import view.enums.status.RegisterationAndLoginStatus;

public class RegistrationMenuController {
    private final RegistrationAndLoginController registrationAndLoginController = new RegistrationAndLoginController();
    @FXML
    private Circle circle1;
    @FXML
    private Circle circle2;
    @FXML
    private Circle circle3;
    @FXML
    private Circle circle4;
    @FXML
    private Circle circle5;
    @FXML
    private Circle circle6;
    @FXML
    private Circle circle7;
    @FXML
    private Circle circle8;
    @FXML
    private Circle circle9;
    @FXML
    private Circle circle10;
    @FXML
    private Circle circle11;
    @FXML
    private Circle circle12;

    @FXML
    private PasswordField password;
    @FXML
    private TextField username;

    public void checkTextFieldsForCreatingAccount(MouseEvent mouseEvent) throws Exception {
        RegisterationAndLoginStatus status = registrationAndLoginController.checkUsernameField(username.getText());
        if (status.equals(RegisterationAndLoginStatus.USERNAME_CHECKED_SUCCESSFULLY)) {
            status = registrationAndLoginController.checkPasswordField(password.getText());
            if (status.equals(RegisterationAndLoginStatus.PASSWORD_CHECKED_SUCCESSFULLY)) {
                registrationAndLoginController.signingUser(username.getText(),password.getText());
                System.out.println(RegisterationAndLoginStatus.USER_CREATED_SUCCESSFULLY.getStatus());
//                new UserMenu(username.getText()).start(GameStage.getGameStage());
                new AvatarMenu().start(GameStage.getGameStage());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error while signing up!");
                alert.setHeaderText("password is invalid!");
                alert.setContentText(status.getStatus());
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error while signing up!");
            alert.setHeaderText("username is invalid!");
            alert.setContentText(status.getStatus());
            alert.showAndWait();
        }
    }
    public void clearFields(MouseEvent mouseEvent) {
        username.setText("");
        password.setText("");
    }
    public void goBack() throws Exception {
        new StartMenu().start(GameStage.getGameStage());
    }

    @FXML
    public void initialize() {
        circle1 = new Circle();
        circle1.setFill(new ImagePattern(new Image(StartMenu.class.getResource("/images/avatars/avatar1.png").toExternalForm())));
    }
}

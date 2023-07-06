package view.userMenu;

import controller.RegistrationAndLoginController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.GameStage;
import view.enums.status.RegisterationAndLoginStatus;


public class RegistrationMenu extends Application {
    static RegistrationAndLoginController registrationAndLoginController = new RegistrationAndLoginController();
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = FXMLLoader.load(RegistrationMenu.class.getResource("/FXML/registrationMenu.fxml"));
        Scene scene = new Scene(borderPane);
        scene.setUserAgentStylesheet(GameStage.getCurrentTheme().getTheme());
        GameStage.setGameStage(stage);
        GameStage.setStageScene(scene);
        GameStage.getGameStage().show();
    }
    public void checkTextFieldsForCreatingAccount() throws Exception {
        registrationAndLoginController.setCurrentUsername(username.getText());
        RegisterationAndLoginStatus status = registrationAndLoginController.checkUsernameField();
        if (status.equals(RegisterationAndLoginStatus.USERNAME_CHECKED_SUCCESSFULLY)) {
            status = registrationAndLoginController.checkPasswordField(password.getText());
            if (status.equals(RegisterationAndLoginStatus.PASSWORD_CHECKED_SUCCESSFULLY)) {
                registrationAndLoginController.signingUser(password.getText());
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

    public void clearFields() {
        username.setText("");
        password.setText("");
    }

    public void goBack() throws Exception {
        new StartMenu().start(GameStage.getGameStage());
    }

    public static RegistrationAndLoginController getRegistrationAndLoginController() {
        return registrationAndLoginController;
    }
}

package view;

import controller.RegistrationAndLoginController;
import controller.UserProfileController;
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

import static view.Controllers.registrationAndLoginController;

public class LoginMenu extends Application {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = FXMLLoader.load(LoginMenu.class.getResource("/FXML/loginMenu.fxml"));
        Scene scene = new Scene(borderPane);
        GameStage.setStageScene(scene);
        GameStage.setGameStage(stage);
        GameStage.getGameStage().show();
    }

    public void checkTextFieldsForLoggingIn() throws Exception {
        registrationAndLoginController.setCurrentUsername(username.getText());
        RegisterationAndLoginStatus status = registrationAndLoginController.checkLoggingInParameters(password.getText());
        if (status.equals(RegisterationAndLoginStatus.LOGIN_PARAMETERS_ARE_VALID)) {
            UserProfileController userProfileController = new UserProfileController();
            userProfileController.setCurrentPlayer(username.getText());
            UserMenu userMenu = new UserMenu();
            userMenu.setName(username.getText());
            userMenu.start(GameStage.getGameStage());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error while logging in!");
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

    public void terminateProgram() {
        System.exit(0);
    }




}

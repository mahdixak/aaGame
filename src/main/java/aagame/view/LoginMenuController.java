package aagame.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginMenuController {
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;

    public void onHelloButtonClick(ActionEvent actionEvent) {
    }

    public void runSubmit(MouseEvent mouseEvent) throws Exception {
        System.out.println(username.getText());
        System.out.println(password.getText());
        if (password.getText().length() < 6 ) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("error");
            alert.setHeaderText("submit error");
            alert.setContentText("your password is weak,(it's to short!)");
            alert.showAndWait();
        } else {
            new MainMenu().start(LoginMenu.stage);
        }
    }

    public void runReset(MouseEvent mouseEvent) {
        username.setText("");
        password.setText("");
    }
}

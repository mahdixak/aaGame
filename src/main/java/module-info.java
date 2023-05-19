module com.example.aa {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    exports view;
    opens view to javafx.fxml;
    exports view.controllers;
    opens view.controllers to javafx.fxml;
}
module com.example.aa {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires json.simple;
    requires org.json;

    exports view;
    opens view to javafx.fxml;
    exports view.userMenu;
    opens view.userMenu to javafx.fxml;
}
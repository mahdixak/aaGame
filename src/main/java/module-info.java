module com.example.aa {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aa to javafx.fxml;
    exports com.example.aa;
}
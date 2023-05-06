module com.example.aagame {
    requires javafx.controls;
    requires javafx.fxml;


    exports aagame.view;
    opens aagame.view to javafx.fxml;
}
module com.example.jemozimusor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jemozimusor to javafx.fxml;
    exports com.example.jemozimusor;
}
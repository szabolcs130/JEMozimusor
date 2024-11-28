module com.example.jemozimusor {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires httpclient;
    requires gson;
    requires httpcore;


    opens com.example.jemozimusor to javafx.fxml;
    exports com.example.jemozimusor;
    exports com.example.jemozimusor.models;
    exports com.example.jemozimusor.controllers;
    opens com.example.jemozimusor.controllers to javafx.fxml;
}
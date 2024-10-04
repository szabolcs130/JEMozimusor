package com.example.jemozimusor;

import com.example.jemozimusor.daos.Database;
import com.example.jemozimusor.daos.MoziFilmHelyDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        Database.isOK();


    }

    public static void main(String[] args) {
        launch();
    }
}
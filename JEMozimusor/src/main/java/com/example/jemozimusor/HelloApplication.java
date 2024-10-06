package com.example.jemozimusor;

import com.example.jemozimusor.daos.Database;
import com.example.jemozimusor.daos.MoziDAO;
import com.example.jemozimusor.daos.MoziFilmHelyDAO;
import com.example.jemozimusor.models.Mozi;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //MoziDAO alma=new MoziDAO();
      //  alma.modositMozi(new Mozi("Bárka Kikötõ a Ráday utcában",1092,"Ráday utca","01"));
           FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
           Scene scene = new Scene(fxmlLoader.load(), 800, 600);
           stage.setTitle("Hello!");
           stage.setScene(scene);
           stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
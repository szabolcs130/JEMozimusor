package com.example.jemozimusor.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SoapFormController {

    /*@FXML
    private TextField tfInputField;*/
    @FXML
    private ComboBox<String> cbDropdown;
    @FXML
    private RadioButton rbOption1;
    @FXML
    private RadioButton rbOption2;
    @FXML
    private CheckBox cbCheckbox;

    @FXML
    private ToggleGroup devizaValaszto;



    @FXML
    public void downloadFile(javafx.event.ActionEvent event) {
        try {
            Path path = Paths.get("MNB.txt");
            if (Files.exists(path)) {
                Desktop.getDesktop().open(path.toFile());
            } else {
                System.out.println("A fájl nem található.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

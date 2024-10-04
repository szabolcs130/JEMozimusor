package com.example.jemozimusor.controllers;

import com.example.jemozimusor.HelloApplication;
import com.example.jemozimusor.daos.MoziFilmHelyDAO;
import com.example.jemozimusor.daos.MoziDAO;
import com.example.jemozimusor.models.MoziFilmHely;
import com.example.jemozimusor.models.Mozi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    public VBox vbKontener;
    public VBox vbKeresMozi;
    public VBox vbMenusor;
    public TableView<MoziFilmHely> moziFilmHelyTabla;
    public TableColumn<MoziFilmHely,String> tcMoziNev;
    public TableColumn<MoziFilmHely,Integer> tcIrSzam;
    public TableColumn<MoziFilmHely,String> tcCim;
    public TableColumn<MoziFilmHely,String> tcTelefon;
    public TableColumn<MoziFilmHely,String> tcFilmCim;
    public TableColumn<MoziFilmHely,Integer> tcSzines;
    public TableColumn<MoziFilmHely,String> tcSzinkron;
    public TableColumn<MoziFilmHely,String> tcSzarmazas;
    public TableColumn<MoziFilmHely,String> tcMufaj;
    public TableColumn<MoziFilmHely,Integer> tcHossz;
    public VBox vbMoziFilmHely;
    public ComboBox cbModositMozi;
    public Button btMoziKeres;
    public TextField tfMoziNeve;
    public TextField tfIrSzam;
    public TextField tfCim;
    public TextField tfTelefon;

    public void initialize(){
        vbKontener.getChildren().removeAll(vbKontener.getChildren());
        vbKontener.getChildren().add(vbMenusor);
        vbKontener.getChildren().add(moziFilmHelyTabla);

        moziFilmHelyTabla.setItems(MoziFilmHelyDAO.getMoziFilmHely());

        tcMoziNev.setCellValueFactory(new PropertyValueFactory<>("oszlopMoziNev"));
        tcIrSzam.setCellValueFactory(new PropertyValueFactory<>("oszlopIrSzam"));
        tcCim.setCellValueFactory(new PropertyValueFactory<>("oszlopcim"));
        tcTelefon.setCellValueFactory(new PropertyValueFactory<>("oszloptelefon"));
        tcFilmCim.setCellValueFactory(new PropertyValueFactory<>("oszlopFilmCim"));
        tcSzines.setCellValueFactory(new PropertyValueFactory<>("oszlopSzines"));
        tcSzinkron.setCellValueFactory(new PropertyValueFactory<>("oszlopSzinkron"));
        tcSzarmazas.setCellValueFactory(new PropertyValueFactory<>("oszlopSzarmazas"));
        tcMufaj.setCellValueFactory(new PropertyValueFactory<>("oszlopMufaj"));
        tcHossz.setCellValueFactory(new PropertyValueFactory<>("oszlopHossz"));
    }

    @FXML
    protected void onHelloButtonClick(ActionEvent event) throws IOException {
        vbKontener.getChildren().removeAll(vbKontener.getChildren());
        vbKontener.getChildren().add(vbKeresMozi);
        for (Mozi m:MoziDAO.getMozi()
             ) {
            cbModositMozi.getItems().add(m.getOszlopMoziNev());
        }
    }
    public void cbAMoziKivalasz(ActionEvent event){
        if (cbModositMozi.getSelectionModel().getSelectedItem().toString()!="Mozi neve"){
            for (Mozi m:MoziDAO.getMozi()
            ) {
                if (m.getOszlopMoziNev().equals(cbModositMozi.getSelectionModel().getSelectedItem().toString())){
                    tfMoziNeve.setText(m.getOszlopMoziNev());
                    tfIrSzam.setText(""+m.getOszlopIrSzam());
                    tfCim.setText(m.getOszlopcim());
                    tfTelefon.setText(m.getOszloptelefon());
                }
            }
        }
    }
}
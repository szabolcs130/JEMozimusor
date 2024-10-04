package com.example.jemozimusor.controllers;

import com.example.jemozimusor.daos.MoziFilmHelyDAO;
import com.example.jemozimusor.models.MoziFilmHely;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {


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

    public void initialize(){
        moziFilmHelyTabla.setItems(MoziFilmHelyDAO.getMoziFilmHely());

        tcMoziNev.setCellValueFactory(new PropertyValueFactory<>("oszlopMoziNev"));
        tcIrSzam.setCellValueFactory(new PropertyValueFactory<>("oszlopIrSzam"));
        tcCim.setCellValueFactory(new PropertyValueFactory<>("oszlopcim"));
    }

    @FXML
    protected void onHelloButtonClick() {

    }
}
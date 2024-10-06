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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    public VBox vbKontener;
    public VBox vbKeresMozi;
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
    public Button btMoziModosit;
    public Button btTorolMozi;
    public TextField tfMoziNeve;
    public TextField tfIrSzam;
    public TextField tfCim;
    public TextField tfTelefon;
    public TextField tfMoziAzon;
    public HBox hbMenusor;
    public Button btModositMozi;
    public Button btIrMozi;
    public Label lbMoziEsemeny;
    public CheckBox rbMozikKeresoSzinkron;
    public RadioButton rbMozikKeresoFelirat;
    public TextField tfMozikKeresoFilmCim;
    public ComboBox cbMozikKeresoMoziNev;
    public Button btMenuMoziKeres;
    public HBox btMoziKeresoresz;
    public RadioButton rbMozikKeresoFeliratMb;
    public Button btMozikKeresoKeres;

    public void initialize(){
        vbKontener.getChildren().removeAll(vbKontener.getChildren());
        vbKontener.getChildren().add(hbMenusor);
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
        vbKontener.getChildren().add(hbMenusor);
        vbKontener.getChildren().add(lbMoziEsemeny);
        lbMoziEsemeny.setText("Mozi Modosit");
        vbKontener.getChildren().add(cbModositMozi);
        vbKontener.getChildren().add(vbKeresMozi);
        vbKeresMozi.getChildren().remove(btTorolMozi);
        if (!vbKeresMozi.getChildren().contains(btModositMozi)) {
            vbKeresMozi.getChildren().add(btModositMozi);
        }
        vbKeresMozi.getChildren().remove(btIrMozi);

        for (Mozi m:MoziDAO.getMozi()
             ) {
            cbModositMozi.getItems().add(m.getOszlopMoziNev());
        }
        tfMoziAzon.setText("");
        tfMoziNeve.setText("");
        tfIrSzam.setText("");
        tfCim.setText("");
        tfTelefon.setText("");
        cbModositMozi.getSelectionModel().clearSelection();

    }
    public void cbAMoziKivalasz(ActionEvent event){
       if (cbModositMozi.getSelectionModel().getSelectedItem()!=null){

               for (Mozi m:MoziDAO.getMozi()
               ) {
                   if (m.getOszlopMoziNev().equals(cbModositMozi.getSelectionModel().getSelectedItem().toString())){
                       tfMoziNeve.setText(m.getOszlopMoziNev());
                       tfIrSzam.setText(""+m.getOszlopIrSzam());
                       tfCim.setText(m.getOszlopcim());
                       tfTelefon.setText(m.getOszloptelefon());
                       tfMoziAzon.setText(""+m.getOszlopMoziAzon());
                   }
               }

       }
    }
    public void btAModositMozi(ActionEvent event){
        MoziDAO alma=new MoziDAO();
        if (cbModositMozi.getSelectionModel().getSelectedItem()!=null) {

            alma.modositMozi(new Mozi(Integer.parseInt(tfMoziAzon.getText()), tfMoziNeve.getText(), Integer.parseInt(tfIrSzam.getText()), tfCim.getText(), tfTelefon.getText()));

            cbModositMozi.getItems().clear();
            cbModositMozi.setPromptText("Mozi neve");
            for (Mozi m : MoziDAO.getMozi()
            ) {
                cbModositMozi.getItems().add(m.getOszlopMoziNev());
            }
        }

    }
    public void btAMoziOlvas(ActionEvent event){
        vbKontener.getChildren().removeAll(vbKontener.getChildren());
        vbKontener.getChildren().add(hbMenusor);
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

    public void btATorolMozi(ActionEvent event) {
        MoziDAO alma=new MoziDAO();
        alma.deleteMozi(Integer.parseInt(tfMoziAzon.getText()));
       // System.out.println(Integer.parseInt(tfMoziAzon.getText()));
        cbModositMozi.getItems().clear();
        cbModositMozi.setPromptText("Mozi neve");
        for (Mozi m : MoziDAO.getMozi()
        ) {
            cbModositMozi.getItems().add(m.getOszlopMoziNev());
        }
    }
    public void btAMenuTorolMozi(ActionEvent event){
        vbKontener.getChildren().removeAll(vbKontener.getChildren());
        vbKontener.getChildren().add(hbMenusor);
        vbKontener.getChildren().add(lbMoziEsemeny);
        lbMoziEsemeny.setText("Mozi Torol");
        vbKontener.getChildren().add(cbModositMozi);
        vbKontener.getChildren().add(vbKeresMozi);
        vbKeresMozi.getChildren().remove(btModositMozi);
        vbKeresMozi.getChildren().remove(btIrMozi);
        if (!vbKeresMozi.getChildren().contains(btTorolMozi)) {
            vbKeresMozi.getChildren().add(btTorolMozi);
        }
        for (Mozi m:MoziDAO.getMozi()
        ) {
            cbModositMozi.getItems().add(m.getOszlopMoziNev());
        }
        tfMoziAzon.setText("");
        tfMoziNeve.setText("");
        tfIrSzam.setText("");
        tfCim.setText("");
        tfTelefon.setText("");
        cbModositMozi.getSelectionModel().clearSelection();

    }
    public void btAMenuIrMozi(ActionEvent event) {
        vbKontener.getChildren().removeAll(vbKontener.getChildren());
        vbKontener.getChildren().add(hbMenusor);
        vbKontener.getChildren().add(lbMoziEsemeny);
        lbMoziEsemeny.setText("Mozi ir");
        vbKontener.getChildren().add(vbKeresMozi);
        vbKeresMozi.getChildren().remove(btTorolMozi);
        vbKeresMozi.getChildren().remove(btModositMozi);
        if (!vbKeresMozi.getChildren().contains(btIrMozi)) {
            vbKeresMozi.getChildren().add(btIrMozi);
        }
        vbKeresMozi.getChildren().remove(cbModositMozi);
        tfMoziAzon.setText("");
        tfMoziNeve.setText("");
        tfIrSzam.setText("");
        tfCim.setText("");
        tfTelefon.setText("");
        cbModositMozi.getSelectionModel().clearSelection();

    }
    public void btAIrMozi(ActionEvent event) {
        MoziDAO alma=new MoziDAO();
            alma.IrMozi(new Mozi(tfMoziNeve.getText(), Integer.parseInt(tfIrSzam.getText()), tfCim.getText(), tfTelefon.getText()));


    }

    public void rbAMozikKeresoFelirat(ActionEvent event) {
    }

    public void rbAMozikKeresoSzinkron(ActionEvent event) {
    }

    public void tfAMozikKeresoFilmCim(ActionEvent event) {
    }

    public void cbAMozikKeresoMoziNev(ActionEvent event) {
    }

    public void btAMoziKeres(ActionEvent event) {

    }

    public void btAMozikKeresoKeres(ActionEvent event) {

        String szinkron="fel";
        if (rbMozikKeresoSzinkron.isSelected()){
            szinkron="fel";
        }else{
            szinkron="mb";
        }
        int szines=0;
        if (rbMozikKeresoSzinkron.isSelected()){
            szines=0;
        }else{
            szines=1;
        }
      //  System.out.println(szinkron+" "+szines);
      //  System.out.println("alma"+rbMozikKeresoSzinkron.isSelected());
       /* System.out.println("alma"+rbMozikKeresoFeliratMb.isSelected());
        System.out.println("alma"+rbMozikKeresoFelirat.isSelected());*/
        String moziNev="";
        if (cbMozikKeresoMoziNev.getSelectionModel().getSelectedItem()!=null){
            moziNev=cbMozikKeresoMoziNev.getSelectionModel().getSelectedItem().toString();
           // System.out.println("alma"+cbMozikKeresoMoziNev.getSelectionModel().getSelectedItem().toString());
        }
        String Filmcim="";
        if (!tfMozikKeresoFilmCim.getText().isEmpty()){
            Filmcim=tfMozikKeresoFilmCim.getText();
           // System.out.println("alma"+tfMozikKeresoFilmCim.getText());
        }
        MoziFilmHelyDAO.keresMoziFilmHely(moziNev,Filmcim,szinkron,szines);
        if (!vbKontener.getChildren().contains(moziFilmHelyTabla)) {
            vbKontener.getChildren().add(moziFilmHelyTabla);
        }
        System.out.println(moziNev+" "+Filmcim+" "+szinkron+" "+szines);
        moziFilmHelyTabla.setItems(MoziFilmHelyDAO.keresMoziFilmHely(moziNev,Filmcim,szinkron,szines));

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

    public void btAMenuMoziKeres(ActionEvent event) {
        vbKontener.getChildren().removeAll(vbKontener.getChildren());
        vbKontener.getChildren().add(hbMenusor);
        vbKontener.getChildren().add(btMoziKeresoresz);
        for (Mozi m : MoziDAO.getMozi()
        ) {
            cbMozikKeresoMoziNev.getItems().add(m.getOszlopMoziNev());
        }
    }

    public void rbAMozikKeresoFeliratMb(ActionEvent event) {
    }
}
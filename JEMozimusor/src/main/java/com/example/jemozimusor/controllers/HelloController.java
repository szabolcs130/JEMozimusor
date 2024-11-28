package com.example.jemozimusor.controllers;

import com.example.jemozimusor.HelloApplication;
import com.example.jemozimusor.daos.MoziFilmHelyDAO;
import com.example.jemozimusor.daos.MoziDAO;
import com.example.jemozimusor.models.MoziFilmHely;
import com.example.jemozimusor.models.Mozi;

import javafx.application.Platform;
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

import java.io.*;

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
    //public Button btMenuMoziKeres;
    public HBox btMoziKeresoresz;
    public RadioButton rbMozikKeresoFeliratMb;
    public Button btMozikKeresoKeres;
    public HBox hbCrudMelletti;
    public VBox vbParhuzamos;
    public Label lb1;
    public Label lb2;

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

        if (cbModositMozi.getItems().size()>0) {
            cbModositMozi.getItems().clear();
        }
            for (Mozi m : MoziDAO.getMozi()
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
            if (cbModositMozi.getItems().size()>0) {
                cbModositMozi.getItems().clear();
            }
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
        if (cbModositMozi.getItems().size()>0) {
            cbModositMozi.getItems().clear();
        }
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
       if (cbModositMozi.getItems().size()>0){
            cbModositMozi.getItems().clear();
        }

            for (Mozi m : MoziDAO.getMozi()
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
        String lekerdez="Where ";

      //cb SZINES
        int szines1 = -1;
        if (rbMozikKeresoSzinkron.isSelected()) {
            szines1 = 0;

        }
        lekerdez+="szines="+szines1;

//radiogombok
        String szinkron1 = "";
        if (rbMozikKeresoFelirat.isSelected() && rbMozikKeresoFeliratMb.isSelected()){
            lekerdez+=" and szinkron='fel'";

        }else{
            if (rbMozikKeresoFelirat.isSelected()) {
                szinkron1 = "fel";
                lekerdez+=" and szinkron='fel'";
            }
            if (rbMozikKeresoFeliratMb.isSelected()) {
                szinkron1 = "mb";
                lekerdez+=" and szinkron='mb'";

            }
        }



      //  System.out.println(szinkron+" "+szines);
      //  System.out.println("alma"+rbMozikKeresoSzinkron.isSelected());
       /* System.out.println("alma"+rbMozikKeresoFeliratMb.isSelected());
        System.out.println("alma"+rbMozikKeresoFelirat.isSelected());*/
        String moziNev1="";
        if (cbMozikKeresoMoziNev.getSelectionModel().getSelectedItem()!=null){
            moziNev1=cbMozikKeresoMoziNev.getSelectionModel().getSelectedItem().toString();
            lekerdez+=" and mozinev='"+moziNev1+"'";

           // System.out.println("alma"+cbMozikKeresoMoziNev.getSelectionModel().getSelectedItem().toString());
        }else{
            moziNev1="ures";
        }
        String Filmcim1="";
        if (!tfMozikKeresoFilmCim.getText().isEmpty()){

            Filmcim1=tfMozikKeresoFilmCim.getText();
            lekerdez+=" and filmcim='"+Filmcim1+"'";
           // System.out.println("alma"+tfMozikKeresoFilmCim.getText());
        }else{
            Filmcim1="ures";
        }
       // MoziFilmHelyDAO.keresMoziFilmHely(moziNev1,Filmcim1,szinkron1,szines1);
        if (!vbKontener.getChildren().contains(moziFilmHelyTabla)) {
            vbKontener.getChildren().add(moziFilmHelyTabla);
        }
       // System.out.println(moziNev1+" "+Filmcim1+" "+szinkron1+" "+szines1);

       // MoziFilmHelyDAO.keresMoziFilmHely(moziNev1,Filmcim1,szinkron1,szines1);

       // moziFilmHelyTabla.setItems(MoziFilmHelyDAO.keresMoziFilmHely(moziNev1,Filmcim1,szinkron1,szines1));
       // System.out.println(lekerdez);
        moziFilmHelyTabla.setItems(MoziFilmHelyDAO.alma(lekerdez));

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

    public void btAMenuParhuzamos(ActionEvent event) {
        vbKontener.getChildren().removeAll(vbKontener.getChildren());
        vbKontener.getChildren().add(hbMenusor);
        vbKontener.getChildren().add(vbParhuzamos);

    }

    public void btAParhuzamosIndit(ActionEvent event) {
        MyThread work2so=new MyThread();
        Thread a=new Thread(work2so);
        a.start();

        MyThread2 work2so2=new MyThread2();
        Thread a2=new Thread(work2so2);

        a2.start();
    }

    public void btSoapButtonClick(ActionEvent actionEvent) {
        try{
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "start cmd");
            Process process = builder.start();

            PrintWriter writer = new PrintWriter(new OutputStreamWriter(process.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            writer.println("Egy adatot várunk:");
            writer.flush();

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String input = userInput.readLine();

            System.out.println("Felhasználói input: " + input);
            System.out.println("Soap kliens hívása...");

            /*
            MNBAforgalomServiceSoapImpl soapClient = new MNBAforgalomServiceSoapImpl();
            String response = soapClient.getCurrentExchangeRates(input, null);
            System.out.println("SOAP válasz: " + response);
            */

        }catch (Exception e){ e.printStackTrace(); }
    }

    public void btForexButtonClick(ActionEvent actionEvent) {
        vbKontener.getChildren().removeAll(vbKontener.getChildren());
        vbKontener.getChildren().add(hbMenusor);
    }


    class MyThread implements Runnable{
        @Override
        public void run() {
            while (true){
                Platform.runLater(()->{
                    lb1.setText("Korte");});
                try {
                    ;
                    // System.out.println("Alma");
                    Thread.sleep(2000);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                Platform.runLater(()->{
                    lb1.setText("KORTE");});
                try {
                    ;
                    // System.out.println("Alma");
                    Thread.sleep(2000);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    class MyThread2 implements Runnable{
        @Override
        public void run() {
            while (true){
                Platform.runLater(()->{
                    lb2.setText("Alma");});
                try {
                    ;
                    // System.out.println("Alma");
                    Thread.sleep(1000);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                Platform.runLater(()->{
                    lb2.setText("ALMA");});
                try {
                    ;
                    // System.out.println("Alma");
                    Thread.sleep(1000);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}
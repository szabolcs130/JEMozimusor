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
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    private final String[] data = {
            "<MNBExchangeRatesQueryValues><FirstDate>1949-01-03</FirstDate><LastDate>2024-11-29</LastDate><Currencies><Curr>HUF</Curr><Curr>EUR</Curr><Curr>AUD</Curr><Curr>BGN</Curr><Curr>BRL</Curr><Curr>CAD</Curr><Curr>CHF</Curr><Curr>CNY</Curr><Curr>CZK</Curr><Curr>DKK</Curr><Curr>GBP</Curr><Curr>HKD</Curr><Curr>HRK</Curr><Curr>IDR</Curr><Curr>ILS</Curr><Curr>INR</Curr><Curr>ISK</Curr><Curr>JPY</Curr><Curr>KRW</Curr><Curr>MXN</Curr><Curr>MYR</Curr><Curr>NOK</Curr><Curr>NZD</Curr><Curr>PHP</Curr><Curr>PLN</Curr><Curr>RON</Curr><Curr>RSD</Curr><Curr>RUB</Curr><Curr>SEK</Curr><Curr>SGD</Curr><Curr>THB</Curr><Curr>TRY</Curr><Curr>UAH</Curr><Curr>USD</Curr><Curr>ZAR</Curr><Curr>ATS</Curr><Curr>AUP</Curr><Curr>BEF</Curr><Curr>BGL</Curr><Curr>CSD</Curr><Curr>CSK</Curr><Curr>DDM</Curr><Curr>DEM</Curr><Curr>EEK</Curr><Curr>EGP</Curr><Curr>ESP</Curr><Curr>FIM</Curr><Curr>FRF</Curr><Curr>GHP</Curr><Curr>GRD</Curr><Curr>IEP</Curr><Curr>ITL</Curr><Curr>KPW</Curr><Curr>KWD</Curr><Curr>LBP</Curr><Curr>LTL</Curr><Curr>LUF</Curr><Curr>LVL</Curr><Curr>MNT</Curr><Curr>NLG</Curr><Curr>OAL</Curr><Curr>OBL</Curr><Curr>OFR</Curr><Curr>ORB</Curr><Curr>PKR</Curr><Curr>PTE</Curr><Curr>ROL</Curr><Curr>SDP</Curr><Curr>SIT</Curr><Curr>SKK</Curr><Curr>SUR</Curr><Curr>VND</Curr><Curr>XEU</Curr><Curr>XTR</Curr><Curr>YUD</Curr></Currencies></MNBExchangeRatesQueryValues>",
            "<MNBCurrentExchangeRates><Day date=\"2024-11-29\"><Rate unit=\"1\" curr=\"AUD\">254,66000</Rate><Rate unit=\"1\" curr=\"BGN\">211,22000</Rate><Rate unit=\"1\" curr=\"BRL\">65,05000</Rate><Rate unit=\"1\" curr=\"CAD\">279,50000</Rate><Rate unit=\"1\" curr=\"CHF\">444,05000</Rate><Rate unit=\"1\" curr=\"CNY\">54,05000</Rate><Rate unit=\"1\" curr=\"CZK\">16,36000</Rate><Rate unit=\"1\" curr=\"DKK\">55,39000</Rate><Rate unit=\"1\" curr=\"EUR\">413,13000</Rate><Rate unit=\"1\" curr=\"GBP\">496,68000</Rate><Rate unit=\"1\" curr=\"HKD\">50,27000</Rate><Rate unit=\"100\" curr=\"IDR\">2,47000</Rate><Rate unit=\"1\" curr=\"ILS\">107,44000</Rate><Rate unit=\"1\" curr=\"INR\">4,63000</Rate><Rate unit=\"1\" curr=\"ISK\">2,84000</Rate><Rate unit=\"100\" curr=\"JPY\">260,57000</Rate><Rate unit=\"100\" curr=\"KRW\">28,03000</Rate><Rate unit=\"1\" curr=\"MXN\">19,16000</Rate><Rate unit=\"1\" curr=\"MYR\">88,03000</Rate><Rate unit=\"1\" curr=\"NOK\">35,31000</Rate><Rate unit=\"1\" curr=\"NZD\">231,41000</Rate><Rate unit=\"1\" curr=\"PHP\">6,67000</Rate><Rate unit=\"1\" curr=\"PLN\">95,96000</Rate><Rate unit=\"1\" curr=\"RON\">83,00000</Rate><Rate unit=\"1\" curr=\"RSD\">3,53000</Rate><Rate unit=\"1\" curr=\"RUB\">3,62000</Rate><Rate unit=\"1\" curr=\"SEK\">35,88000</Rate><Rate unit=\"1\" curr=\"SGD\">291,97000</Rate><Rate unit=\"1\" curr=\"THB\">11,40000</Rate><Rate unit=\"1\" curr=\"TRY\">11,28000</Rate><Rate unit=\"1\" curr=\"UAH\">9,41000</Rate><Rate unit=\"1\" curr=\"USD\">391,30000</Rate><Rate unit=\"1\" curr=\"ZAR\">21,65000</Rate></Day></MNBCurrentExchangeRates>",
            "<MNBExchangeRates><Day date=\"2022-09-14\"><Rate unit=\"1\" curr=\"EUR\">402,09</Rate></Day><Day date=\"2022-09-13\"><Rate unit=\"1\" curr=\"EUR\">396,42</Rate></Day><Day date=\"2022-09-12\"><Rate unit=\"1\" curr=\"EUR\">395,06</Rate></Day><Day date=\"2022-09-09\"><Rate unit=\"1\" curr=\"EUR\">395,48</Rate></Day><Day date=\"2022-09-08\"><Rate unit=\"1\" curr=\"EUR\">397,57</Rate></Day><Day date=\"2022-09-07\"><Rate unit=\"1\" curr=\"EUR\">401,49</Rate></Day><Day date=\"2022-09-06\"><Rate unit=\"1\" curr=\"EUR\">403,34</Rate></Day><Day date=\"2022-09-05\"><Rate unit=\"1\" curr=\"EUR\">403,83</Rate></Day><Day date=\"2022-09-02\"><Rate unit=\"1\" curr=\"EUR\">398,96</Rate></Day><Day date=\"2022-09-01\"><Rate unit=\"1\" curr=\"EUR\">401,28</Rate></Day><Day date=\"2022-08-31\"><Rate unit=\"1\" curr=\"EUR\">405,11</Rate></Day><Day date=\"2022-08-30\"><Rate unit=\"1\" curr=\"EUR\">407,29</Rate></Day><Day date=\"2022-08-29\"><Rate unit=\"1\" curr=\"EUR\">410,80</Rate></Day><Day date=\"2022-08-26\"><Rate unit=\"1\" curr=\"EUR\">409,00</Rate></Day><Day date=\"2022-08-25\"><Rate unit=\"1\" curr=\"EUR\">408,35</Rate></Day><Day date=\"2022-08-24\"><Rate unit=\"1\" curr=\"EUR\">411,24</Rate></Day><Day date=\"2022-08-23\"><Rate unit=\"1\" curr=\"EUR\">410,88</Rate></Day><Day date=\"2022-08-22\"><Rate unit=\"1\" curr=\"EUR\">405,83</Rate></Day><Day date=\"2022-08-19\"><Rate unit=\"1\" curr=\"EUR\">406,85</Rate></Day><Day date=\"2022-08-18\"><Rate unit=\"1\" curr=\"EUR\">405,05</Rate></Day><Day date=\"2022-08-17\"><Rate unit=\"1\" curr=\"EUR\">406,92</Rate></Day><Day date=\"2022-08-16\"><Rate unit=\"1\" curr=\"EUR\">404,01</Rate></Day><Day date=\"2022-08-15\"><Rate unit=\"1\" curr=\"EUR\">397,33</Rate></Day></MNBExchangeRates>"
    };

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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Szolgáltatás nem elérhető");
        alert.setHeaderText(null);  // Nincs fejléc
        alert.setContentText("Ez a szolgáltatás jelenleg nem elérhető.");

        alert.showAndWait();
    }

    @FXML
    private void btForexButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/jemozimusor/forex-window.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Forex Trades");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void btSoapLetoltesAction(ActionEvent event) {
        try {
            Path path = Paths.get("MNB.txt");
            String combined = String.join("\n", data);
            Files.write(path, combined.getBytes(StandardCharsets.UTF_8));
            System.out.println("Fájl sikeresen letöltve: " + path.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void btSoapLetoltes2Action(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/jemozimusor/soap-form.fxml"));
            Parent root = fxmlLoader.load();
            //Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("SOAP Űrlap");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Valami hiba történt a SOAP form megnyitása során");
        }
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
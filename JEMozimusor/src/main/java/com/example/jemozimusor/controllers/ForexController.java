package com.example.jemozimusor.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ForexController {

    @FXML
    private ListView<String> listViewTrades;

    @FXML
    private ComboBox<String> comboBoxPairs;

    @FXML
    private TextField textFieldAmount;

    private final String[] tradeData = {
            "535 USD_CHF 2024-11-25T09:25:24.586850332Z -6 0.89005 0.0427",
            "531 AUD_USD 2024-11-25T09:25:03.064547543Z 5 0.65106 -0.0004",
            "529 EUR_GBP 2024-11-25T09:24:53.940751335Z -9 0.83337 0.0208",
            "527 GBP_USD 2024-11-25T09:24:40.591365716Z 6 1.25711 0.0736",
            "525 USD_JPY 2024-11-25T09:23:01.369362152Z 2 154.625 -0.0521",
            "521 EUR_USD 2024-11-25T08:54:46.176403684Z 3 1.04573 0.0279",
            "519 AUD_JPY 2024-11-24T22:04:55.022601580Z -1 100.718 0.0161",
            "507 AUD_CAD 2024-11-19T09:20:33.530057183Z 3 0.91082 0.0015",
            "505 AUD_JPY 2024-11-19T09:19:48.244637138Z -5 99.762 0.0554",
            "490 NZD_USD 2024-11-12T14:04:07.809026566Z -10 0.59428 0.0073",
            "486 CHF_JPY 2024-11-12T13:11:12.181510506Z -5 174.972 0.1291",
            "484 EUR_AUD 2024-11-12T13:09:40.852344361Z 1 1.62064 0.0008",
            "39 AUD_NZD 2023-10-06T19:04:12.713382583Z 10 1.06607 0.1535",
            "5 EUR_USD 2023-10-06T18:01:41.689591009Z 3 1.05891 -0.0030"
    };

    @FXML
    private void handlePrintTrades() {
        System.out.println("Open trades:");
        for (String trade : listViewTrades.getItems()) {
            System.out.println(trade);
        }
    }

    @FXML
    private void handleOpenPosition() {
        String selectedPair = comboBoxPairs.getValue();
        String amount = textFieldAmount.getText();

        if (selectedPair != null && !amount.isEmpty()) {
            String newTrade = "Opened position: " + selectedPair + " - " + amount;
            listViewTrades.getItems().add(newTrade);
            System.out.println(newTrade);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a pair and enter an amount!");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleLoadOpenTrades() {

        listViewTrades.getItems().clear();
        for (String trade : tradeData) {
            listViewTrades.getItems().add(trade);  
        }
    }
}

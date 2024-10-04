package com.example.jemozimusor.daos;

import com.example.jemozimusor.models.Mozi;
import com.example.jemozimusor.models.MoziFilmHely;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoziDAO {
    private static final String tablaNevMozi="mozi";
    private static final String oszlopMoziAzon="moziazon";
    private static final String oszlopMoziNev="mozinev";
    private static final String oszlopIrSzam="irszam";
    private static final String oszlopcim="cim";
    private static final String oszloptelefon="telefon";
    private static final ObservableList<Mozi> mozi;
    static{
        mozi= FXCollections.observableArrayList();
        feltoltMozi();
    }


    public static ObservableList<Mozi> getMozi(){
        return FXCollections.unmodifiableObservableList(mozi);
    }
    private static void feltoltMozi() {
        try {
            Connection connection=Database.connect();

            String query="SELECT * FROM "+tablaNevMozi;
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            mozi.clear();
            while (rs.next()) {
                mozi.add(new Mozi(
                        rs.getInt(oszlopMoziAzon),
                        rs.getString(oszlopMoziNev),
                        rs.getInt(oszlopIrSzam),
                        rs.getString(oszlopcim),
                        rs.getString(oszloptelefon)));
            }
        }catch (SQLException e){
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": Could not load Persons from database ");
            mozi.clear();
        }
    }
}

package com.example.jemozimusor.daos;

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

public class MoziFilmHelyDAO {
    private static final String tablaNevMozi="mozi";
    private static final String oszlopMoziAzon="moziazon";
    private static final String oszlopMoziNev="mozinev";
    private static final String oszlopIrSzam="irszam";
    private static final String oszlopcim="cim";
    private static final String oszloptelefon="telefon";
    private static final String tablaNevFilm="film";
    private static final String oszlopFKod="fkod";
    private static final String oszlopFilmCim="filmcim";
    private static final String oszlopSzines="szines";
    private static final String oszlopSzinkron="szinkron";
    private static final String oszlopSzarmazas="szarmazas";
    private static final String oszlopMufaj="mufaj";
    private static final String oszlopHossz="hossz";
    private static final String tablaNevhely="hely";
    private static final String oszlopHelyFKod="fkod";
    private static final String oszlopHelyMoziAzon="moziazon";


    public static final ObservableList<MoziFilmHely> keresMoziFilmHely;
    static{
        keresMoziFilmHely=FXCollections.observableArrayList();

    }
    public static ObservableList<MoziFilmHely> getKeresMoziFilmHely(){
        return FXCollections.unmodifiableObservableList(keresMoziFilmHely);
    }

    private static final ObservableList<MoziFilmHely> moziFilmHely;
    static{
        moziFilmHely=FXCollections.observableArrayList();
        feltoltMoziFilmHely();
    }


    public static ObservableList<MoziFilmHely> getMoziFilmHely(){
        return FXCollections.unmodifiableObservableList(moziFilmHely);
    }
    private static void feltoltMoziFilmHely() {
        try {
            Connection connection=Database.connect();

            String query="SELECT * FROM "+tablaNevMozi +" inner join "+tablaNevhely+" on  "+tablaNevMozi+"."+oszlopMoziAzon+"="+
                    tablaNevhely+"."+oszlopHelyMoziAzon+" inner join "+tablaNevFilm+" on "+tablaNevhely+"."+oszlopHelyFKod+"="+tablaNevFilm+"."+oszlopFKod;
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            moziFilmHely.clear();
            while (rs.next()) {
                moziFilmHely.add(new MoziFilmHely(
                        rs.getInt(oszlopMoziAzon),
                        rs.getString(oszlopMoziNev),
                        rs.getInt(oszlopIrSzam),
                        rs.getString(oszlopcim),
                        rs.getString(oszloptelefon),
                        rs.getInt(oszlopFKod),
                        rs.getString(oszlopFilmCim),
                        rs.getInt(oszlopSzines),
                        rs.getString(oszlopSzinkron),
                        rs.getString(oszlopSzarmazas),
                        rs.getString(oszlopMufaj),
                        rs.getInt(oszlopHossz),
                        rs.getInt(oszlopHelyFKod),
                        rs.getInt(oszlopHelyMoziAzon)));
            }
        }catch (SQLException e){
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": MoziFilmHely adatai nem kerult betoltesre az adatbazisbol ");
            moziFilmHely.clear();
        }
    }
    private static void getMoziNev() {
        try {
            Connection connection=Database.connect();

            String query="SELECT * FROM "+tablaNevMozi;
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            moziFilmHely.clear();
            while (rs.next()) {
                moziFilmHely.add(new MoziFilmHely(
                        rs.getInt(oszlopMoziAzon),
                        rs.getString(oszlopMoziNev),
                        rs.getInt(oszlopIrSzam),
                        rs.getString(oszlopcim),
                        rs.getString(oszloptelefon),
                        rs.getInt(oszlopFKod),
                        rs.getString(oszlopFilmCim),
                        rs.getInt(oszlopSzines),
                        rs.getString(oszlopSzinkron),
                        rs.getString(oszlopSzarmazas),
                        rs.getString(oszlopMufaj),
                        rs.getInt(oszlopHossz),
                        rs.getInt(oszlopHelyFKod),
                        rs.getInt(oszlopHelyMoziAzon)));
            }
        }catch (SQLException e){
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": Could not load Persons from database ");
            moziFilmHely.clear();
        }
    }
    public static ObservableList<MoziFilmHely> keresMoziFilmHely(String moziNev,String FilmCim,String szinkron,int szines){
       // keresMoziFilmHely.clear();
        for (MoziFilmHely m: moziFilmHely
             ) {
            if ((!(moziNev.isEmpty()) && m.getOszlopMoziNev().equals(moziNev))
                    && (!(FilmCim.isEmpty()) && m.getOszlopFilmCim().equals(FilmCim))
            &&(!(szinkron.isEmpty()) && m.getOszlopSzinkron().equals(szinkron))
            && (m.getOszlopSzines()==szines)){

                keresMoziFilmHely.add(new MoziFilmHely(m.getOszlopMoziAzon(),m.getOszlopMoziNev(),m.getOszlopIrSzam(),m.getOszlopcim(),m.getOszloptelefon(),
                        m.getOszlopFKod(),m.getOszlopFilmCim(),m.getOszlopSzines(),m.getOszlopSzinkron(),m.getOszlopSzarmazas(),
                        m.getOszlopMufaj(),m.getOszlopHossz(),m.getOszlopHelyFKod(),m.getOszlopHelyMoziAzon()));
                System.out.println(m);
            }
        }
        return keresMoziFilmHely;
    }

}

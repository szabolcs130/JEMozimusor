package com.example.jemozimusor.daos;

import com.example.jemozimusor.controllers.HelloController;
import com.example.jemozimusor.models.Mozi;
import com.example.jemozimusor.models.MoziFilmHely;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;
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
            statement.close();
            connection.close();
        }catch (SQLException e){
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": Mozi adatai nem kerult betoltesre az adatbazisbol ");
            mozi.clear();
        }
    }
    public void modositMozi(Mozi ujMozi){
       try {
           Connection connection=Database.connect();
           String query="UPDATE " + tablaNevMozi + " SET " +
                   oszlopMoziNev + " = ? , " +
                   oszlopIrSzam + " = ? , " +
                   oszlopcim + " = ? , " +
                   oszloptelefon + " = ? " +
                   "WHERE " + oszlopMoziAzon + " = ?";
          /* String query="UPDATE "+tablaNevMozi+" SET "+tablaNevMozi+"."+oszlopMoziNev+"=? , "+
                   tablaNevMozi+"."+oszlopIrSzam+"=? , "+
                   tablaNevMozi+"."+oszlopcim+"=? , "+
                   tablaNevMozi+"."+oszloptelefon+"=?"+" WHERE "+tablaNevMozi+"."+oszlopMoziAzon+"=?";*/
           PreparedStatement statement = connection.prepareStatement(query);
           statement.setString(1,ujMozi.getOszlopMoziNev());
           statement.setInt(2,ujMozi.getOszlopIrSzam());
           statement.setString(3,ujMozi.getOszlopcim());
           statement.setString(4,ujMozi.getOszloptelefon());
           statement.setInt(5,ujMozi.getOszlopMoziAzon());


           int rs = statement.executeUpdate();
           if (rs < 0) {
               Logger.getAnonymousLogger().log(
                       Level.INFO,
                       LocalDateTime.now() + ": Mozi adatait nem sikerult módosítottuk az adatbázisban..");
           }



           Optional<Mozi> optionalMozi=getMozi(ujMozi.getOszlopMoziAzon());
           optionalMozi.ifPresentOrElse((regiMozi)-> {
               mozi.remove(regiMozi);
               mozi.add(ujMozi);
           },()->{
               throw new IllegalStateException("Mozi adatait nem sikerult modositani a felhasznalo nezetben");
           });

           statement.close();
           connection.close();

       }catch (SQLException e){
           Logger.getAnonymousLogger().log(
                   Level.SEVERE,
                   LocalDateTime.now() + ": Mozi adatai nem kerult modositani az adatbazisban ");
       }
    }
    public static Optional<Mozi> getMozi(int id){
        for (Mozi m: mozi){
            if (m.getOszlopMoziAzon()==id)
            {
                return Optional.of(m);
            }
        }
        return Optional.empty();
    }
    public void deleteMozi(int id) {
        try {
            Connection connection = Database.connect();
            String query = "DELETE FROM " + tablaNevMozi + " WHERE " + oszlopMoziAzon + " = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            int db= statement.executeUpdate();
            if (db<1) {
                System.out.println("Nem sikerult torolni a mozit.");
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": Mozi adatai nem kerultek torlesre az adatbazisbol");
        }

        Optional<Mozi> moziTorol=getMozi(id);
        moziTorol.ifPresent(mozi::remove);
    }

    public void IrMozi(Mozi ujMozi){
        try {
            Connection connection=Database.connect();
            String query="Insert into " + tablaNevMozi + " (mozinev,irszam,cim,telefon) Values(?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,ujMozi.getOszlopMoziNev());
            statement.setInt(2,ujMozi.getOszlopIrSzam());
            statement.setString(3,ujMozi.getOszlopcim());
            statement.setString(4,ujMozi.getOszloptelefon());


            int rs = statement.executeUpdate();
            if (rs < 0) {
                Logger.getAnonymousLogger().log(
                        Level.INFO,
                        LocalDateTime.now() + ": Mozi adatait nem sikerult beilleszteni az adatbázisban..");
            }
            statement.close();
            connection.close();

        }catch (SQLException e){
            Logger.getAnonymousLogger().log(
                    Level.SEVERE,
                    LocalDateTime.now() + ": Mozi adatai nem kerult beilleszteni az adatbazisban ");
        }

    }


}

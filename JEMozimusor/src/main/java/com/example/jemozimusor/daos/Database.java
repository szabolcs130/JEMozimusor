package com.example.jemozimusor.daos;

import com.example.jemozimusor.HelloApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private static  String location = HelloApplication.class.getResource("mozimusor.db").toExternalForm();


    public static boolean isOK() {
        if (!checkDrivers()) return false;

        if (!checkConnection()) return false;

        return checkTables();
    }

    private static boolean checkDrivers() {
        try {
            Class.forName("org.sqlite.JDBC");
            DriverManager.registerDriver(new org.sqlite.JDBC());
            return true;
        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            Logger.getAnonymousLogger().log(Level.SEVERE, LocalDateTime.now() + ": Nincs SQLite driver");
            return false;
        }
    }

    private static boolean checkConnection() {
        try (Connection connection = connect()) {
            return connection != null;
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, LocalDateTime.now() + ": Adatbazis kapcsolat ellenorzes sikertelen");
            return false;
        }
    }

    private static boolean checkTables() {

        return true;
    }

    public static Connection connect() {

       /* dbpath="jdbc:sqlite:"+SQLiteExampleApp.class.getResource("database/database.db");
        dbpath="jdbc:sqlite::resource:com/edencoding/database/database.db";
        //connection = DriverManager.getConnection("jdbc:sqlite:file:/C:/Users/User/Downloads/javafx3/javafx-io-master/sqlite/target/classes/com/edencoding/database/database.db");
        connection = DriverManager.getConnection(dbpath);
        System.out.println(SQLiteExampleApp.class.getResource("database/database.db"));
        System.out.println("jdbc:sqliteR"+SQLiteExampleApp.class.getResource("database/database.db").toExternalForm());
//jdbc:sqlite:jar:file:/C:/Users/User/Downloads/javafx3/javafx-io-master/sqlite/out/artifacts/sqlite_jar/sqlite.jar!.com/edencoding/database/database.db
*/
        /**/
        // String dbPrefix = "jdbc:sqlite::resource:com/example/javafx1/database/database.db";
        Connection connection;
        String dbPrefix = "jdbc:sqlite:";
        location="C:/Users/Alma/Downloads/1_JavaBeadandoEloadas/mozimusor.db";
        try {
            connection = DriverManager.getConnection(dbPrefix+location);
        } catch (SQLException exception) {
            Logger.getAnonymousLogger().log(Level.SEVERE,
                    LocalDateTime.now() + ": Nem sikerult kapcsolodni az adatbazishoz " );
            return null;
        }
        return connection;
    }

}

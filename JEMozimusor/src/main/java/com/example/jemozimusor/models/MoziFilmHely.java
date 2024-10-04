package com.example.jemozimusor.models;

import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class MoziFilmHely {
    private  final ReadOnlyIntegerProperty oszlopMoziAzon;
    private  final ReadOnlyStringProperty oszlopMoziNev;
    private  final ReadOnlyIntegerProperty oszlopIrSzam;
    private  final ReadOnlyStringProperty oszlopcim;
    private  final ReadOnlyStringProperty oszloptelefon;

    private  final ReadOnlyIntegerProperty oszlopFKod;
    private  final ReadOnlyStringProperty oszlopFilmCim;
    private  final ReadOnlyIntegerProperty oszlopSzines;
    private  final ReadOnlyStringProperty oszlopSzinkron;
    private  final ReadOnlyStringProperty oszlopSzarmazas;
    private  final ReadOnlyStringProperty oszlopMufaj;
    private  final ReadOnlyIntegerProperty oszlopHossz;
    private  final ReadOnlyIntegerProperty oszlopHelyMoziAzon;
    private  final ReadOnlyIntegerProperty oszlopHelyFKod;




    public int getOszlopMoziAzon() {
        return oszlopMoziAzon.get();
    }

    public ReadOnlyIntegerProperty oszlopMoziAzonProperty() {
        return oszlopMoziAzon;
    }

    public String getOszlopMoziNev() {
        return oszlopMoziNev.get();
    }

    public ReadOnlyStringProperty oszlopMoziNevProperty() {
        return oszlopMoziNev;
    }

    public int getOszlopIrSzam() {
        return oszlopIrSzam.get();
    }

    public ReadOnlyIntegerProperty oszlopIrSzamProperty() {
        return oszlopIrSzam;
    }

    public String getOszlopcim() {
        return oszlopcim.get();
    }

    public int getOszlopHelyMoziAzon() {
        return oszlopHelyMoziAzon.get();
    }

    public ReadOnlyIntegerProperty oszlopHelyMoziAzonProperty() {
        return oszlopHelyMoziAzon;
    }

    public int getOszlopHelyFKod() {
        return oszlopHelyFKod.get();
    }

    public ReadOnlyIntegerProperty oszlopHelyFKodProperty() {
        return oszlopHelyFKod;
    }

    public ReadOnlyStringProperty oszlopcimProperty() {
        return oszlopcim;
    }

    public String getOszloptelefon() {
        return oszloptelefon.get();
    }

    public ReadOnlyStringProperty oszloptelefonProperty() {
        return oszloptelefon;
    }

    public int getOszlopFKod() {
        return oszlopFKod.get();
    }

    public ReadOnlyIntegerProperty oszlopFKodProperty() {
        return oszlopFKod;
    }

    public String getOszlopFilmCim() {
        return oszlopFilmCim.get();
    }

    public ReadOnlyStringProperty oszlopFilmCimProperty() {
        return oszlopFilmCim;
    }

    public int getOszlopSzines() {
        return oszlopSzines.get();
    }

    public ReadOnlyIntegerProperty oszlopSzinesProperty() {
        return oszlopSzines;
    }

    public String getOszlopSzinkron() {
        return oszlopSzinkron.get();
    }

    public ReadOnlyStringProperty oszlopSzinkronProperty() {
        return oszlopSzinkron;
    }

    public String getOszlopSzarmazas() {
        return oszlopSzarmazas.get();
    }

    public ReadOnlyStringProperty oszlopSzarmazasProperty() {
        return oszlopSzarmazas;
    }

    public String getOszlopMufaj() {
        return oszlopMufaj.get();
    }

    public ReadOnlyStringProperty oszlopMufajProperty() {
        return oszlopMufaj;
    }

    public int getOszlopHossz() {
        return oszlopHossz.get();
    }

    public ReadOnlyIntegerProperty oszlopHosszProperty() {
        return oszlopHossz;
    }

    @Override
    public String toString() {
        return "MoziFilmHely{" +
                "oszlopMoziAzon=" + oszlopMoziAzon +
                ", oszlopMoziNev=" + oszlopMoziNev +
                ", oszlopIrSzam=" + oszlopIrSzam +
                ", oszlopcim=" + oszlopcim +
                ", oszloptelefon=" + oszloptelefon +
                ", oszlopFKod=" + oszlopFKod +
                ", oszlopFilmCim=" + oszlopFilmCim +
                ", oszlopSzines=" + oszlopSzines +
                ", oszlopSzinkron=" + oszlopSzinkron +
                ", oszlopSzarmazas=" + oszlopSzarmazas +
                ", oszlopMufaj=" + oszlopMufaj +
                ", oszlopHossz=" + oszlopHossz +
                ", oszlopHelyMoziAzon=" + oszlopHelyMoziAzon +
                ", oszlopHelyFKod=" + oszlopHelyFKod +
                '}';
    }

    public MoziFilmHely(int oszlopMoziAzon,
                        String oszlopMoziNev,
                        int oszlopIrSzam,
                        String oszlopcim,
                        String oszloptelefon,
                        int oszlopFKod,
                        String oszlopFilmCim,
                        int oszlopSzines,
                        String oszlopSzinkron,
                        String oszlopSzarmazas,
                        String oszlopMufaj,
                        int oszlopHossz,
                        int oszlopHelyFKod,
                        int oszlopHelyMoziAzon) {
        this.oszlopMoziAzon = new SimpleIntegerProperty(oszlopMoziAzon);
        this.oszlopMoziNev = new SimpleStringProperty(oszlopMoziNev);
        this.oszlopIrSzam = new SimpleIntegerProperty(oszlopIrSzam);
        this.oszlopcim = new SimpleStringProperty(oszlopcim);
        this.oszloptelefon = new SimpleStringProperty(oszloptelefon);
        this.oszlopFKod = new SimpleIntegerProperty(oszlopFKod);
        this.oszlopFilmCim = new SimpleStringProperty(oszlopFilmCim);
        this.oszlopSzines = new SimpleIntegerProperty(oszlopSzines);
        this.oszlopSzinkron = new SimpleStringProperty(oszlopSzinkron);
        this.oszlopSzarmazas = new SimpleStringProperty(oszlopSzarmazas);
        this.oszlopMufaj = new SimpleStringProperty(oszlopMufaj);
        this.oszlopHossz = new SimpleIntegerProperty(oszlopHossz);
        this.oszlopHelyFKod=new SimpleIntegerProperty(oszlopHelyFKod);
        this.oszlopHelyMoziAzon=new SimpleIntegerProperty(oszlopHelyMoziAzon);

    }
}

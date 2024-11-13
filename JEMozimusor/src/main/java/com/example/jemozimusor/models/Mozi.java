package com.example.jemozimusor.models;

import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyStringProperty;

public class Mozi {
    private  int oszlopMoziAzon;
    private  String oszlopMoziNev;
    private  int oszlopIrSzam;
    private  String oszlopcim;
    private  String oszloptelefon;

    public int getOszlopMoziAzon() {
        return oszlopMoziAzon;
    }

    public void setOszlopMoziAzon(int oszlopMoziAzon) {
        this.oszlopMoziAzon = oszlopMoziAzon;
    }

    public String getOszlopMoziNev() {
        return oszlopMoziNev;
    }

    public void setOszlopMoziNev(String oszlopMoziNev) {
        this.oszlopMoziNev = oszlopMoziNev;
    }

    public int getOszlopIrSzam() {
        return oszlopIrSzam;
    }

    public void setOszlopIrSzam(int oszlopIrSzam) {
        this.oszlopIrSzam = oszlopIrSzam;
    }

    public String getOszlopcim() {
        return oszlopcim;
    }

    public void setOszlopcim(String oszlopcim) {
        this.oszlopcim = oszlopcim;
    }

    public String getOszloptelefon() {
        return oszloptelefon;
    }

    public void setOszloptelefon(String oszloptelefon) {
        this.oszloptelefon = oszloptelefon;
    }

    public Mozi(int oszlopMoziAzon, String oszlopMoziNev, int oszlopIrSzam, String oszlopcim, String oszloptelefon) {
        this.oszlopMoziAzon = oszlopMoziAzon;
        this.oszlopMoziNev = oszlopMoziNev;
        this.oszlopIrSzam = oszlopIrSzam;
        this.oszlopcim = oszlopcim;
        this.oszloptelefon = oszloptelefon;
    }

    @Override
    public String toString() {
        return "Mozi{" +
                "oszlopMoziAzon=" + oszlopMoziAzon +
                ", oszlopMoziNev='" + oszlopMoziNev + '\'' +
                ", oszlopIrSzam=" + oszlopIrSzam +
                ", oszlopcim='" + oszlopcim + '\'' +
                ", oszloptelefon='" + oszloptelefon + '\'' +
                '}';
    }

    public Mozi(String oszlopMoziNev, int oszlopIrSzam, String oszlopcim, String oszloptelefon) {

        this.oszlopMoziNev = oszlopMoziNev;
        this.oszlopIrSzam = oszlopIrSzam;
        this.oszlopcim = oszlopcim;
        this.oszloptelefon = oszloptelefon;
    }
}

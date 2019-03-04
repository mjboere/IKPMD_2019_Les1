package boere.a2019_college1.models;

import java.io.Serializable;

public class Car implements Serializable {
    private String kleur;
    private String merk;
    private String type;
    private String aantalDeuren;


    private String prijs;

    public Car (String kleur, String merk, String type, String aantalDeuren, String prijs){
        this.kleur = kleur;
        this.merk = merk;
        this.type = type;
        this.aantalDeuren = aantalDeuren;
        this.prijs = prijs;
    }

    public Car(){
    }

    // GETTERS
    // SETTERS

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAantalDeuren() {
        return aantalDeuren;
    }

    public void setAantalDeuren(String aantalDeuren) {
        this.aantalDeuren = aantalDeuren;
    }

    public String getPrijs() {
        return prijs;
    }

    public void setPrijs(String prijs) {
        this.prijs = prijs;
    }



}

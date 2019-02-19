package boere.a2019_college1.models;

import java.io.Serializable;

public class Car implements Serializable {

    private String kleur;
    private String merk;
    private String type;
    private String aantalDeuren;

    public Car (String kleur, String merk, String type, String aantalDeuren){
        this.kleur = kleur;
        this.merk = merk;
        this.type = type;
        this.aantalDeuren = aantalDeuren;
    }

    public Car(){
    }

    // GETTERS
    // SETTERS
}

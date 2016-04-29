package com.example.segvr.healthydog.healthy;

/**
 * Created by Patrick on 29.04.16.
 */
public class KatRezepte {
    private String nameRez;
    private int iconID;
    private int zuZeit;


    public KatRezepte(String nameRez, int iconID) {
        super();
        this.nameRez = nameRez;
        this.iconID = iconID;
    }

    public String getNameRez() {
        return nameRez;
    }

    public int getIconID() {
        return iconID;
    }
}
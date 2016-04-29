package com.example.segvr.healthydog.healthy;


public class KatRezepte {
    private String nameRez;
    private int iconID;


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
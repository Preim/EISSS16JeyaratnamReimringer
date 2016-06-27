package com.example.preim.healthydog;

import javax.microedition.khronos.opengles.GL;

public class Globals {
    private static Globals instance;


    // Global variable
    private String ipAdress = "192.168.0.102:1000";

    // Restrict the constructor from being instantiated
    private Globals(){}

    public void setData(String d){
        this.ipAdress=d;
    }
    public String getData(){
        return this.ipAdress;
    }

    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
        }
        return instance;
    }
}

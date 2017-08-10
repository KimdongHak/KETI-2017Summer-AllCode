package com.example.c.myapplication;

/**
 * Created by c on 2017-06-30.
 */

public class Item {
    private String Train;
    private String T1ID;
    private String T2ID;
    private String T3ID;
    private String T4ID;
    private String T1TEMP;
    private String T2TEMP;
    private String T3TEMP;
    private String T4TEMP;
    private String T1HUM;
    private String T2HUM;
    private String T3HUM;
    private String T4HUM;
    private String Location;
    private String work;

    public  Item(String Train, String T1ID, String T2ID, String T3ID, String T4ID, String T1TEMP, String T2TEMP, String T3TEMP, String T4TEMP, String T1HUM, String T2HUM, String T3HUM, String T4HUM, String Location, String work) {
        super();
        this.Train = Train;
        this.T1ID = T1ID;
        this.T2ID = T2ID;
        this.T3ID = T3ID;
        this.T4ID = T4ID;
        this.T1TEMP = T1TEMP;
        this.T2TEMP = T2TEMP;
        this.T3TEMP = T3TEMP;
        this.T4TEMP = T4TEMP;
        this.T1HUM = T1HUM;
        this.T2HUM = T2HUM;
        this.T3HUM = T3HUM;
        this.T4HUM = T4HUM;
        this.Location = Location;
        this.work = work;
    }

    public String getTrain() {
        return this.Train;
    }

    public String getT1ID() {
        return this.T1ID;
    }

    public String getT2ID() {
        return this.T2ID;
    }

    public String getT3ID() {
        return this.T3ID;
    }

    public String getT4ID() {
        return this.T4ID;
    }

    public String getT1TEMP() {
        return this.T1TEMP;
    }

    public String getT2TEMP() {
        return this.T2TEMP;
    }

    public String getT3TEMP() {
        return this.T3TEMP;
    }

    public String getT4TEMP() {
        return this.T4TEMP;
    }

    public String getT1HUM() {
        return this.T1HUM;
    }

    public String getT2HUM() {
        return this.T2HUM;
    }

    public String getT3HUM() {
        return this.T3HUM;
    }

    public String getT4HUM() {
        return this.T4HUM;
    }

    public String getLocation() {
        return this.Location;
    }

    public String getWork() {
        return this.work;
    }
}

package com.example.c.myapplication;

/**
 * Created by c on 2017-06-30.
 */

public class Item {
    private int Train;
    private int T1ID;
    private int T2ID;
    private int T3ID;
    private int T4ID;
    private int T1TEMP;
    private int T2TEMP;
    private int T3TEMP;
    private int T4TEMP;
    private int T1HUM;
    private int T2HUM;
    private int T3HUM;
    private int T4HUM;
    private int Location;
    private int work;

    public  Item(int Train, int T1ID, int T2ID, int T3ID, int T4ID, int T1TEMP, int T2TEMP, int T3TEMP, int T4TEMP, int T1HUM, int T2HUM, int T3HUM, int T4HUM, int Location, int work) {
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

    public int getTrain() {
        return this.Train;
    }

    public int getT1ID() {
        return this.T1ID;
    }

    public int getT2ID() {
        return this.T2ID;
    }

    public int getT3ID() {
        return this.T3ID;
    }

    public int getT4ID() {
        return this.T4ID;
    }

    public int getT1TEMP() {
        return this.T1TEMP;
    }

    public int getT2TEMP() {
        return this.T2TEMP;
    }

    public int getT3TEMP() {
        return this.T3TEMP;
    }

    public int getT4TEMP() {
        return this.T4TEMP;
    }

    public int getT1HUM() {
        return this.T1HUM;
    }

    public int getT2HUM() {
        return this.T2HUM;
    }

    public int getT3HUM() {
        return this.T3HUM;
    }

    public int getT4HUM() {
        return this.T4HUM;
    }

    public int getLocation() {
        return this.Location;
    }

    public int getWork() {
        return this.work;
    }
}

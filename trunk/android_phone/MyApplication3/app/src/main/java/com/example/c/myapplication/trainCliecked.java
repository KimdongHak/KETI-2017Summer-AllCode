package com.example.c.myapplication;

import android.view.View;

/**
 * Created by c on 2017-07-10.
 */

public abstract class trainCliecked implements View.OnClickListener{
    protected int i;

    public trainCliecked(int i){
        this.i = i;
    }
}

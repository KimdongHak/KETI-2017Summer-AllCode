package com.example.c.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;


/**
 * Created by c on 2017-06-28.
 */

public class activity_continue extends AppCompatActivity {
    ArrayList<Item> mitems = new ArrayList<>();
    private TextView textView;
    private ImageView imageView;
    SwipeRefreshLayout refreshLayout;

    Handler h;
    String url = "http://117.16.136.173:3003";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);

        NetworkTask networkTask = new NetworkTask(url);
        networkTask.execute();

        h= new Handler();

        refreshLayout = (SwipeRefreshLayout)findViewById(R.id.refresh);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                NetworkTask2 networkTast2 = new NetworkTask2(url);
                networkTast2.execute();
                refreshLayout.setRefreshing(false);
            }
        });
    }

    public void basic() {
        //---------------
        textView = (TextView)findViewById(R.id.d1);
        textView.setText("");
        textView = (TextView)findViewById(R.id.u1);
        textView.setText("");
        imageView = (ImageView)findViewById(R.id.d1i);
        imageView.setImageResource(R.drawable.e1);
        imageView = (ImageView)findViewById(R.id.u1i);
        imageView.setImageResource(R.drawable.e1);
        //---------------
        textView = (TextView)findViewById(R.id.d2);
        textView.setText("");
        textView = (TextView)findViewById(R.id.u2);
        textView.setText("");
        imageView = (ImageView)findViewById(R.id.d2i);
        imageView.setImageResource(R.drawable.n);
        imageView = (ImageView)findViewById(R.id.u2i);
        imageView.setImageResource(R.drawable.n);
        //---------------
        textView = (TextView)findViewById(R.id.d3);
        textView.setText("");
        textView = (TextView)findViewById(R.id.u3);
        textView.setText("");
        imageView = (ImageView)findViewById(R.id.d3i);
        imageView.setImageResource(R.drawable.n);
        imageView = (ImageView)findViewById(R.id.u3i);
        imageView.setImageResource(R.drawable.n);
        //---------------
        textView = (TextView)findViewById(R.id.d4);
        textView.setText("");
        textView = (TextView)findViewById(R.id.u4);
        textView.setText("");
        imageView = (ImageView)findViewById(R.id.d4i);
        imageView.setImageResource(R.drawable.n);
        imageView = (ImageView)findViewById(R.id.u4i);
        imageView.setImageResource(R.drawable.n);
        //---------------
        textView = (TextView)findViewById(R.id.d5);
        textView.setText("");
        textView = (TextView)findViewById(R.id.u5);
        textView.setText("");
        imageView = (ImageView)findViewById(R.id.d5i);
        imageView.setImageResource(R.drawable.n);
        imageView = (ImageView)findViewById(R.id.u5i);
        imageView.setImageResource(R.drawable.n);
        //---------------
        textView = (TextView)findViewById(R.id.d6);
        textView.setText("");
        textView = (TextView)findViewById(R.id.u6);
        textView.setText("");
        imageView = (ImageView)findViewById(R.id.d6i);
        imageView.setImageResource(R.drawable.n);
        imageView = (ImageView)findViewById(R.id.u6i);
        imageView.setImageResource(R.drawable.n);
        //---------------
        textView = (TextView)findViewById(R.id.d7);
        textView.setText("");
        textView = (TextView)findViewById(R.id.u7);
        textView.setText("");
        imageView = (ImageView)findViewById(R.id.d7i);
        imageView.setImageResource(R.drawable.n);
        imageView = (ImageView)findViewById(R.id.u7i);
        imageView.setImageResource(R.drawable.n);
        //---------------
        textView = (TextView)findViewById(R.id.d8);
        textView.setText("");
        textView = (TextView)findViewById(R.id.u8);
        textView.setText("");
        imageView = (ImageView)findViewById(R.id.d8i);
        imageView.setImageResource(R.drawable.n);
        imageView = (ImageView)findViewById(R.id.u8i);
        imageView.setImageResource(R.drawable.n);
        //---------------
        textView = (TextView)findViewById(R.id.d9);
        textView.setText("");
        textView = (TextView)findViewById(R.id.u9);
        textView.setText("");
        imageView = (ImageView)findViewById(R.id.d9i);
        imageView.setImageResource(R.drawable.n);
        imageView = (ImageView)findViewById(R.id.u9i);
        imageView.setImageResource(R.drawable.n);
        //---------------
        textView = (TextView)findViewById(R.id.d10);
        textView.setText("");
        textView = (TextView)findViewById(R.id.u10);
        textView.setText("");
        imageView = (ImageView)findViewById(R.id.d10i);
        imageView.setImageResource(R.drawable.n);
        imageView = (ImageView)findViewById(R.id.u10i);
        imageView.setImageResource(R.drawable.n);
        //---------------
        textView = (TextView)findViewById(R.id.d11);
        textView.setText("");
        textView = (TextView)findViewById(R.id.u11);
        textView.setText("");
        imageView = (ImageView)findViewById(R.id.d11i);
        imageView.setImageResource(R.drawable.n);
        imageView = (ImageView)findViewById(R.id.u11i);
        imageView.setImageResource(R.drawable.n);
        //---------------
        textView = (TextView)findViewById(R.id.d12);
        textView.setText("");
        textView = (TextView)findViewById(R.id.u12);
        textView.setText("");
        imageView = (ImageView)findViewById(R.id.d12i);
        imageView.setImageResource(R.drawable.n);
        imageView = (ImageView)findViewById(R.id.u12i);
        imageView.setImageResource(R.drawable.n);
        //---------------
        textView = (TextView)findViewById(R.id.d13);
        textView.setText("");
        textView = (TextView)findViewById(R.id.u13);
        textView.setText("");
        imageView = (ImageView)findViewById(R.id.d13i);
        imageView.setImageResource(R.drawable.n);
        imageView = (ImageView)findViewById(R.id.u13i);
        imageView.setImageResource(R.drawable.n);
        //---------------
        textView = (TextView)findViewById(R.id.d14);
        textView.setText("");
        textView = (TextView)findViewById(R.id.u14);
        textView.setText("");
        imageView = (ImageView)findViewById(R.id.d14i);
        imageView.setImageResource(R.drawable.n);
        imageView = (ImageView)findViewById(R.id.u14i);
        imageView.setImageResource(R.drawable.n);
        //---------------
        textView = (TextView)findViewById(R.id.d15);
        textView.setText("");
        textView = (TextView)findViewById(R.id.u15);
        textView.setText("");
        imageView = (ImageView)findViewById(R.id.d15i);
        imageView.setImageResource(R.drawable.n);
        imageView = (ImageView)findViewById(R.id.u15i);
        imageView.setImageResource(R.drawable.n);
        //---------------
        textView = (TextView)findViewById(R.id.d16);
        textView.setText("");
        textView = (TextView)findViewById(R.id.u16);
        textView.setText("");
        imageView = (ImageView)findViewById(R.id.d16i);
        imageView.setImageResource(R.drawable.n);
        imageView = (ImageView)findViewById(R.id.u16i);
        imageView.setImageResource(R.drawable.n);
        //---------------
        textView = (TextView)findViewById(R.id.d17);
        textView.setText("");
        textView = (TextView)findViewById(R.id.u17);
        textView.setText("");
        imageView = (ImageView)findViewById(R.id.d17i);
        imageView.setImageResource(R.drawable.n);
        imageView = (ImageView)findViewById(R.id.u17i);
        imageView.setImageResource(R.drawable.n);
        //---------------
        textView = (TextView)findViewById(R.id.d18);
        textView.setText("");
        textView = (TextView)findViewById(R.id.u18);
        textView.setText("");
        imageView = (ImageView)findViewById(R.id.d18i);
        imageView.setImageResource(R.drawable.n);
        imageView = (ImageView)findViewById(R.id.u18i);
        imageView.setImageResource(R.drawable.n);
        //---------------
        textView = (TextView)findViewById(R.id.d19);
        textView.setText("");
        textView = (TextView)findViewById(R.id.u19);
        textView.setText("");
        imageView = (ImageView)findViewById(R.id.d19i);
        imageView.setImageResource(R.drawable.n);
        imageView = (ImageView)findViewById(R.id.u19i);
        imageView.setImageResource(R.drawable.n);
        //---------------
        textView = (TextView)findViewById(R.id.d20);
        textView.setText("");
        textView = (TextView)findViewById(R.id.u20);
        textView.setText("");
        imageView = (ImageView)findViewById(R.id.d20i);
        imageView.setImageResource(R.drawable.e2);
        imageView = (ImageView)findViewById(R.id.u20i);
        imageView.setImageResource(R.drawable.e2);
    } // 기본화면

    public void makeScreen(){
        for(int i = 0; i < mitems.size();i++) {
            if(100 == mitems.get(i).getLocation()) {
                if(mitems.get(i).getWork()==0){
                    imageView = (ImageView)findViewById(R.id.d1i);
                    imageView.setImageResource(R.drawable.b1);
                    textView = (TextView)findViewById(R.id.d1);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("하행 : "+mitems.get(i).getTrain());
                    }else{
                    textView.setText("하행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                    textView.setOnClickListener(new trainCliecked(i) {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(activity_continue.this,activity_detail.class);
                            intent.putExtra("Train",mitems.get(i).getTrain());
                            intent.putExtra("T1ID",mitems.get(i).getT1ID());
                            intent.putExtra("T2ID",mitems.get(i).getT2ID());
                            intent.putExtra("T3ID",mitems.get(i).getT3ID());
                            intent.putExtra("T4ID",mitems.get(i).getT4ID());
                            intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                            intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                            intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                            intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                            intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                            intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                            intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                            intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                            intent.putExtra("Location",mitems.get(i).getLocation());
                            intent.putExtra("Work",mitems.get(i).getWork());
                            startActivity(intent);
                        }
                    });}
                }else if(mitems.get(i).getWork()==1){
                    imageView = (ImageView)findViewById(R.id.u1i);
                    imageView.setImageResource(R.drawable.a1);
                    textView = (TextView)findViewById(R.id.u1);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("상행 : "+mitems.get(i).getTrain());
                    }else {
                    textView.setText("상행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                    textView.setOnClickListener(new trainCliecked(i) {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(activity_continue.this,activity_detail.class);
                            intent.putExtra("Train",mitems.get(i).getTrain());
                            intent.putExtra("T1ID",mitems.get(i).getT1ID());
                            intent.putExtra("T2ID",mitems.get(i).getT2ID());
                            intent.putExtra("T3ID",mitems.get(i).getT3ID());
                            intent.putExtra("T4ID",mitems.get(i).getT4ID());
                            intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                            intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                            intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                            intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                            intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                            intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                            intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                            intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                            intent.putExtra("Location",mitems.get(i).getLocation());
                            intent.putExtra("Work",mitems.get(i).getWork());
                            startActivity(intent);
                        }
                    });}
                }
            }else
            if(101 == mitems.get(i).getLocation()) {
                if(mitems.get(i).getWork()==0){
                    imageView = (ImageView)findViewById(R.id.d2i);
                    imageView.setImageResource(R.drawable.b2);
                    textView = (TextView)findViewById(R.id.d2);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("하행 : "+mitems.get(i).getTrain());
                    }else{
                        textView.setText("하행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }else if(mitems.get(i).getWork()==1){
                    imageView = (ImageView)findViewById(R.id.u2i);
                    imageView.setImageResource(R.drawable.a2);
                    textView = (TextView)findViewById(R.id.u2);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("상행 : "+mitems.get(i).getTrain());
                    }else {
                        textView.setText("상행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }
            }else
            if(102 == mitems.get(i).getLocation()) {
                if(mitems.get(i).getWork()==0){
                    imageView = (ImageView)findViewById(R.id.d3i);
                    imageView.setImageResource(R.drawable.b2);
                    textView = (TextView)findViewById(R.id.d3);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("하행 : "+mitems.get(i).getTrain());
                    }else{
                        textView.setText("하행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                Log.d("----------->>>Train value",""+mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }else if(mitems.get(i).getWork()==1){
                    imageView = (ImageView)findViewById(R.id.u3i);
                    imageView.setImageResource(R.drawable.a2);
                    textView = (TextView)findViewById(R.id.u3);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("상행 : "+mitems.get(i).getTrain());
                    }else {
                        textView.setText("상행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }
            }else
            if(103 == mitems.get(i).getLocation()) {
                if(mitems.get(i).getWork()==0){
                    imageView = (ImageView)findViewById(R.id.d4i);
                    imageView.setImageResource(R.drawable.b2);
                    textView = (TextView)findViewById(R.id.d4);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("하행 : "+mitems.get(i).getTrain());
                    }else{
                        textView.setText("하행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }else if(mitems.get(i).getWork()==1){
                    imageView = (ImageView)findViewById(R.id.u4i);
                    imageView.setImageResource(R.drawable.a2);
                    textView = (TextView)findViewById(R.id.u4);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("상행 : "+mitems.get(i).getTrain());
                    }else {
                        textView.setText("상행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }
            }else
            if(104 == mitems.get(i).getLocation()) {
                if(mitems.get(i).getWork()==0){
                    imageView = (ImageView)findViewById(R.id.d5i);
                    imageView.setImageResource(R.drawable.b2);
                    textView = (TextView)findViewById(R.id.d5);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("하행 : "+mitems.get(i).getTrain());
                    }else{
                        textView.setText("하행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }else if(mitems.get(i).getWork()==1){
                    imageView = (ImageView)findViewById(R.id.u5i);
                    imageView.setImageResource(R.drawable.a2);
                    textView = (TextView)findViewById(R.id.u5);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("상행 : "+mitems.get(i).getTrain());
                    }else {
                        textView.setText("상행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }
            }else
            if(105 == mitems.get(i).getLocation()) {
                if(mitems.get(i).getWork()==0){
                    imageView = (ImageView)findViewById(R.id.d6i);
                    imageView.setImageResource(R.drawable.b2);
                    textView = (TextView)findViewById(R.id.d6);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("하행 : "+mitems.get(i).getTrain());
                    }else{
                        textView.setText("하행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }else if(mitems.get(i).getWork()==1){
                    imageView = (ImageView)findViewById(R.id.u6i);
                    imageView.setImageResource(R.drawable.a2);
                    textView = (TextView)findViewById(R.id.u6);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("상행 : "+mitems.get(i).getTrain());
                    }else {
                        textView.setText("상행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }
            }else
            if(106 == mitems.get(i).getLocation()) {
                if(mitems.get(i).getWork()==0){
                    imageView = (ImageView)findViewById(R.id.d7i);
                    imageView.setImageResource(R.drawable.b2);
                    textView = (TextView)findViewById(R.id.d7);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("하행 : "+mitems.get(i).getTrain());
                    }else{
                        textView.setText("하행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }else if(mitems.get(i).getWork()==1){
                    imageView = (ImageView)findViewById(R.id.u7i);
                    imageView.setImageResource(R.drawable.a2);
                    textView = (TextView)findViewById(R.id.u7);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("상행 : "+mitems.get(i).getTrain());
                    }else {
                        textView.setText("상행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }
            }else
            if(107 == mitems.get(i).getLocation()) {
                if(mitems.get(i).getWork()==0){
                    imageView = (ImageView)findViewById(R.id.d8i);
                    imageView.setImageResource(R.drawable.b2);
                    textView = (TextView)findViewById(R.id.d8);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("하행 : "+mitems.get(i).getTrain());
                    }else{
                        textView.setText("하행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }else if(mitems.get(i).getWork()==1){
                    imageView = (ImageView)findViewById(R.id.u8i);
                    imageView.setImageResource(R.drawable.a2);
                    textView = (TextView)findViewById(R.id.u8);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("상행 : "+mitems.get(i).getTrain());
                    }else {
                        textView.setText("상행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }
            }else
            if(108 == mitems.get(i).getLocation()) {
                if(mitems.get(i).getWork()==0){
                    imageView = (ImageView)findViewById(R.id.d9i);
                    imageView.setImageResource(R.drawable.b2);
                    textView = (TextView)findViewById(R.id.d9);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("하행 : "+mitems.get(i).getTrain());
                    }else{
                        textView.setText("하행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }else if(mitems.get(i).getWork()==1){
                    imageView = (ImageView)findViewById(R.id.u9i);
                    imageView.setImageResource(R.drawable.a2);
                    textView = (TextView)findViewById(R.id.u9);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("상행 : "+mitems.get(i).getTrain());
                    }else {
                        textView.setText("상행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }
            }else
            if(109 == mitems.get(i).getLocation()) {
                if(mitems.get(i).getWork()==0){
                    imageView = (ImageView)findViewById(R.id.d10i);
                    imageView.setImageResource(R.drawable.b2);
                    textView = (TextView)findViewById(R.id.d10);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("하행 : "+mitems.get(i).getTrain());
                    }else{
                        textView.setText("하행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }else if(mitems.get(i).getWork()==1){
                    imageView = (ImageView)findViewById(R.id.u10i);
                    imageView.setImageResource(R.drawable.a2);
                    textView = (TextView)findViewById(R.id.u10);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("상행 : "+mitems.get(i).getTrain());
                    }else {
                        textView.setText("상행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }
            }else
            if(110 == mitems.get(i).getLocation()) {
                if(mitems.get(i).getWork()==0){
                    imageView = (ImageView)findViewById(R.id.d11i);
                    imageView.setImageResource(R.drawable.b2);
                    textView = (TextView)findViewById(R.id.d11);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("하행 : "+mitems.get(i).getTrain());
                    }else{
                        textView.setText("하행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }else if(mitems.get(i).getWork()==1){
                    imageView = (ImageView)findViewById(R.id.u11i);
                    imageView.setImageResource(R.drawable.a2);
                    textView = (TextView)findViewById(R.id.u11);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("상행 : "+mitems.get(i).getTrain());
                    }else {
                        textView.setText("상행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }
            }else
            if(111 == mitems.get(i).getLocation()) {
                if(mitems.get(i).getWork()==0){
                    imageView = (ImageView)findViewById(R.id.d12i);
                    imageView.setImageResource(R.drawable.b2);
                    textView = (TextView)findViewById(R.id.d12);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("하행 : "+mitems.get(i).getTrain());
                    }else{
                        textView.setText("하행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }else if(mitems.get(i).getWork()==1){
                    imageView = (ImageView)findViewById(R.id.u12i);
                    imageView.setImageResource(R.drawable.a2);
                    textView = (TextView)findViewById(R.id.u12);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("상행 : "+mitems.get(i).getTrain());
                    }else {
                        textView.setText("상행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }
            }else
            if(112 == mitems.get(i).getLocation()) {
                if(mitems.get(i).getWork()==0){
                    imageView = (ImageView)findViewById(R.id.d13i);
                    imageView.setImageResource(R.drawable.b2);
                    textView = (TextView)findViewById(R.id.d13);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("하행 : "+mitems.get(i).getTrain());
                    }else{
                        textView.setText("하행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }else if(mitems.get(i).getWork()==1){
                    imageView = (ImageView)findViewById(R.id.u13i);
                    imageView.setImageResource(R.drawable.a2);
                    textView = (TextView)findViewById(R.id.u13);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("상행 : "+mitems.get(i).getTrain());
                    }else {
                        textView.setText("상행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }
            }else
            if(113 == mitems.get(i).getLocation()) {
                if(mitems.get(i).getWork()==0){
                    imageView = (ImageView)findViewById(R.id.d14i);
                    imageView.setImageResource(R.drawable.b2);
                    textView = (TextView)findViewById(R.id.d14);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("하행 : "+mitems.get(i).getTrain());
                    }else{
                        textView.setText("하행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }else if(mitems.get(i).getWork()==1){
                    imageView = (ImageView)findViewById(R.id.u14i);
                    imageView.setImageResource(R.drawable.a2);
                    textView = (TextView)findViewById(R.id.u14);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("상행 : "+mitems.get(i).getTrain());
                    }else {
                        textView.setText("상행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }
            }else
            if(114 == mitems.get(i).getLocation()) {
                if(mitems.get(i).getWork()==0){
                    imageView = (ImageView)findViewById(R.id.d15i);
                    imageView.setImageResource(R.drawable.b2);
                    textView = (TextView)findViewById(R.id.d15);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("하행 : "+mitems.get(i).getTrain());
                    }else{
                        textView.setText("하행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }else if(mitems.get(i).getWork()==1){
                    imageView = (ImageView)findViewById(R.id.u15i);
                    imageView.setImageResource(R.drawable.a2);
                    textView = (TextView)findViewById(R.id.u15);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("상행 : "+mitems.get(i).getTrain());
                    }else {
                        textView.setText("상행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }
            }else
            if(115 == mitems.get(i).getLocation()) {
                if(mitems.get(i).getWork()==0){
                    imageView = (ImageView)findViewById(R.id.d16i);
                    imageView.setImageResource(R.drawable.b2);
                    textView = (TextView)findViewById(R.id.d16);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("하행 : "+mitems.get(i).getTrain());
                    }else{
                        textView.setText("하행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }else if(mitems.get(i).getWork()==1){
                    imageView = (ImageView)findViewById(R.id.u16i);
                    imageView.setImageResource(R.drawable.a2);
                    textView = (TextView)findViewById(R.id.u16);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("상행 : "+mitems.get(i).getTrain());
                    }else {
                        textView.setText("상행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }
            }else
            if(116 == mitems.get(i).getLocation()) {
                if(mitems.get(i).getWork()==0){
                    imageView = (ImageView)findViewById(R.id.d17i);
                    imageView.setImageResource(R.drawable.b2);
                    textView = (TextView)findViewById(R.id.d17);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("하행 : "+mitems.get(i).getTrain());
                    }else{
                        textView.setText("하행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }else if(mitems.get(i).getWork()==1){
                    imageView = (ImageView)findViewById(R.id.u17i);
                    imageView.setImageResource(R.drawable.a2);
                    textView = (TextView)findViewById(R.id.u17);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("상행 : "+mitems.get(i).getTrain());
                    }else {
                        textView.setText("상행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }
            }else
            if(117 == mitems.get(i).getLocation()) {
                if(mitems.get(i).getWork()==0){
                    imageView = (ImageView)findViewById(R.id.d18i);
                    imageView.setImageResource(R.drawable.b2);
                    textView = (TextView)findViewById(R.id.d18);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("하행 : "+mitems.get(i).getTrain());
                    }else{
                        textView.setText("하행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }else if(mitems.get(i).getWork()==1){
                    imageView = (ImageView)findViewById(R.id.u18i);
                    imageView.setImageResource(R.drawable.a2);
                    textView = (TextView)findViewById(R.id.u18);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("상행 : "+mitems.get(i).getTrain());
                    }else {
                        textView.setText("상행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }
            }else
            if(118 == mitems.get(i).getLocation()) {
                if(mitems.get(i).getWork()==0){
                    imageView = (ImageView)findViewById(R.id.d19i);
                    imageView.setImageResource(R.drawable.b2);
                    textView = (TextView)findViewById(R.id.d19);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("하행 : "+mitems.get(i).getTrain());
                    }else{
                        textView.setText("하행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }else if(mitems.get(i).getWork()==1){
                    imageView = (ImageView)findViewById(R.id.u19i);
                    imageView.setImageResource(R.drawable.a2);
                    textView = (TextView)findViewById(R.id.u19);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("상행 : "+mitems.get(i).getTrain());
                    }else {
                        textView.setText("상행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }
            }else
            if(119 == mitems.get(i).getLocation()) {
                if(mitems.get(i).getWork()==0){
                    imageView = (ImageView)findViewById(R.id.d20i);
                    imageView.setImageResource(R.drawable.b3);
                    textView = (TextView)findViewById(R.id.d20);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("하행 : "+mitems.get(i).getTrain());
                    }else{
                        textView.setText("하행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }else if(mitems.get(i).getWork()==1){
                    imageView = (ImageView)findViewById(R.id.u20i);
                    imageView.setImageResource(R.drawable.a3);
                    textView = (TextView)findViewById(R.id.u20);
                    textView.setTextSize(11);
                    if(mitems.get(i).getT1TEMP()==0){
                        textView.setText("상행 : "+mitems.get(i).getTrain());
                    }else {
                        textView.setText("상행 : "+mitems.get(i).getTrain()+"\n["+mitems.get(i).getT1TEMP()+"℃/"+mitems.get(i).getT1HUM()+"%]");
                        textView.setOnClickListener(new trainCliecked(i) {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(activity_continue.this,activity_detail.class);
                                intent.putExtra("Train",mitems.get(i).getTrain());
                                intent.putExtra("T1ID",mitems.get(i).getT1ID());
                                intent.putExtra("T2ID",mitems.get(i).getT2ID());
                                intent.putExtra("T3ID",mitems.get(i).getT3ID());
                                intent.putExtra("T4ID",mitems.get(i).getT4ID());
                                intent.putExtra("T1TEMP",mitems.get(i).getT1TEMP());
                                intent.putExtra("T2TEMP",mitems.get(i).getT2TEMP());
                                intent.putExtra("T3TEMP",mitems.get(i).getT3TEMP());
                                intent.putExtra("T4TEMP",mitems.get(i).getT4TEMP());
                                intent.putExtra("T1HUM",mitems.get(i).getT1HUM());
                                intent.putExtra("T2HUM",mitems.get(i).getT2HUM());
                                intent.putExtra("T3HUM",mitems.get(i).getT3HUM());
                                intent.putExtra("T4HUM",mitems.get(i).getT4HUM());
                                intent.putExtra("Location",mitems.get(i).getLocation());
                                intent.putExtra("Work",mitems.get(i).getWork());
                                startActivity(intent);
                            }
                        });}
                }
            }
        }

    } // 열차의 위치 및 온습도 출력, 상세보기 화면을 위한 작업

    @Override
    public void onBackPressed() {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setIcon(android.R.drawable.ic_dialog_alert);
        b.setMessage("프로그램을 끝내시겠습니까?");
        b.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        moveTaskToBack(true);
                        finish();
                        android.os.Process.killProcess(android.os.Process.myPid());
                    }

                });
        b.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                moveTaskToBack(true);
                finish();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
        b.setCancelable(true);
        b.setNegativeButton("취소", null);
        b.show();

    } // 백버튼 클릭시 이벤트

    private AlertDialog createDialogBox() { // NetWorkTast에서 열차 운행시간이 아닐경우에 띄워주는 다이얼로그 창 확인을 누를경우 메인화면으로 돌아감
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("KETI Project");
        builder.setMessage("지금은 열차 운행시간이 아닙니다.");
        builder.setCancelable(false);
        builder.setNegativeButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        return dialog;
    }

    public Runnable redrawScreen = new Runnable() {
        @Override
        public void run() { // 자동 새로고침
            NetworkTask networkTask = new NetworkTask(url);
            networkTask.execute();
        }
    };

    //AutoRefresh를 위한 클래스
    public class NetworkTask extends AsyncTask<Void, Void, String> {

        private String url;
        public NetworkTask(String url) {
            this.url = url;
        }


        @Override
        protected String doInBackground(Void... params) {

            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(this.url);

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mitems.clear();

            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(calendar.HOUR_OF_DAY);
            if(s!=null) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray jsonArray = new JSONArray(jsonObject.getString("subway"));
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject dataJobject = jsonArray.getJSONObject(i);
                        mitems.add(new Item(dataJobject.getInt("Train"), dataJobject.getInt("T1ID"), dataJobject.getInt("T2ID"), dataJobject.getInt("T3ID"), dataJobject.getInt("T4ID"), dataJobject.getInt("T1TEMP"), dataJobject.getInt("T2TEMP"), dataJobject.getInt("T3TEMP"), dataJobject.getInt("T4TEMP"), dataJobject.getInt("T1HUM"), dataJobject.getInt("T2HUM"), dataJobject.getInt("T3HUM"), dataJobject.getInt("T4HUM"), dataJobject.getInt("Location"), dataJobject.getInt("work")));
                    }
                    basic();
                    makeScreen();
                    h.postDelayed(redrawScreen,10000);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else if (hour> 1 && hour < 5)
            {
                createDialogBox().show();
            }
        }
    }

    //RefreshScroll을 위한 클래스
    public class NetworkTask2 extends AsyncTask<Void, Void, String> {
        private String url;
        public NetworkTask2(String url) {
            this.url = url;
        }


        @Override
        protected String doInBackground(Void... params) {

            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(this.url);

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            basic();
            mitems.clear();

            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(calendar.HOUR_OF_DAY);

            if(s!=null) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray jsonArray = new JSONArray(jsonObject.getString("subway"));
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject dataJobject = jsonArray.getJSONObject(i);
                        mitems.add(new Item(dataJobject.getInt("Train"), dataJobject.getInt("T1ID"), dataJobject.getInt("T2ID"), dataJobject.getInt("T3ID"), dataJobject.getInt("T4ID"), dataJobject.getInt("T1TEMP"), dataJobject.getInt("T2TEMP"), dataJobject.getInt("T3TEMP"), dataJobject.getInt("T4TEMP"), dataJobject.getInt("T1HUM"), dataJobject.getInt("T2HUM"), dataJobject.getInt("T3HUM"), dataJobject.getInt("T4HUM"), dataJobject.getInt("Location"), dataJobject.getInt("work")));
                    }
                    makeScreen();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



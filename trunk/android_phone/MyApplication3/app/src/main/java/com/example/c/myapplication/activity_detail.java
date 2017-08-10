package com.example.c.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.c.myapplication.R.id.radio1;

public class activity_detail extends AppCompatActivity {
    private TextView textView;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private Intent intent;
    private Intent intent2;
    public static Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        activity = activity_detail.this;

        intent = getIntent();

        textView = (TextView)findViewById(R.id.tnedit);
        Log.d("----------->>>Train value",""+intent.getExtras().getInt("Train"));
        textView.setText(""+intent.getExtras().getInt("Train"));
        textView = (TextView)findViewById(R.id.tempedit);
        textView.setText(""+intent.getExtras().getInt("T1TEMP")+"℃");
        textView = (TextView)findViewById(R.id.humedit);
        textView.setText(""+intent.getExtras().getInt("T1HUM")+"%");

        radioButton1 = (RadioButton)findViewById(radio1);
        radioButton1.setText("차량:"+intent.getExtras().getInt("T1ID")+", 온도:"+intent.getExtras().getInt("T1TEMP")+"℃, 습도:"+intent.getExtras().getInt("T1HUM")+"%");
        radioButton2 = (RadioButton)findViewById(R.id.radio2);
        radioButton2.setText("차량:"+intent.getExtras().getInt("T2ID")+", 온도:"+intent.getExtras().getInt("T2TEMP")+"℃, 습도:"+intent.getExtras().getInt("T2HUM")+"%");
        radioButton3 = (RadioButton)findViewById(R.id.radio3);
        radioButton3.setText("차량:"+intent.getExtras().getInt("T3ID")+", 온도:"+intent.getExtras().getInt("T3TEMP")+"℃, 습도:"+intent.getExtras().getInt("T3HUM")+"%");
        radioButton4 = (RadioButton)findViewById(R.id.radio4);
        radioButton4.setText("차량:"+intent.getExtras().getInt("T4ID")+", 온도:"+intent.getExtras().getInt("T4TEMP")+"℃, 습도:"+intent.getExtras().getInt("T4HUM")+"%");

    }

    public void backButtonClicked(View v) {
        finish();
    }

    public void sendButtonClicked(View v) {
        if (radioButton1.isChecked()) {
            intent2 = new Intent(activity_detail.this,activity_send.class);
            intent2.putExtra("ID", intent.getExtras().getInt("T1ID"));
            intent2.putExtra("TEMP", intent.getExtras().getInt("T1TEMP"));
            intent2.putExtra("HUM", intent.getExtras().getInt("T1HUM"));
            startActivity(intent2);
        } else if (radioButton2.isChecked()) {
            intent2 = new Intent(activity_detail.this,activity_send.class);
            intent2.putExtra("ID", intent.getExtras().getInt("T2ID"));
            intent2.putExtra("TEMP", intent.getExtras().getInt("T2TEMP"));
            intent2.putExtra("HUM", intent.getExtras().getInt("T2HUM"));
            startActivity(intent2);
        } else if (radioButton3.isChecked()) {
            intent2 = new Intent(activity_detail.this,activity_send.class);
            intent2.putExtra("ID", intent.getExtras().getInt("T3ID"));
            intent2.putExtra("TEMP", intent.getExtras().getInt("T3TEMP"));
            intent2.putExtra("HUM", intent.getExtras().getInt("T3HUM"));
            startActivity(intent2);
        } else if (radioButton4.isChecked()) {
            intent2 = new Intent(activity_detail.this,activity_send.class);
            intent2.putExtra("ID", intent.getExtras().getInt("T4ID"));
            intent2.putExtra("TEMP", intent.getExtras().getInt("T4TEMP"));
            intent2.putExtra("HUM", intent.getExtras().getInt("T4HUM"));
            startActivity(intent2);
        } else
            Toast.makeText(getApplicationContext(), "차량을 선택하세요.", Toast.LENGTH_SHORT).show();
    }

}

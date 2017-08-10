package com.example.c.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class activity_send extends AppCompatActivity {
    Intent intent;
    TextView textView;
    EditText editText;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    String sendJSONObject;
    AlertDialog dialog = null;
    activity_detail activity = (activity_detail) activity_detail.activity;
    String URL = "http://energy.openlab.kr:4000/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        intent = getIntent();

        textView = (TextView) findViewById(R.id.tnedit);
        textView.setText("" + intent.getExtras().getInt("ID"));
        textView = (TextView) findViewById(R.id.tempedit);
        textView.setText("" + intent.getExtras().getInt("TEMP") + "℃");
        textView = (TextView) findViewById(R.id.humedit);
        textView.setText("" + intent.getExtras().getInt("HUM") + "%");
        editText = (EditText)findViewById(R.id.edit);
    }

    public void backButtonClicked(View v) {
        finish();
    }

    public void sendMinWon(View v) {
        sendJSONObject = makeJSON();
        NetworkTask task = new NetworkTask(URL);
        task.execute();
    }

    public String makeJSON(){
        Calendar cal = Calendar.getInstance();
        String dateString = String.format("%02d/%02d/%04d", cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR));
        String timeString = String.format("%02d:%02d:%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));

        radioButton1 = (RadioButton)findViewById(R.id.radio1);
        radioButton2 = (RadioButton)findViewById(R.id.radio2);
        radioButton3 = (RadioButton)findViewById(R.id.radio3);
        radioButton4 = (RadioButton)findViewById(R.id.radio4);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("type","1");
            jsonObject.put("trainID",intent.getExtras().getInt("ID"));
            jsonObject.put("cur_temp",intent.getExtras().getInt("TEMP"));
            jsonObject.put("cur_hum",intent.getExtras().getInt("HUM"));

            //불만사항을 선택하지 않더라도 서버로 데이터전송
            if(radioButton1.isChecked())
                jsonObject.put("complaint","cold");
            else if (radioButton2.isChecked())
                jsonObject.put("complaint", "hot");
            else if (radioButton3.isChecked())
                jsonObject.put("complaint", "dry");
            else if (radioButton4.isChecked())
                jsonObject.put("complaint", "sweat");
            else
                jsonObject.put("complaint","nomal");
            if(editText.getText().toString() != null)
                jsonObject.put("message",editText.getText().toString());
            else
                jsonObject.put("message","");

            jsonObject.put("time",dateString+" "+timeString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    public Runnable toSurvey = new Runnable() {
        @Override
        public void run() {
            if(dialog.isShowing()) {
                dialog.dismiss();
                finish();
                activity.finish();
                Intent survey = new Intent(activity_send.this,activity_survey.class);
                survey.putExtra("trainID",intent.getExtras().getInt("ID"));
                startActivity(survey);
            }
        }
    };
    public class NetworkTask extends AsyncTask<Void, Void, String> {

        private String url;
        public NetworkTask(String url) {
            this.url = url;
        }


        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.connection(this.url,sendJSONObject);

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //알림창 설정
            Handler handler = new Handler();
            dialog = new AlertDialog.Builder(activity_send.this).create();
            TextView message = new TextView(activity_send.this);
            if (s == null) {
                message.setText("잠시 후에 다시 이용해 주세요");
                message.setGravity(Gravity.CENTER);
                message.setPadding(10, 40, 10, 10);
                message.setTextColor(Color.BLACK);
                message.setTextSize(17);
                dialog.setView(message);
                dialog.show();
                dialog.setCancelable(true);
                handler.postDelayed(toSurvey, 3000);
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        finish();
                        activity.finish();
                    }
                });
            } else if(s != null){
                message.setText(s);
                message.setGravity(Gravity.CENTER);
                message.setPadding(10, 40, 10, 10);
                message.setTextColor(Color.BLACK);
                message.setTextSize(17);
                dialog.setView(message);
                dialog.show();
                dialog.setCancelable(true);
                handler.postDelayed(toSurvey, 3000);
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        finish();
                        activity.finish();
                        Intent survey = new Intent(activity_send.this,activity_survey.class);
                        survey.putExtra("trainID",intent.getExtras().getInt("ID"));
                        startActivity(survey);
                    }
                });
            }
        }
    }
}


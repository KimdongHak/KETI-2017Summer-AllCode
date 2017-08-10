package com.example.c.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> trainID;
    ArrayList<String> number;
    ArrayList<Item> mitems = new ArrayList<>();
    ArrayAdapter trainAdapter;
    ArrayAdapter numberAdapter;

    char[] charID;
    String num;
    String temp;
    String hum;

    Spinner spinnerTrain;
    Spinner spinnerNumber;

    TextView viewTEMP;
    TextView viewHUM;

    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    RadioButton radioButton5;

    String url = "http://117.16.136.173:3003";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trainID = new ArrayList<String>();

        NetworkTask networkTask = new NetworkTask(url);
        networkTask.execute();

    }

    public String sendToServerMesage() {
        Calendar cal = Calendar.getInstance();
        String dateString = String.format("%02d/%02d/%04d", cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR));
        String timeString = String.format("%02d:%02d:%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));

        radioButton1 = (RadioButton)findViewById(R.id.radio1);
        radioButton2 = (RadioButton)findViewById(R.id.radio2);
        radioButton3 = (RadioButton)findViewById(R.id.radio3);
        radioButton4 = (RadioButton)findViewById(R.id.radio4);
        radioButton5 = (RadioButton)findViewById(R.id.radio5);

        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("type","3");
            jsonObject.put("trainID",spinnerTrain.getSelectedItem().toString());
            //jsonObject.put("")

            if(radioButton1.isChecked())
                ;
            else if(radioButton2.isChecked())
                ;
            else if(radioButton3.isChecked())
                ;
            else if(radioButton4.isChecked())
                ;
            else if(radioButton5.isChecked())
                ;

            jsonObject.put("time",dateString+" "+timeString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
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
            if(s!=null) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray jsonArray = new JSONArray(jsonObject.getString("subway"));
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject dataJobject = jsonArray.getJSONObject(i);
                        mitems.add(new Item(dataJobject.getString("Train"), dataJobject.getString("T1ID"), dataJobject.getString("T2ID"), dataJobject.getString("T3ID"), dataJobject.getString("T4ID"), dataJobject.getString("T1TEMP"), dataJobject.getString("T2TEMP"), dataJobject.getString("T3TEMP"), dataJobject.getString("T4TEMP"), dataJobject.getString("T1HUM"), dataJobject.getString("T2HUM"), dataJobject.getString("T3HUM"), dataJobject.getString("T4HUM"), dataJobject.getString("Location"), dataJobject.getString("work")));
                    }
                    for(int i=0;i<mitems.size();i++) {
                        trainID.add(mitems.get(i).getTrain().toString());
                    }
                    spinnerTrain = (Spinner)findViewById(R.id.trainSpinner);
                    trainAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_item,trainID);
                    trainAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerTrain.setAdapter(trainAdapter);

                    spinnerTrain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            charID = spinnerTrain.getSelectedItem().toString().toCharArray();
                            number = new ArrayList<String>();
                            number.add(charID[0]+"0"+charID[1]+charID[2]);
                            number.add(charID[0]+"1"+charID[1]+charID[2]);
                            number.add(charID[0]+"2"+charID[1]+charID[2]);
                            number.add(charID[0]+"7"+charID[1]+charID[2]);

                            spinnerNumber = (Spinner)findViewById(R.id.numberSpinner);
                            numberAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_item,number);
                            numberAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spinnerNumber.setAdapter(numberAdapter);
                            spinnerNumber.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    switch (position) {
                                        case 0:
                                            num = spinnerTrain.getSelectedItem().toString();
                                            Log.d("---------->>num",""+num);
                                            Log.d("mitems.get(0).getTrain",""+mitems.get(0).getTrain());
                                            Log.d("mitems.get(1).getTrain",""+mitems.get(1).getTrain());
                                            Log.d("mitems.get(2).getTrain",""+mitems.get(2).getTrain());
                                            Log.d("mitems.get(3).getTrain",""+mitems.get(3).getTrain());
                                            for(int i=0;i<mitems.size();i++) {
                                                if(num.equals(mitems.get(i).getTrain())){
                                                    temp = mitems.get(spinnerTrain.getSelectedItemPosition()).getT1TEMP();
                                                    hum = mitems.get(spinnerTrain.getSelectedItemPosition()).getT1HUM();

                                                    viewTEMP = (TextView)findViewById(R.id.temp);
                                                    viewTEMP.setText(temp);
                                                    viewHUM = (TextView)findViewById(R.id.hum);
                                                    viewHUM.setText(hum);
                                                    break;
                                                }
                                            }
                                        case 1:
                                            num = spinnerNumber.getSelectedItem().toString();
                                            for(int i=0;i<mitems.size();i++) {
                                                if(num.equals(mitems.get(i).getTrain())){
                                                    temp = mitems.get(spinnerTrain.getSelectedItemPosition()).getT1TEMP();
                                                    hum = mitems.get(spinnerTrain.getSelectedItemPosition()).getT1HUM();

                                                    viewTEMP = (TextView)findViewById(R.id.temp);
                                                    viewTEMP.setText(temp);
                                                    viewHUM = (TextView)findViewById(R.id.hum);
                                                    viewHUM.setText(hum);
                                                    break;
                                                }
                                            }
                                        case 2:
                                            num = spinnerNumber.getSelectedItem().toString();
                                            for(int i=0;i<mitems.size();i++) {
                                                if(num.equals(mitems.get(i).getTrain())){
                                                    temp = mitems.get(spinnerTrain.getSelectedItemPosition()).getT1TEMP();
                                                    hum = mitems.get(spinnerTrain.getSelectedItemPosition()).getT1HUM();

                                                    viewTEMP = (TextView)findViewById(R.id.temp);
                                                    viewTEMP.setText(temp);
                                                    viewHUM = (TextView)findViewById(R.id.hum);
                                                    viewHUM.setText(hum);
                                                    break;
                                                }
                                            }
                                        case 3:
                                            num = spinnerNumber.getSelectedItem().toString();
                                            for(int i=0;i<mitems.size();i++) {
                                                if(num.equals(mitems.get(i).getTrain())){
                                                    temp = mitems.get(spinnerTrain.getSelectedItemPosition()).getT1TEMP().toString();
                                                    hum = mitems.get(spinnerTrain.getSelectedItemPosition()).getT1HUM().toString();

                                                    viewTEMP = (TextView)findViewById(R.id.temp);
                                                    viewTEMP.setText(temp);
                                                    viewHUM = (TextView)findViewById(R.id.hum);
                                                    viewHUM.setText(hum);
                                                    break;
                                                }
                                            }
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


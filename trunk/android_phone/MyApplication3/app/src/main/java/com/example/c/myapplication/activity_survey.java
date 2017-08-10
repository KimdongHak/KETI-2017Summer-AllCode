package com.example.c.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class activity_survey extends AppCompatActivity {
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    RadioButton radioButton5;
    RadioButton radioButton6;
    RadioButton radioButton7;
    RadioButton radioButton8;
    RadioButton radioButton9;
    RadioButton radioButton10;
    RadioButton radioButton11;
    RadioButton radioButton12;
    RadioButton radioButton13;
    RadioButton radioButton14;
    RadioButton radioButton15;
    RadioButton radioButton16;
    RadioButton radioButton17;
    RadioButton radioButton18;
    RadioButton radioButton19;
    RadioButton radioButton20;
    RadioButton radioButton21;
    EditText editText;
    EditText newedit1;
    EditText newedit2;
    EditText newedit3;
    EditText newedit4;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;

    Intent intent;
    String URL = "http://energy.openlab.kr:4000/";
    String surveyJSONObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        basicSet();
        setRadioButtonClick();
        textView1.setVisibility(View.GONE);
        newedit1.setVisibility(View.GONE);
        textView2.setVisibility(View.GONE);
        newedit2.setVisibility(View.GONE);
        textView3.setVisibility(View.GONE);
        newedit3.setVisibility(View.GONE);
        textView4.setVisibility(View.GONE);
        newedit4.setVisibility(View.GONE);
    }

    public void setRadioButtonClick() {
        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setVisibility(View.GONE);
                newedit1.setVisibility(View.GONE);
            }
        });
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setVisibility(View.GONE);
                newedit1.setVisibility(View.GONE);
            }
        });
        radioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setVisibility(View.GONE);
                newedit1.setVisibility(View.GONE);
            }
        });
        radioButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setVisibility(View.VISIBLE);
                newedit1.setVisibility(View.VISIBLE);
            }
        });
        radioButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setVisibility(View.VISIBLE);
                newedit1.setVisibility(View.VISIBLE);
            }
        });
        radioButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setVisibility(View.GONE);
                newedit2.setVisibility(View.GONE);
            }
        });
        radioButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setVisibility(View.GONE);
                newedit2.setVisibility(View.GONE);
            }
        });
        radioButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setVisibility(View.GONE);
                newedit2.setVisibility(View.GONE);
            }
        });
        radioButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setVisibility(View.VISIBLE);
                newedit2.setVisibility(View.VISIBLE);
            }
        });
        radioButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setVisibility(View.VISIBLE);
                newedit2.setVisibility(View.VISIBLE);
            }
        });
        radioButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView3.setVisibility(View.GONE);
                newedit3.setVisibility(View.GONE);
            }
        });
        radioButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView3.setVisibility(View.GONE);
                newedit3.setVisibility(View.GONE);
            }
        });
        radioButton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView3.setVisibility(View.GONE);
                newedit3.setVisibility(View.GONE);
            }
        });
        radioButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView3.setVisibility(View.VISIBLE);
                newedit3.setVisibility(View.VISIBLE);
            }
        });
        radioButton15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView3.setVisibility(View.VISIBLE);
                newedit3.setVisibility(View.VISIBLE);
            }
        });
        radioButton16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView4.setVisibility(View.GONE);
                newedit4.setVisibility(View.GONE);
            }
        });
        radioButton17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView4.setVisibility(View.GONE);
                newedit4.setVisibility(View.GONE);
            }
        });
        radioButton18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView4.setVisibility(View.GONE);
                newedit4.setVisibility(View.GONE);
            }
        });
        radioButton19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView4.setVisibility(View.VISIBLE);
                newedit4.setVisibility(View.VISIBLE);
            }
        });
        radioButton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView4.setVisibility(View.VISIBLE);
                newedit4.setVisibility(View.VISIBLE);
            }
        });
        radioButton21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView4.setVisibility(View.GONE);
                newedit4.setVisibility(View.GONE);
            }
        });
    }

    public void sendSurveyButtonClicked(View v) {
        surveyJSONObject = makeSurveyJSON();
        NetworkTask networkTask = new NetworkTask(URL);
        networkTask.execute();
        finish();
    }

    public void finishButtonClicked(View v) {
        finish();
    }

    public String makeSurveyJSON(){
        String result = "";
        intent=getIntent();
        Calendar cal = Calendar.getInstance();
        String dateString = String.format("%02d/%02d/%04d", cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR));
        String timeString = String.format("%02d:%02d:%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("type","2");
            jsonObject.put("trainID",intent.getExtras().getInt("trainID"));
            //버튼에 따른 값 추가
            if(radioButton1.isChecked()) {
                jsonObject.put("grade1","1");
            } else if(radioButton2.isChecked()) {
                jsonObject.put("grade1","2");
            } else if(radioButton3.isChecked()) {
                jsonObject.put("grade1","3");
            } else if(radioButton4.isChecked()) {
                jsonObject.put("grade1","4");
                if(newedit1.getText().toString() != null)
                    jsonObject.put("msg1",newedit1.getText().toString());
                else
                    jsonObject.put("msg1","");
            } else if(radioButton5.isChecked()) {
                jsonObject.put("grade1","5");
                if(newedit1.getText().toString() != null)
                    jsonObject.put("msg1",newedit1.getText().toString());
                else
                    jsonObject.put("msg1","");
            }if(radioButton6.isChecked()) {
                jsonObject.put("grade2","1");
            } else if(radioButton7.isChecked()) {
                jsonObject.put("grade2","2");
            } else if(radioButton8.isChecked()) {
                jsonObject.put("grade2","3");
            } else if(radioButton9.isChecked()) {
                jsonObject.put("grade2","4");
                if(newedit2.getText().toString() != null)
                    jsonObject.put("msg2",newedit2.getText().toString());
                else
                    jsonObject.put("msg2","");
            } else if(radioButton10.isChecked()) {
                jsonObject.put("grade2","5");
                if(newedit2.getText().toString() != null)
                    jsonObject.put("msg2",newedit2.getText().toString());
                else
                    jsonObject.put("msg2","");
            }if(radioButton11.isChecked()) {
                jsonObject.put("grade3","1");
            } else if(radioButton12.isChecked()) {
                jsonObject.put("grade3","2");
            } else if(radioButton13.isChecked()) {
                jsonObject.put("grade3","3");
            } else if(radioButton14.isChecked()) {
                jsonObject.put("grade3","4");
                if(newedit3.getText().toString() != null)
                    jsonObject.put("msg3",newedit3.getText().toString());
                else
                    jsonObject.put("msg3","");
            } else if(radioButton15.isChecked()) {
                jsonObject.put("grade3","5");
                if(newedit3.getText().toString() != null)
                    jsonObject.put("msg3",newedit3.getText().toString());
                else
                    jsonObject.put("msg3","");
            }if(radioButton16.isChecked()) {
                jsonObject.put("grade4","1");
            } else if(radioButton17.isChecked()) {
                jsonObject.put("grade4","2");
            } else if(radioButton18.isChecked()) {
                jsonObject.put("grade4","3");
            } else if(radioButton19.isChecked()) {
                jsonObject.put("grade4","4");
                if(newedit4.getText().toString() != null)
                    jsonObject.put("msg4",newedit4.getText().toString());
                else
                    jsonObject.put("msg4","");
            } else if(radioButton20.isChecked()) {
                jsonObject.put("grade4","5");
                if(newedit4.getText().toString() != null)
                    jsonObject.put("msg4",newedit4.getText().toString());
                else
                    jsonObject.put("msg4","");
            }else if(radioButton21.isChecked()) {
                jsonObject.put("grade4","6");
            }
            if(editText.getText().toString() != null)
                jsonObject.put("msg5",editText.getText().toString());
            else
                jsonObject.put("msg5","");
            jsonObject.put("time",dateString+" "+timeString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        result = jsonObject.toString();
        return result;
    }

    public void basicSet() {
        radioButton1 = (RadioButton)findViewById(R.id.q1b1);
        radioButton2 = (RadioButton)findViewById(R.id.q1b2);
        radioButton3 = (RadioButton)findViewById(R.id.q1b3);
        radioButton4 = (RadioButton)findViewById(R.id.q1b4);
        radioButton5 = (RadioButton)findViewById(R.id.q1b5);
        radioButton6 = (RadioButton)findViewById(R.id.q2b1);
        radioButton7 = (RadioButton)findViewById(R.id.q2b2);
        radioButton8 = (RadioButton)findViewById(R.id.q2b3);
        radioButton9 = (RadioButton)findViewById(R.id.q2b4);
        radioButton10 = (RadioButton)findViewById(R.id.q2b5);
        radioButton11 = (RadioButton)findViewById(R.id.q3b1);
        radioButton12 = (RadioButton)findViewById(R.id.q3b2);
        radioButton13 = (RadioButton)findViewById(R.id.q3b3);
        radioButton14 = (RadioButton)findViewById(R.id.q3b4);
        radioButton15 = (RadioButton)findViewById(R.id.q3b5);
        radioButton16 = (RadioButton)findViewById(R.id.q4b1);
        radioButton17 = (RadioButton)findViewById(R.id.q4b2);
        radioButton18 = (RadioButton)findViewById(R.id.q4b3);
        radioButton19 = (RadioButton)findViewById(R.id.q4b4);
        radioButton20 = (RadioButton)findViewById(R.id.q4b5);
        radioButton21 = (RadioButton)findViewById(R.id.q4b6);
        editText = (EditText)findViewById(R.id.q5edit);
        newedit1 = (EditText)findViewById(R.id.answer1edit);
        newedit2 = (EditText)findViewById(R.id.answer2edit);
        newedit3 = (EditText)findViewById(R.id.answer3edit);
        newedit4 = (EditText)findViewById(R.id.answer4edit);
        textView1 = (TextView)findViewById(R.id.answer1);
        textView2 = (TextView)findViewById(R.id.answer2);
        textView3 = (TextView)findViewById(R.id.answer3);
        textView4 = (TextView)findViewById(R.id.answer4);
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
            result = requestHttpURLConnection.connection(this.url,surveyJSONObject);

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
        }
    }
}

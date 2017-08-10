package com.example.c.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void makeByButtonClicked(View v) {
        AlertDialog dialog = createDialogBox();
        dialog.show();
    }

    private AlertDialog createDialogBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("KETI Project");
        builder.setMessage("도시철도 차량의\n냉난방 만족도\n제고를 위한\n정보 기술");
        builder.setCancelable(false); // 취소버튼을 눌러도 반응이 없음
        builder.setNegativeButton("확인", new DialogInterface.OnClickListener() { // 확인을 누르면 다이얼로그 창이 닫힘
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog dialog = builder.create();
        return dialog;
    }

    public void continueButtonClicked(View v) { // continue버튼을 누르면 다음화면으로 넘어감
        Intent intent = new Intent(this, activity_continue.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() { // 백버튼을 눌렀을 때 진행행
       AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setIcon(android.R.drawable.ic_dialog_alert);
        b.setMessage("프로그램을 끝내시겠습니까?");
        b.setPositiveButton("확인", new DialogInterface.OnClickListener()
                {
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
        b.setNegativeButton("취소", null);
        b.show();
    }
}

package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class Splash_Screen2 extends AppCompatActivity {
    ProgressBar p1;
    int mpgstatus=0;
    Handler mhandler=new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen2);
        p1=findViewById(R.id.p1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mpgstatus < 100) {
                    mpgstatus++;
                    android.os.SystemClock.sleep(50);
                    mhandler.post(new Runnable() {
                        @Override
                        public void run() {
                            p1.setProgress(mpgstatus);
                        }
                    });
                }

            }
        }).start();

        Thread th=new Thread(){
            @Override
            public void run(){
                try {
                    sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent obj=new Intent(Splash_Screen2.this,MainActivity.class);
                    startActivity(obj);
                }
            }
        };
        th.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

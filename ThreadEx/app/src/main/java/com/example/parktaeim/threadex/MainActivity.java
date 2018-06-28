package com.example.parktaeim.threadex;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    TextView timeTv;
    Button startBtn;

    Runnable timeRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeTv = (TextView) findViewById(R.id.timeTv);
        startBtn = (Button) findViewById(R.id.startBtn);

        startBtn.setOnClickListener(v->{
            Thread timeThread = new Thread(timeRunnable);
            timeThread.start();
        });

        timeRunnable = new Runnable() {
            @Override
            public void run() {
                int time = 0;
                while(true){
                    Message msg = new Message();
                    msg.what = 0;
                    msg.arg1 = time;
                    handler.sendMessage(msg);

                    try{
                        Thread.sleep(1000);
                        time++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 0){
                timeTv.setText(String.valueOf(msg.arg1));
            }
        }
    };
}


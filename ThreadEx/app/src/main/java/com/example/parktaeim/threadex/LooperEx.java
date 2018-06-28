package com.example.parktaeim.threadex;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;


/**
 * Created by parktaeim on 2018. 6. 3..
 */

public class LooperEx extends Thread {
    public Handler handler;

    @Override
    public void run() {
        Looper.prepare();

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {

            }
        };

        Looper.loop();
    }
}

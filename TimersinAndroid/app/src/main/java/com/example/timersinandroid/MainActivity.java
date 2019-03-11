package com.example.timersinandroid;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     /*  final Handler handler = new Handler();     //https://developer.android.com/reference/android/os/Handler

        Runnable run = new Runnable() {
            @Override
            public void run() {
              Log.i("Handler:","It is working");

              handler.postDelayed(this,1000);
            }
        };

         handler.post(run);

     */

     new CountDownTimer(10000,1000){

         public void onTick(long milliSecindsUntilDone){
             Log.i("Seconds Left:",String.valueOf(milliSecindsUntilDone/1000));
         }

         public void onFinish(){
             Log.i("We 'r Done!","No more countDown");
         }
     }.start();
    }
}

package com.example.eggtimer;


import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
     TextView timerTextView;
     ImageView eggImageView;
     ImageView brokenImageView;
    SeekBar countSeekBar;
    MediaPlayer mediaPlayer;
    Button countDownButton;
    CountDownTimer countDownTimer;
    boolean countCheck = false;

    public void reseter(){

        countCheck = false;
        timerTextView.setText("00:30");
        countSeekBar.setProgress(30);
        countSeekBar.setEnabled(true);
        countDownButton.setText("Go!");
        countDownTimer.cancel();

    }
    public void buttonClicked(View view){
        if (countCheck)
        {
          reseter();
        }else {
            countCheck = true;
            countSeekBar.setEnabled(false);
            countDownButton.setText("STOP!");
            eggImageView.animate().alpha(1);
            brokenImageView.animate().alpha(0);
             countDownTimer = new CountDownTimer(countSeekBar.getProgress() * 1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    updateTimer((int) millisUntilFinished / 1000);

                }

                @Override
                public void onFinish() {
                    mediaPlayer.start();
                    eggImageView.animate().alpha(0).setDuration(1000);
                    brokenImageView.animate().alpha(1).setDuration(1000);

                    reseter();
                }
            }.start();

        }
    }

    public void updateTimer(int secondsLeft){

        int minutes = secondsLeft/60;  //here secs is converted into it's equalent mins
        int seconds = secondsLeft - (minutes * 60);

        String secondsString;
        String minutesString;

        if (minutes < 10)
        {
            minutesString = "0" + Integer.toString(minutes);
        }else
        {
            minutesString = Integer.toString(minutes);
        }

        if (seconds < 10)
        {
            secondsString = "0" + Integer.toString(seconds);
        }else
        {
            secondsString = Integer.toString(seconds);
        }

        timerTextView.setText(minutesString + ":" + secondsString);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eggImageView = (ImageView) findViewById(R.id.eggImageView);
        countSeekBar = (SeekBar) findViewById(R.id.countSeekBar);
        brokenImageView = (ImageView) findViewById(R.id.brokenImageView);
         timerTextView = (TextView) findViewById(R.id.timerTextView);
        mediaPlayer = MediaPlayer.create(this,R.raw.buzz);
        countSeekBar.setMax(600);  //maximum 10 mins
        countSeekBar.setProgress(30);
        countDownButton =  findViewById(R.id.countDownButton);

        countSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

               updateTimer(progress);
                eggImageView.animate().alpha(1);
                brokenImageView.animate().alpha(0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}

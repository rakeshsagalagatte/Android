package com.example.user.sound;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;   //mediaPlayer is the variable of type "MediaPlayer". Here MediaPlayer is the class; By using it's variable the audio is working..

    AudioManager audioManager; // audioManger is also the variable but of the type "AudioManger"  . it is inbuilt class in which controlling the audio functions; to using that class we have declare it's variable;

    TextView textView;

    public void playSong(View view) {    // it is method to the play the song and it is going to intialized in xml activity to the Play Button in "OnClickMethod";

        mediaPlayer.start();    // "playerName.start()", Here "Start()" is the builtin method to start the audio;
    }

    public void pauseSong(View view) {  // it is for pauseing the audio and it will returns where the song is stoped using this Play button start the audio where the pause button is stoped the song.

        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();   //, Here "pause()" is the method to pause the audio.

        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);  // it is used for above intialized  "AudioManger audioManger ; " By default variable takes the Null , so audioManger variable return the NULL [if run the app before applaying this instruction , the app get crash]. to avoid that we have intialize the audioManger variable
        //so it will get intialized to "System Audio Service" By using the method called "getSystemService(AUDIO_SERVICE)"
         int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);   // intialization of currentVolume

        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);  //intialization of maxVolume variable;

        textView = (TextView) findViewById(R.id.textView);

        mediaPlayer = MediaPlayer.create(this, R.raw.matruje);  //to get or access the audio from respectd folder to mediaPlayer variable .

        SeekBar volumeSeekBar = (SeekBar) findViewById(R.id.volumeSeekBar);  // Seekbar is xml layout class Name . it is the intialization of seekbar using the variable or ID "volumeSeekBar";

        volumeSeekBar.setMax(maxVolume); // for differnt devices , different type of maximum value is be there [ex:- one device having 100 is the maximum value ,another device have 15 or 10 or 20 like maximum value],so to get to know that how much is the maximum volume that the device have  we use "seekBar_variable.setMax(maxvolume_Variable)" is used. "setMax()" is the method to get that value from device

        volumeSeekBar.setProgress(currentVolume); //  to intialize the volume has a  current value position of a seekbar.

        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Log.i("SeekBar changed", Integer.toString(progress));  //to check if it works or not and it will show the output in LOGCAT tab

                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0); // to set the volume stream in one side . maxvalue, current value all;

                String message = String.valueOf(progress);  //

                textView.setText(message);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final SeekBar scrubSeekBar = (SeekBar) findViewById(R.id.scrubSeekBar);

        scrubSeekBar.setMax(mediaPlayer.getDuration()); //to get maximum duration of that song;

        scrubSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Log.i("Scrub SeekBar", Long.toString(progress));  // at LOGCAT the msg will appear;

                mediaPlayer.seekTo(progress); //to tracing of exact position of song in seekbar;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        new  Timer().schedule(new TimerTask() {
            @Override
            public void run() {

              scrubSeekBar.setProgress( mediaPlayer.getCurrentPosition());
            }
        },0,10000);

    }

}


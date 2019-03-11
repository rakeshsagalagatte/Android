package com.example.basicphs;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public void playPhrases(View view){

        Button buttonPressed = (Button) view;
                                                                     //In the button section, each button contains a tag ... the tag name is different for each button , it should be the same name for given audio in the "raw" folder then only it should access the that audio .

        Log.i("Button Pressed", buttonPressed.getTag().toString());

        MediaPlayer mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(buttonPressed.getTag().toString(), "raw", getPackageName()));    //and that audio having the same name as that of the tag name of particular button

        mediaPlayer.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

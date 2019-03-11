package com.example.listtables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timeTableListView;

    public void generateTimeTable(int TimeTableNumber)
    {
        ArrayList<String> TimeTablelist = new ArrayList<String>();

        for (int j = 1 ; j <= 10; j++){

            TimeTablelist.add(Integer.toString(j * TimeTableNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, TimeTablelist);

        timeTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timeTableSeekBar = (SeekBar) findViewById(R.id.timeTableSeekBar);

        timeTableListView = (ListView) findViewById(R.id.timeTableListView);

        int max = 30;

        int current = 13;

        timeTableSeekBar.setMax(max);

        timeTableSeekBar.setProgress(current);

        generateTimeTable(current);

        timeTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min = 1,TimeTableNumber;

                if (progress < min){

                    TimeTableNumber = min;
                    timeTableSeekBar.setProgress(min);
                }else{

                    TimeTableNumber = progress;
                }

                Log.i("SeekBar Test", Integer.toString(TimeTableNumber));

                generateTimeTable(TimeTableNumber);

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

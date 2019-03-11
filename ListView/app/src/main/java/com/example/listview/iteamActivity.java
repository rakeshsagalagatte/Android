package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class iteamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iteam);

        ListView nowBecome = (ListView) findViewById(R.id.nowBecome);

        final ArrayList<String> NeCon = new ArrayList<String>(asList("Rob Percial","Walter","Necon"));


        final ArrayAdapter<String> NowarrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NeCon);

        nowBecome.setAdapter(NowarrayAdapter);

        nowBecome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Toast.makeText(iteamActivity.this, NeCon.get(position), Toast.LENGTH_LONG).show();  //in this way also

                 Toast.makeText(getApplicationContext(), "Hellow " + NeCon.get(position), Toast.LENGTH_LONG ).show();
            }
        });
    }
}

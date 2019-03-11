package com.example.user.u_just;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {




    public void ClickFunction(View view){

        EditText emailEditText = (EditText) findViewById(R.id.emailEditText);
        Log.i("this",emailEditText.toString());

        Toast.makeText(this, emailEditText.getText() + " Wellcome", Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button logInButton = findViewById(R.id.logInButton);
        Button signInButton = findViewById(R.id.signInButton);

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intir = new Intent(MainActivity.this,LoginMain.class);
                startActivity(intir);
            }
        });


        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sig = new Intent(MainActivity.this,SignUpMain.class);
                startActivity(sig);
            }
        });
    }
}

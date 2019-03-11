package com.example.user.u_just;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginMain extends AppCompatActivity {

    class Number {
        int number;


        public boolean isSquare(){

            double squareRoot = Math.sqrt(number);

            if(squareRoot == Math.floor(squareRoot)) {

                return true;
            } else {

                return false;
            }

        }

        public boolean isTriangular(){

            int x=1;

            int triangularNumber = 1;

            while (triangularNumber  < number)
            {
                x++;
                triangularNumber  = triangularNumber  + x;

            }

            if(triangularNumber  == number)
            {
                return( true);
            }else {
                return (false);

            }


        }

    }

    public void  testNumber(View view){

        EditText checkEditText = (EditText) findViewById(R.id.checkEditText);

        Log.i("info","Button pressed");

        String message;

        if (checkEditText.getText().toString().isEmpty())
        {
            message = "Please enter a Number.";
        }else {


            Number MyNumber = new Number();

            MyNumber.number = Integer.parseInt(checkEditText.getText().toString());

             message = checkEditText.getText().toString();

            if (MyNumber.isSquare() && MyNumber.isTriangular()) {
                message += " is a Both Square and Triangular Number ..";
            } else if (MyNumber.isTriangular()) {

                message += " is a Triangular Number .";

            } else if (MyNumber.isSquare()) {

                message += " is a Square number .";
            } else {

                message += " is neither a Square nor a triangular Number.";
            }

        }

        Toast.makeText(this, message , Toast.LENGTH_LONG).show();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
    }
}

package com.example.user.otheranimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void faded(View view) {

        ImageView bartimageView = (ImageView) findViewById(R.id.bartimageView);

        ImageView homerimageView = (ImageView) findViewById(R.id.homerimageView);

        //bartimageView.animate().translationXBy(1000).setDuration(2000);    //(This is for right side moving og image);

       // bartimageView.animate().translationYBy(1000).setDuration(2000);      //(This is for down side moving og image);

       // bartimageView.animate().translationXBy(-1000).setDuration(2000);      //(This is for left side moving og image);

        //bartimageView.animate().translationYBy(-1000).setDuration(2000);         //(This is for upside  moving og image);

       // bartimageView.animate().rotation(1800).setDuration(1000);   //(This for rotation of image .. In rotaion method have to given the degree it going to be rotation.)

       // bartimageView.animate().rotation(1800).alpha(0).setDuration(1000);    //This is going disappearing along with rotation..

      // bartimageView.animate().scaleX(0.5f).scaleY(0.5f).setDuration(1000);   //In this "scale" factore is used to re-sizing the image ... And also here we noticed that in-side scale method we used "f" just after the "0.5" , This is becz to represent the double in that method..



        // the above lines code .U must enable only one line of code to performance it is just showing how many ways we have to use it ..


        // THIS IS FOR THE APP STARTING WITH WHITE SCREEN AND IMAGE WILL COME FROM THE LEFT BY ROTATING TO THE CENTER .. THE BELOW CODE IS ...-->








    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView bartimageView = (ImageView) findViewById(R.id.bartimageView);        //The reaseon why we wrighting the code under the "Override" is the below code happing when the app is started

        bartimageView.setX(-1000);          // when we want appears somthing as soon as the app is start running then we should code below of "Override";

        bartimageView.animate().translationXBy(1000).rotation(3600).setDuration(2000);
    }
}

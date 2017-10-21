package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**Called when the user taps the Send button */
    public void sendMessage(View view){
        RemoveButton();
        Intent intent = new Intent(this, BeginGame.class);
        startActivity(intent); 
    }

    private void RemoveButton(){
        /*Button*/
        final Button beginButton = (Button) findViewById(R.id.begin_button);
        /*Animations*/
        final Animation out = new AlphaAnimation(1.0f, 0.0f);
        out.setDuration(1000);
        beginButton.startAnimation(out);
        beginButton.setVisibility(View.GONE);
    }

    private void BeginGame(){
        /*Randomly spawn button*/
        Random buttonSpawn;
        /*Timer*/
        TextView timeRemaining = (TextView) findViewById(R.id.timeLeft);
        timeRemaining.setVisibility(View.VISIBLE);
        int remainingTime = 100;

        long timeout = System.currentTimeMillis() + (remainingTime * 1000);

        while(System.currentTimeMillis() < timeout){
            timeRemaining.setText("You have: " + (timeout - System.currentTimeMillis()) / 1000 + " seconds left");
            timeout--;
        }
    }
}


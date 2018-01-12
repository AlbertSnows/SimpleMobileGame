package com.example.myfirstapp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    GameView theGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        theGame = new GameView(this);
        setContentView(theGame);
    }
    @Override
    protected void onResume(){
        super.onResume();
        theGame.resume();
    }
}


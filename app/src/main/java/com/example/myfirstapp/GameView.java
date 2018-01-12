package com.example.myfirstapp;
import android.content.Context;
import android.view.SurfaceView;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

/**
 * Created by Savy Blizzard on 11/26/2017.
 */
public class GameView extends SurfaceView implements Runnable {
    /*Variables*/
    Thread mainGameThread = null;
    SurfaceHolder holdSurface;
    volatile boolean playing;
    Canvas canvas;
    Paint paint;
    long fps;
    private long timeThisFrame;
    Bitmap bitmmapCircle;
    boolean circleExists = false;
    boolean isShrinking = false;
    float shrinkRate = 10;
    float circleLocation;;


    /*Methods*/
    public GameView(Context context){
        super(context);
        holdSurface = getHolder();
        paint = new Paint();
       // bitmapCircle = CREATE A CIRCLE JESUS CHIRST
    }
    @Override
    public void run(){
    }

////////////////////////////////////////////////////////////
    /*Remove begin game button*/
    private void RemoveButton(){
        /*Button*/
        final Button beginButton = (Button) findViewById(R.id.begin_button);
        /*Animations*/
        final Animation out = new AlphaAnimation(1.0f, 0.0f);
        out.setDuration(1000);
        beginButton.startAnimation(out);
        beginButton.setVisibility(View.GONE);
    }

    /*Game content*/
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

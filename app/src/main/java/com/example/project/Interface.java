package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Interface extends AppCompatActivity {

    Button b1,b2,b3;
    Intent intentStart;
    static final String DIFFICULTY1 = "difficulty";
    Animation up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);
        up = AnimationUtils.loadAnimation(this,R.anim.up);

        b1 = (Button)findViewById(R.id.bu1);
        b1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP){
                    intentStart.putExtra(DIFFICULTY1,"Easy");
                    startActivity(intentStart);
                } else if (motionEvent.getAction()==MotionEvent.ACTION_DOWN)
                    b1.startAnimation(up);
                return true;
            }
        });
        b2 = (Button)findViewById(R.id.bu2);
        b2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP){
                    intentStart.putExtra(DIFFICULTY1,"Intermediate");
                    startActivity(intentStart);
                } else if (motionEvent.getAction()==MotionEvent.ACTION_DOWN)
                    b2.startAnimation(up);
                return true;
            }
        });
        b3 = (Button)findViewById(R.id.bu3);
        b3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_UP){
                    intentStart.putExtra(DIFFICULTY1,"Pro9000");
                    startActivity(intentStart);
                } else if (motionEvent.getAction()==MotionEvent.ACTION_DOWN)
                    b3.startAnimation(up);
                return true;
            }
        });


        intentStart = new Intent(Interface.this, Practice2.class);
    }



}

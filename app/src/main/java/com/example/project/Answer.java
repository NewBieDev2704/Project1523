package com.example.project;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.project.Practice2.ID;

public class Answer extends AppCompatActivity {

    ImageView answer;
    Button button;
    int id;
    Animation up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        answer = (ImageView) findViewById(R.id.answer);
        button = (Button) findViewById(R.id.back);
        up = AnimationUtils.loadAnimation(this, R.anim.up);

        id = getResources().getIdentifier(getIntent().getStringExtra(ID),null,getPackageName());
        answer.setImageResource(id);


        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                        button.startAnimation(up);
                    else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                        button.startAnimation(up);
                        finish();
                        }
                return true;
            }
        });



    }}



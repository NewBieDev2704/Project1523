package com.example.project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    Button practice,theory,help;
    ImageButton man;
    Animation up;
    int tap=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        practice = (Button) findViewById(R.id.practice);
        theory = (Button) findViewById(R.id.theory);
        help = (Button) findViewById(R.id.help);
        man = (ImageButton) findViewById(R.id.manBot);
        up = AnimationUtils.loadAnimation(this, R.anim.up);

        practice.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    practice.startAnimation(up);
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    toInterface();
                }
                return true;
            }
        });
        theory.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN)
                   theory.startAnimation(up);
                else if (motionEvent.getAction()==MotionEvent.ACTION_UP){
                    toTheory();
                }
                return true;
            }
        });
        help.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN)
                    help.startAnimation(up);
                else if (motionEvent.getAction()==MotionEvent.ACTION_UP){
                    toHelp();
                }
                return true;
            }
        });
        man.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    man.startAnimation(up);
                    tap++;
                    }
                else if (motionEvent.getAction()==MotionEvent.ACTION_UP){
                    if (tap%10==0){
                        tap=0;
                        man.setImageResource(R.drawable.ic_osuzhdayu_svg);
                        Toast.makeText(getApplicationContext(),"Твоя манера речи клоунская меня не впечатляет",Toast.LENGTH_LONG).show();
                        }
                    else
                        Toast.makeText(getApplicationContext(),"Lthxr Animesuck",Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

    }


    private void toInterface() {
        Intent intent = new Intent(MainActivity.this, Interface.class);
        startActivity(intent);
    }

    private void toTheory(){}

    private void toHelp(){
        Intent intent = new Intent(MainActivity.this, Help.class);
        startActivity(intent);

    }



}
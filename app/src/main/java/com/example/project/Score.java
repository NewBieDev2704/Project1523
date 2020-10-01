package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Score extends AppCompatActivity {

    TextView scoreQ;
    String s;
    ImageButton home;
    ImageView emoji;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreQ = (TextView) findViewById(R.id.scoreQ);
        home = (ImageButton) findViewById(R.id.h);
        emoji = (ImageView) findViewById(R.id.e);
        setScore(getIntent().getStringExtra("NAME"));

        //scoreQ.setText(getIntent().getStringExtra("NAME"));

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(Score.this,MainActivity.class);
                startActivity(intentHome);
            }
        });

    }

    void setScore(String s){
        this.s = s;
        scoreQ.setText(s);
        switch (Integer.parseInt(s)){
            case 0:
                emoji.setImageResource(R.drawable.ic_osuzhdayu_svg);
                break;
            case 1:
                emoji.setImageResource(R.drawable.ic_dude_svg);
                break;
            case 2:
                emoji.setImageResource(R.drawable.ic_thinking_svg);
                break;
            case 3:
                emoji.setImageResource(R.drawable.ic_thumbs_svg);
                break;
            case 4:
                emoji.setImageResource(R.drawable.ic_smile_svg);
        }
    }


}

package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;

import static com.example.project.Interface.DIFFICULTY1;

public class Practice2 extends AppCompatActivity implements View.OnTouchListener {
    ImageView question, h1, h2, h3;
    ImageButton btn1, btn2, btn3, btn4;
    TextView text_score;
    TextView qCount;
    Button confirm,hi;
    List<Questions> questionList;
    int qCounter;
    int qCounterTotal;
    int id;
    Questions currentQuestion;
    int id1, id2, id3, id4, id5;
    public int score;
    boolean answered,hinted;
    static final String ID = "ID";
    public String answer,hint,correct;
    int hearts = 3;
    ImageView[] allHearts = new ImageView[3];
    Animation up;
    String qanswer,qhint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice2);

        question = (ImageView) findViewById(R.id.question_id);
        h1 = (ImageView) findViewById(R.id.l1);
        allHearts[0] = h1;
        h2 = (ImageView) findViewById(R.id.l2);
        allHearts[1] = h2;
        h3 = (ImageView) findViewById(R.id.l3);
        allHearts[2] = h3;
        btn1 = (ImageButton) findViewById(R.id.answ1);
        btn1.setOnTouchListener(this);
        btn2 = (ImageButton) findViewById(R.id.answ2);
        btn2.setOnTouchListener(this);
        btn3 = (ImageButton) findViewById(R.id.answ3);
        btn3.setOnTouchListener(this);
        btn4 = (ImageButton) findViewById(R.id.answ4);
        btn4.setOnTouchListener(this);
        text_score = (TextView) findViewById(R.id.score);
        confirm = (Button) findViewById(R.id.confirm);
        confirm.setOnTouchListener(this);
        hi = (Button) findViewById(R.id.hint);
        hi.setOnTouchListener(this);
        qCount = (TextView) findViewById(R.id.question_num);
        Intent intent = getIntent();
        String diff = intent.getStringExtra(DIFFICULTY1);
        up = AnimationUtils.loadAnimation(this, R.anim.up);


        MenuDbHelper dbHelper = new MenuDbHelper(this);
        questionList = dbHelper.getQuestions(diff);
        qCounterTotal = questionList.size();
        Collections.shuffle(questionList);


        showNextQ();

    }

    private void showNextQ() {
        if (qCounter < qCounterTotal) {
            currentQuestion = questionList.get(qCounter);
            id1 = getResources().getIdentifier(currentQuestion.getQuestion(), null, getPackageName());
            id2 = getResources().getIdentifier(currentQuestion.getOpt1(), null, getPackageName());
            id3 = getResources().getIdentifier(currentQuestion.getOpt2(), null, getPackageName());
            id4 = getResources().getIdentifier(currentQuestion.getOpt3(), null, getPackageName());
            id5 = getResources().getIdentifier(currentQuestion.getOpt4(), null, getPackageName());
            qanswer = currentQuestion.getAnswer();
            qhint = currentQuestion.getHint1();
            question.setImageResource(id1);
            btn1.setImageResource(id2);
            btn2.setImageResource(id3);
            btn3.setImageResource(id4);
            btn4.setImageResource(id5);
            btn1.setBackgroundResource(R.drawable.man);
            btn2.setBackgroundResource(R.drawable.man);
            btn3.setBackgroundResource(R.drawable.man);
            btn4.setBackgroundResource(R.drawable.man);
            setEnb();
            qCounter++;
            qCount.setText("Задача: " + qCounter + "/ " + qCounterTotal);
            answered = false;
            hinted = false;

            confirm.setText(". . . ");
        } else {
            confirm.setText("Результат");
        }

    }

    public void finishApp() {
        Intent Score_intent = new Intent(Practice2.this, Score.class);
        Score_intent.putExtra("NAME", Integer.toString(score));
        startActivity(Score_intent);
    }

    @Override
    public boolean onTouch(View v, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            switch (v.getId()) {
                case R.id.hint:
                    showHint(qhint);
                    hinted = true;
                    hi.setEnabled(false);
                    qhint = currentQuestion.getHint2();
                    break;
                case R.id.answ1:
                        if (currentQuestion.getAnsNr() == 1) {
                            correct = "true";
                            id = 1;
                            showCor(correct,id);
                            correct = "";
                            confirm.setText("Следующая задача");
                            answered = true;
                            setDis();
                            break;
                        }
                        {
                            correct = "false";
                            id = 1;
                            showCor(correct,id);
                            correct = "";
                            answered = true;
                            confirm.setText("Показать ответ");
                            break;
                        }
                case R.id.answ2:
                        if (currentQuestion.getAnsNr() == 2) {
                            correct = "true";
                            id = 2;
                            showCor(correct,id);
                            correct = "";
                            confirm.setText("Следующая задача");
                            answered = true;
                            setDis();
                            break;
                        }
                        {
                            correct = "false";
                            id = 2;
                            showCor(correct,id);
                            correct = "";
                            answered = true;
                            confirm.setText("Показать ответ");
                            break;
                    }
                case R.id.answ3:

                        if (currentQuestion.getAnsNr() == 3) {
                            correct = "true";
                            id = 3;
                            showCor(correct,id);
                            correct = "";
                            confirm.setText("Следующая задача");
                            answered = true;
                            setDis();
                            break;
                        }
                        {
                            correct = "false";
                            id = 3;
                            showCor(correct,id);
                            correct = "";
                            answered = true;
                            confirm.setText("Показать ответ");
                            break;
                        }

                case R.id.answ4:
                        if (currentQuestion.getAnsNr() == 4) {
                            correct = "true";
                            id = 4;
                            showCor(correct,id);
                            correct = "";
                            confirm.setText("Следующая задача");
                            answered = true;
                            setDis();
                            break;
                    }
                {
                    correct = "false";
                    id = 4;
                    showCor(correct,id);
                    correct = "";
                    answered = true;
                    confirm.setText("Показать ответ");
                    break;
                }
                case R.id.confirm:
                        if (answered){
                            if (confirm.getText()=="Следующая задача"){
                                showNextQ();
                            } else if (confirm.getText()=="Показать ответ"){
                                setDis();
                                showAnswer(qanswer);
                                confirm.setText("Следующая задача");
                            } else if (confirm.getText()=="Результат"){
                                finishApp();
                            }
                        } else Toast.makeText(getApplicationContext(),"Выберите ответ", Toast.LENGTH_SHORT).show();
            }
        } else if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            switch (v.getId()) {
                case R.id.answ1:
                    btn1.startAnimation(up);
                    break;
                case R.id.answ2:
                    btn2.startAnimation(up);
                    break;
                case R.id.answ3:
                    btn3.startAnimation(up);
                    break;
                case R.id.answ4:
                    btn4.startAnimation(up);
                    break;
                case R.id.confirm:
                    confirm.startAnimation(up);
                    break;
                case R.id.hint:
                    hi.startAnimation(up);
                    break;
            }

        }
        return true;
    }

    public void showCor(String correct,int id) {

        this.correct = correct;
        this.id = id;
        //LayoutInflater inflater = getLayoutInflater();
        //View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_layout));

        //Toast toast = new Toast(getApplicationContext());
        //toast.setGravity(Gravity.TOP, 0, 0);
        //toast.setDuration(Toast.LENGTH_LONG);
        //toast.setView(layout);

        //toast.show();
        if (correct.equals("true")){
        if (hearts > 0){
            switch (id){
                case 1:
                    btn1.setBackgroundResource(R.drawable.goodman);
                    break;
                case 2:
                    btn2.setBackgroundResource(R.drawable.goodman);
                    break;
                case 3:
                    btn3.setBackgroundResource(R.drawable.goodman);
                    break;
                case 4:
                    btn4.setBackgroundResource(R.drawable.goodman);
                    break;
            }
            if (hinted!=true)
                score++;
            else {}
        }
        else {
        }
        text_score.setText("Счёт: " + score);
    } else {
            hearts--;
            switch (id){
                case 1:
                    btn1.setBackgroundResource(R.drawable.badman);
                    break;
                case 2:
                    btn2.setBackgroundResource(R.drawable.badman);
                    break;
                case 3:
                    btn3.setBackgroundResource(R.drawable.badman);
                    break;
                case 4:
                    btn4.setBackgroundResource(R.drawable.badman);
                    break;
            }
            if (hinted)
                hi.setEnabled(true);
            if (hearts > -1) {
                allHearts[hearts].setImageResource(R.drawable.ic_lens_black_24dp);
            } if (hearts==0) finishApp();}
    }

    //public void showInCor() {
        //LayoutInflater inflater = getLayoutInflater();
        //View layout = inflater.inflate(R.layout.inc_toast_layout, (ViewGroup) findViewById(R.id.inc_layout));

        //Toast toast = new Toast(getApplicationContext());
        //toast.setGravity(Gravity.TOP, 0, 0);
        //toast.setDuration(Toast.LENGTH_LONG);
        //toast.setView(layout);
        //hearts--;
        //if (hinted)
            //hi.setEnabled(true);
        //if (hearts > -1) {
            //allHearts[hearts].setImageResource(R.drawable.ic_lens_black_24dp);
        //} if (hearts==0) finishApp();

        //toast.show();
    //}

    public void showAnswer(String answer1) {
        this.answer = answer1;
        Intent ansIntent = new Intent(Practice2.this, Answer.class);
        ansIntent.putExtra(ID, answer1);
        startActivity(ansIntent);

    }

    private void setEnb(){
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        hi.setEnabled(true);
    }

    private void setDis(){
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        hi.setEnabled(false);
    }

    public void showHint(String hint1){
        this.hint = hint1;
        Intent ansIntent = new Intent(Practice2.this, Answer.class);
        ansIntent.putExtra(ID, hint1);
        startActivity(ansIntent);
    }
}




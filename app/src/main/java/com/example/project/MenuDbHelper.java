package com.example.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.project.Contract.*;

import java.util.ArrayList;
import java.util.List;

public class MenuDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "App.db";
    private static final int DATABASE_VERSION = 13;

    private SQLiteDatabase db;


    public MenuDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.OPT_1 + " TEXT, " +
                QuestionsTable.OPT_2 + " TEXT, " +
                QuestionsTable.OPT_3 + " TEXT, " +
                QuestionsTable.OPT_4 + " TEXT, " +
                QuestionsTable.COLUMN_ANS_NR + " INTEGER, " +
                QuestionsTable.COLUMN_DIFFICULTY + " TEXT, " +
                QuestionsTable.ANSWER + " TEXT, " +
                QuestionsTable.HINT1 + " TEXT, " +
                QuestionsTable.HINT2 + " TEXT " +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        questionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void questionsTable() {
        Questions q1 = new Questions("drawable/ic_1_1_1", "drawable/ic_1_11", "drawable/ic_1_12", "drawable/ic_1_13", "drawable/ic_drive_eta_black_24dp", 1, Questions.EASY,"drawable/ic_all","drawable/ic_sadman_text","drawable/ic_sadman_text");
        addQuestions(q1);
        Questions q2 = new Questions("drawable/ic_1_1_2", "drawable/ic_1_22", "drawable/ic_1_21", "drawable/ic_1_23", "drawable/ic_drive_eta_black_24dp", 2, Questions.EASY,null,"drawable/ic_sadman_text","drawable/ic_sadman_text");
        addQuestions(q2);
        Questions q3 = new Questions("drawable/ic_1_1_3", "drawable/ic_1_33", "drawable/ic_1_31", "drawable/ic_done_black_24dp", "drawable/ic_1_32", 2, Questions.EASY,null,"drawable/ic_sadman_text","drawable/ic_sadman_text");
        addQuestions(q3);
        Questions q4 = new Questions("drawable/ic_1_1_4", "drawable/ic_1_43", "drawable/ic_answ2", "drawable/ic_1_42", "drawable/ic_1_41", 4, Questions.EASY,null,"drawable/ic_sadman_text","drawable/ic_sadman_text");
        addQuestions(q4);
        Questions q5 = new Questions("drawable/ic_1_1_5", "drawable/ic_1_52", "drawable/ic_1_53", "drawable/ic_1_51", "drawable/ic_drive_eta_black_24dp", 3, Questions.EASY,null,"drawable/ic_sadman_text","drawable/ic_sadman_text");
        addQuestions(q5);
        Questions q6 = new Questions("drawable/ic_1_1_6", "drawable/ic_1_63", "drawable/ic_1_61", "drawable/ic_done_black_24dp", "drawable/ic_1_62", 2, Questions.EASY,null,"drawable/ic_sadman_text","drawable/ic_sadman_text");
        addQuestions(q6);
        Questions q7 = new Questions("drawable/ic_2_1_1", "drawable/ic_2_11", "drawable/ic_2_12", "drawable/ic_2_13", "drawable/ic_2_14", 1, Questions.MEDIUM,"drawable/ic_2_1_ans","drawable/ic_2_1_hint1","drawable/ic_sadman_text");
        addQuestions(q7);
        Questions q8 = new Questions("drawable/ic_2_1_2", "drawable/ic_answ1", "drawable/ic_answ2", "drawable/ic_2_21", "drawable/ic_drive_eta_black_24dp", 3, Questions.MEDIUM,"drawable/ic_2_2_ans","drawable/ic_2_2_hint1","drawable/ic_sadman_text");
        addQuestions(q8);
        Questions q9 = new Questions("drawable/ic_3_1_1", "drawable/ic_3_11", "drawable/ic_answ2", "drawable/ic_done_black_24dp", "drawable/ic_drive_eta_black_24dp", 1, Questions.HARD,"drawable/ic_3_1_ans","drawable/ic_3_1_hint1","drawable/ic_3_1_hint2");
        addQuestions(q9);
        Questions q10 = new Questions("drawable/ic_3_1_2", "drawable/ic_answ1", "drawable/ic_answ2", "drawable/ic_done_black_24dp", "drawable/ic_3_21", 4, Questions.HARD,"drawable/ic_3_2_ans","drawable/ic_3_2_hint1","drawable/ic_3_2_hint2");
        addQuestions(q10);
        Questions q11 = new Questions("drawable/ic_3_1_3", "drawable/ic_3_31", "drawable/ic_answ2", "drawable/ic_done_black_24dp", "drawable/ic_drive_eta_black_24dp", 1, Questions.HARD,"drawable/ic_3_3_ans","drawable/ic_3_3_hint1","drawable/ic_3_3_hint2");
        addQuestions(q11);
        Questions q12 = new Questions("drawable/ic_3_1_4", "drawable/ic_answ1", "drawable/ic_3_41", "drawable/ic_done_black_24dp", "drawable/ic_drive_eta_black_24dp", 2, Questions.HARD,"drawable/ic_3_4_ans","drawable/ic_3_4_hint1","drawable/ic_3_4_hint2");
        addQuestions(q12);
        Questions q13 = new Questions("drawable/ic_3_1_5", "drawable/ic_answ1", "drawable/ic_17_answer", "drawable/ic_3_51", "drawable/ic_drive_eta_black_24dp", 3, Questions.HARD,"drawable/ic_3_5_ans","drawable/ic_3_5_hint1","drawable/ic_3_5_hint2");
        addQuestions(q13);
        Questions q14 = new Questions("drawable/ic_3_1_6", "drawable/ic_answ1", "drawable/ic_17_answer", "drawable/ic_done_black_24dp", "drawable/ic_3_61", 4, Questions.HARD,"drawable/ic_3_6_ans","drawable/ic_3_6_hint1","drawable/ic_3_6_hint2");
        addQuestions(q14);
        Questions q15 = new Questions("drawable/ic_2_1_3", "drawable/ic_answ1", "drawable/ic_2_31", "drawable/ic_done_black_24dp", "drawable/ic_drive_eta_black_24dp", 2, Questions.MEDIUM,"drawable/ic_2_3_ans","drawable/ic_2_3_hint1","drawable/ic_sadman_text");
        addQuestions(q15);
        Questions q16 = new Questions("drawable/ic_2_1_4", "drawable/ic_answ1", "drawable/ic_17_answer", "drawable/ic_2_41", "drawable/ic_drive_eta_black_24dp", 3, Questions.MEDIUM,"drawable/ic_2_4_ans","drawable/ic_2_4_hint1","drawable/ic_sadman_text");
        addQuestions(q16);
        Questions q17 = new Questions("drawable/ic_2_1_5", "drawable/ic_2_51", "drawable/ic_17_answer", "drawable/ic_done_black_24dp", "drawable/ic_drive_eta_black_24dp", 1, Questions.MEDIUM,"drawable/ic_2_5_ans","drawable/ic_2_5_hint1","drawable/ic_sadman_text");
        addQuestions(q17);
    }

    private void addQuestions(Questions question){
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.OPT_1, question.getOpt1());
        cv.put(QuestionsTable.OPT_2, question.getOpt2());
        cv.put(QuestionsTable.OPT_3, question.getOpt3());
        cv.put(QuestionsTable.OPT_4, question.getOpt4());
        cv.put(QuestionsTable.COLUMN_ANS_NR, question.getAnsNr());
        cv.put(QuestionsTable.COLUMN_DIFFICULTY, question.getDifficulty());
        cv.put(QuestionsTable.ANSWER, question.getAnswer());
        cv.put(QuestionsTable.HINT1, question.getHint1());
        cv.put(QuestionsTable.HINT2, question.getHint2());
        db.insert(QuestionsTable.TABLE_NAME, null, cv );


    }

    public List<Questions> getAll(){
        List<Questions> qList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Questions question = new Questions();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOpt1(c.getString(c.getColumnIndex(QuestionsTable.OPT_1)));
                question.setOpt2(c.getString(c.getColumnIndex(QuestionsTable.OPT_2)));
                question.setOpt3(c.getString(c.getColumnIndex(QuestionsTable.OPT_3)));
                question.setOpt4(c.getString(c.getColumnIndex(QuestionsTable.OPT_4)));
                question.setAnsNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANS_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                question.setAnswer(c.getString(c.getColumnIndex(QuestionsTable.ANSWER)));
                question.setHint1(c.getString(c.getColumnIndex(QuestionsTable.HINT1)));
                question.setHint2(c.getString(c.getColumnIndex(QuestionsTable.HINT2)));
                qList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return qList;
    }

    public ArrayList<Questions> getQuestions(String difficulty){
        ArrayList<Questions> qList = new ArrayList<>();
        db = getReadableDatabase();

        String[] selectionArgs = new String[]{difficulty};
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME +
                " WHERE " + QuestionsTable.COLUMN_DIFFICULTY + " = ? ", selectionArgs);

        if (c.moveToFirst()) {
            do {
                Questions question = new Questions();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOpt1(c.getString(c.getColumnIndex(QuestionsTable.OPT_1)));
                question.setOpt2(c.getString(c.getColumnIndex(QuestionsTable.OPT_2)));
                question.setOpt3(c.getString(c.getColumnIndex(QuestionsTable.OPT_3)));
                question.setOpt4(c.getString(c.getColumnIndex(QuestionsTable.OPT_4)));
                question.setAnsNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANS_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                question.setAnswer(c.getString(c.getColumnIndex(QuestionsTable.ANSWER)));
                question.setHint1(c.getString(c.getColumnIndex(QuestionsTable.HINT1)));
                question.setHint2(c.getString(c.getColumnIndex(QuestionsTable.HINT2)));
                qList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return qList;
    }
}

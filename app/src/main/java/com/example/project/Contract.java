package com.example.project;

import android.provider.BaseColumns;

public final class Contract {
    //Чтобы не использовать этот класс не по назначению
    private Contract(){}

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String OPT_1 = "image1";
        public static final String OPT_2 = "image2";
        public static final String OPT_3 = "image3";
        public static final String OPT_4 = "image4";
        public static final String COLUMN_ANS_NR = "ans_nr";
        public static final String COLUMN_DIFFICULTY = "difficulty";
        public static final String ANSWER = "answer";
        public static final String HINT1 = "hint1";
        public static final String HINT2 = "hint2";


    }
}

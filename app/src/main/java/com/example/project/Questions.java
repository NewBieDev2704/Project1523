package com.example.project;

import android.os.Parcel;
import android.os.Parcelable;

public class Questions implements Parcelable {
    public static final String EASY= "Easy";
    public static final String MEDIUM= "Intermediate";
    public static final String HARD= "Pro9000";
    private String question;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
    private int ansNr;
    private String answer;
    private String difficulty;
    private String hint1,hint2;

    public Questions() {}

    public Questions(String question, String opt1, String opt2, String opt3, String opt4, int ansNr, String difficulty, String answer, String hint1, String hint2) {
        this.question = question;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
        this.ansNr = ansNr;
        this.difficulty = difficulty;
        this.answer = answer;
        this.hint1 = hint1;
        this.hint2 = hint2;
    }

    protected Questions(Parcel in) {
        question = in.readString();
        opt1 = in.readString();
        opt2 = in.readString();
        opt3 = in.readString();
        opt4 = in.readString();
        ansNr = in.readInt();
        difficulty = in.readString();
        hint1 = in.readString();
        hint2 = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(opt1);
        dest.writeString(opt2);
        dest.writeString(opt3);
        dest.writeString(opt4);
        dest.writeInt(ansNr);
        dest.writeString(difficulty);
        dest.writeString(hint1);
        dest.writeString(hint2);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Questions> CREATOR = new Creator<Questions>() {
        @Override
        public Questions createFromParcel(Parcel in) {
            return new Questions(in);
        }

        @Override
        public Questions[] newArray(int size) {
            return new Questions[size];
        }
    };

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public String getOpt4() {
        return opt4;
    }

    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }

    public int getAnsNr() {
        return ansNr;
    }

    public void setAnsNr(int ansNr) {
        this.ansNr = ansNr;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getHint1() {
        return hint1;
    }

    public void setHint1(String hint) {
        this.hint1 = hint;
    }

    public String getHint2() {
        return hint2;
    }

    public void setHint2(String hint2) {
        this.hint2 = hint2;
    }

    public static String[] getAllDifficultyLevels() {
        return new String[]{
                EASY,
                MEDIUM,
                HARD
        };
    }
}

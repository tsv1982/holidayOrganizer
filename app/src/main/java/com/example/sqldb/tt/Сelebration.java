package com.example.sqldb.tt;

import com.example.sqldb.tt.TextCelebration;

public class Сelebration {
    private int id;


    private String dateCelebration;
    private TextCelebration textCelebration;

    public Сelebration(int id, String dateCelebration, TextCelebration textCelebration) {
        this.id = id;
        this.dateCelebration = dateCelebration;
        this.textCelebration = textCelebration;
    }

    public Сelebration() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateCelebration() {
        return dateCelebration;
    }

    public void setDateCelebration(String dateCelebration) {
        this.dateCelebration = dateCelebration;
    }

    public TextCelebration getTextCelebration() {
        return textCelebration;
    }

    public void setTextCelebration(TextCelebration textCelebration) {
        this.textCelebration = textCelebration;
    }
}

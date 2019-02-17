package com.example.sqldb.tt;

public class TextCelebration {
    private int id;
    private String textCelebration;

    public TextCelebration(int id, String textCelebration) {
        this.id = id;
        this.textCelebration = textCelebration;
    }

    public TextCelebration(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextCelebration() {
        return textCelebration;
    }

    public void setTextCelebration(String textCelebration) {
        this.textCelebration = textCelebration;
    }
}

package com.example.sqldb.tt;

import android.media.Image;

public class Peple {
    private int id;
    private String name;
    private String dateofBirth;
    private String telNumber;
    private Image foto;
    private TextCelebration textCelebration;

    public Peple(){

    }

    public Peple(int id, String name, String dateofBirth, String telNumber, Image foto, TextCelebration textCelebration) {
        this.id = id;
        this.name = name;
        this.dateofBirth = dateofBirth;
        this.telNumber = telNumber;
        this.foto = foto;
        this.textCelebration = textCelebration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public TextCelebration getTextCelebration() {
        return textCelebration;
    }

    public void setTextCelebration(TextCelebration textCelebration) {
        this.textCelebration = textCelebration;
    }


}

package com.example.sqldb.tt;

import android.media.Image;

import java.util.ArrayList;

public class DB {

    private ArrayList<Peple> listPeople = new ArrayList();
    private ArrayList<Сelebration> listCelebration = new ArrayList<>();
    private ArrayList<TextCelebration> listTextCelebration = new ArrayList<>();

    private Peple peple;
    private Сelebration celebration;
    private TextCelebration text;


    public DB() {
addTextCelebration(0, "поздравляю с праз");
addTextCelebration(1, "c праздником");

addPeople(0, "оля", "10-02-1982", "+380996473917",
        null, getListTextCelebration().get(0) );
addPeople(1, "сеня", "30-12-2012", "+3807765814",
        null, getListTextCelebration().get(1));
addCelebration(0, "14-07-2001", getListTextCelebration().get(0));
addCelebration(1, "18-09-2007", getListTextCelebration().get(1));



    }

    void addPeople(int id, String name, String dateofBirth, String telNumber,
                   Image foto, TextCelebration textCelebration) {

        peple = new Peple();
        peple.setId(id);
        peple.setName(name);
        peple.setDateofBirth(dateofBirth);
        peple.setTelNumber(telNumber);
        peple.setFoto(foto);
        peple.setTextCelebration(textCelebration);

        listPeople.add(peple);
    }

    void addCelebration(int id, String dateCelebration, TextCelebration textCelebration) {
        celebration = new Сelebration();
        celebration.setDateCelebration(dateCelebration);
        celebration.setId(id);
        celebration.setTextCelebration(textCelebration);
        listCelebration.add(celebration);
    }

    void addTextCelebration(int id, String textCelebration) {
        text = new TextCelebration();
        text.setId(id);
        text.setTextCelebration(textCelebration);
        listTextCelebration.add(text);
    }

    public ArrayList<TextCelebration> getListTextCelebration() {
        return listTextCelebration;
    }
}

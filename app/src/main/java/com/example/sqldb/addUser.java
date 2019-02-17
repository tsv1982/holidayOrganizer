package com.example.sqldb;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TimePicker;

import java.util.Date;

public class addUser extends AppCompatActivity implements View.OnClickListener,
        View.OnFocusChangeListener, CompoundButton.OnCheckedChangeListener {

    private final int DIALOG_DATE = 1;
    private final int DIALOG_TIME = 2;
    private int myYear;
    private int myMonth;
    private int myDay;
    private int myHour;
    private int myMinute;

    private EditText editName;
    private EditText editCelebration;
    private EditText editDate;
    private EditText editTime;
    private Switch aSwitchSendSms;
    private EditText editNumTel;
    private Switch aSwitchCongratulation;
    private EditText editTextCongratulation;
    private EditText enterTextCongratulation;


    private Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        editName = findViewById(R.id.editName);
        editName.setOnClickListener(this);
        editName.setOnFocusChangeListener(this);

        editCelebration = findViewById(R.id.edit_name_celebration);
        editCelebration.setOnClickListener(this);
        editCelebration.setOnFocusChangeListener(this);

        editDate = findViewById(R.id.tvDate);
        editDate.setOnClickListener(this);

        editTime = findViewById(R.id.tvTime);
        editTime.setOnClickListener(this);

        aSwitchSendSms = findViewById(R.id.switch1);
        aSwitchSendSms.setOnCheckedChangeListener(this);

        editNumTel = findViewById(R.id.edit_num_tel);
        editNumTel.setOnClickListener(this);
        editNumTel.setVisibility(View.INVISIBLE);
        editNumTel.setOnFocusChangeListener(this);

        aSwitchCongratulation = findViewById(R.id.switch2);
        aSwitchCongratulation.setOnCheckedChangeListener(this);

        editTextCongratulation = findViewById(R.id.edit_congratulation);
        editTextCongratulation.setVisibility(View.INVISIBLE);
        editTextCongratulation.setOnFocusChangeListener(this);

        enterTextCongratulation = findViewById(R.id.enter_congratulation);
        enterTextCongratulation.setOnFocusChangeListener(this);
        enterTextCongratulation.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        switch (buttonView.getId()) {

            case R.id.switch1:
                if (isChecked == true) {
                    editNumTel.setVisibility(View.VISIBLE);
                } else
                    editNumTel.setVisibility(View.INVISIBLE);
                break;

            case R.id.switch2:
                if (isChecked == true) {
                    editTextCongratulation.setVisibility(View.VISIBLE);
                } else
                    editTextCongratulation.setVisibility(View.INVISIBLE);
                break;
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

        switch (v.getId()) {

            case R.id.editName:
                if (!hasFocus) {
                    if (String.valueOf(editName.getText()).equals("")) {
                        editName.setText(R.string.edit_name);
                    }
                }
                break;

            case R.id.edit_name_celebration:
                if (!hasFocus) {
                    if (String.valueOf(editCelebration.getText()).equals("")) {
                        editCelebration.setText(R.string.edit_name_celebration);
                    }
                }
                break;

            case R.id.edit_num_tel:
                if (!hasFocus) {
                    if (String.valueOf(editNumTel.getText()).equals("")) {
                        editNumTel.setText(R.string.number_tell);
                        aSwitchSendSms.setChecked(false);
                    }
                }
                break;

            case R.id.edit_congratulation:
                if (!hasFocus) {
                    enterTextCongratulation.setText(editTextCongratulation.getText());
                }
                break;

            case R.id.enter_congratulation:
                if (!hasFocus) {
                    if (String.valueOf(enterTextCongratulation.getText()).equals("")) {
                        enterTextCongratulation.setText(R.string.enter_text_congratulation);
                    }
                }
                break;
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (!hasFocus) {

            if (String.valueOf(editName.getText()).equals("")) {
                editName.setText(R.string.edit_name);
            }
            if (String.valueOf(editCelebration.getText()).equals("")) {
                editCelebration.setText(R.string.edit_name_celebration);
            }
            if (String.valueOf(editNumTel.getText()).equals("")) {
                editNumTel.setText(R.string.number_tell);
                aSwitchSendSms.setChecked(false);
            }
            if (String.valueOf(enterTextCongratulation.getText()).equals("")) {
                enterTextCongratulation.setText(R.string.enter_text_congratulation);
            }
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {  // убрать клавиатуру после ввода

        View v = getCurrentFocus();
        boolean ret = super.dispatchTouchEvent(event);

        if (v instanceof EditText) {
            View w = getCurrentFocus();
            int scrcoords[] = new int[2];
            w.getLocationOnScreen(scrcoords);
            float x = event.getRawX() + w.getLeft() - scrcoords[0];
            float y = event.getRawY() + w.getTop() - scrcoords[1];

            if (event.getAction() == MotionEvent.ACTION_UP && (x < w.getLeft()
                    || x >= w.getRight() || y < w.getTop() || y > w.getBottom())) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
            }
        }
        return ret;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.tvDate:
                editDate.setText("");
                showDialog(DIALOG_DATE);
                break;

            case R.id.tvTime:
                editTime.setText("");
                showDialog(DIALOG_TIME);
                break;

            case R.id.editName:
                if (String.valueOf(editName.getText()).equals(getString(R.string.edit_name))) {
                    editName.setText("");
                }
                break;

            case R.id.edit_name_celebration:
                if (String.valueOf(editCelebration.getText()).equals(getString(R.string.edit_name_celebration))) {
                    editCelebration.setText("");
                }
                break;

            case R.id.edit_num_tel:
                if (String.valueOf(editNumTel.getText()).equals(getString(R.string.number_tell))) {
                    editNumTel.setText("");
                }
                break;
            case R.id.enter_congratulation:
                if (String.valueOf(enterTextCongratulation.getText()).equals(getString(R.string.enter_text_congratulation))) {
                    enterTextCongratulation.setText("");
                }
                break;
        }
    }

    protected Dialog onCreateDialog(int id) {

        switch (id) {

            case DIALOG_DATE:
                if (date == null) {
                    date = new Date();
                }
                myYear = date.getYear() + 1900;
                myMonth = date.getMonth() + 1;
                myDay = date.getDate();
                DatePickerDialog dpd = new DatePickerDialog(this,
                        myCallBack, myYear, myMonth, myDay);
                return dpd;

            case DIALOG_TIME:
                if (date == null) {
                    date = new Date();
                }
                myHour = date.getHours();
                myMinute = date.getMinutes();
                TimePickerDialog tpd = new TimePickerDialog(this,
                        myCallBack1, myHour, myMinute, true);
                return tpd;
        }
        return super.onCreateDialog(id);
    }

    TimePickerDialog.OnTimeSetListener myCallBack1 = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            myHour = hourOfDay;
            myMinute = minute;
            editTime.setText(myHour + ":" + myMinute);
        }
    };

    DatePickerDialog.OnDateSetListener myCallBack = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            myYear = year;
            myMonth = monthOfYear;
            myDay = dayOfMonth;
            editDate.setText(myDay + "-" + myMonth + "-" + myYear);
        }
    };


}

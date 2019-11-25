package com.example.meeting;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class addMeeting extends AppCompatActivity {

    Calendar calendar;
    Button date;
    Button time;
    EditText name;
    EditText address;
    EditText company;
    EditText designation;
    int timeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);

        date = findViewById(R.id.button_date);
        time = findViewById(R.id.button_time);
        name = findViewById(R.id.text_name);
        address = findViewById(R.id.text_address);
        company = findViewById(R.id.text_company);
        designation = findViewById(R.id.text_designation);

        calendar = Calendar.getInstance();
    }

    public void pickDate(View v){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this);
        datePickerDialog.show();
        datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                date.setText(
                        new SimpleDateFormat("yyyy.MM.dd").
                                format(calendar.getTimeInMillis()));
            }
        });
    }

    public void pickTime(View v){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);
                time.setText(
                        new SimpleDateFormat("hh:mm a").
                                format(calendar.getTimeInMillis()));
            }
        }, 10, 10, false);
        timePickerDialog.show();
    }
}

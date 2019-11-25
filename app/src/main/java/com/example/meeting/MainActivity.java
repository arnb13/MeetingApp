package com.example.meeting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addMeeting(View v){
        startActivity(new Intent(this, addMeeting.class));
    }

    public void showMeeting(View v){
        startActivity(new Intent(this, showMeeting.class));
    }
}

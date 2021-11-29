package com.example.aditi.TimeTableApp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView welcomeTextView1=(TextView) findViewById(R.id.WelcomeTextView1);
        welcomeTextView1.setPaintFlags(welcomeTextView1.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
    }


    public void onClickMonday(View v){
        Intent newActivity=new Intent();
        newActivity.setClass(this,Monday.class);
        startActivity(newActivity);
    }
    public void onClickTuesday(View v){
        Intent newActivity=new Intent();
        newActivity.setClass(this,Tuesday.class);
        startActivity(newActivity);
    }
    public void onClickWednesday(View v){
        Intent newActivity=new Intent();
        newActivity.setClass(this,Wednesday.class);
        startActivity(newActivity);
    }
    public void onClickThursday(View v){
        Intent newActivity=new Intent();
        newActivity.setClass(this,Thursday.class);
        startActivity(newActivity);
    }
    public void onClickFriday(View v){
        Intent newActivity=new Intent();
        newActivity.setClass(this,Friday.class);
        startActivity(newActivity);
    }
    public void onClickSaturday(View v){
        Intent newActivity=new Intent();
        newActivity.setClass(this,Saturday.class);
        startActivity(newActivity);
    }
    public void onClickSunday(View v){
        Intent newActivity=new Intent();
        newActivity.setClass(this,Sunday.class);
        startActivity(newActivity);
    }
}
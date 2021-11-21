package com.example.aditi.TimeTableApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
}
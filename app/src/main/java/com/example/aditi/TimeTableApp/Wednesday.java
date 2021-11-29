package com.example.aditi.TimeTableApp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;

public class Wednesday extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    DataBaseWednesday myDB;
    ArrayList<String> Lec_id, sub, books;
    CustomAdapterWednesday customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wednesday);

        recyclerView = findViewById(R.id.recyclerViewWednesday);
        add_button = findViewById(R.id.Wednesday_Add);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wednesday.this, AddActivityWednesday.class);
                startActivity(intent);
            }
        });

        myDB = new DataBaseWednesday(Wednesday.this);
        Lec_id = new ArrayList<>();
        sub = new ArrayList<>();
        books = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapterWednesday(Wednesday.this,this, Lec_id, sub, books);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Wednesday.this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){

        }else{
            while (cursor.moveToNext()){
                Lec_id.add(cursor.getString(0));
                sub.add(cursor.getString(1));
                books.add(cursor.getString(2));
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.delete_all){
            confirmDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete All?");
        builder.setMessage("Are you sure you want to delete all Data?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DataBaseWednesday myDB = new DataBaseWednesday(Wednesday.this);
                myDB.deleteAllData(Wednesday.this);
                //Refresh Activity
                Intent intent = new Intent(Wednesday.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
    public void onClickWednesdayReminder(View v){
        DialogFragment timePickerDialog =new TimePickerFragment();
        timePickerDialog.show(getSupportFragmentManager(),"time picker3");
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.TUESDAY);
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Intent intent = new Intent(getApplicationContext(), WednesdayReminder.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),7*24*60*60*1000, pendingIntent);
    }
}





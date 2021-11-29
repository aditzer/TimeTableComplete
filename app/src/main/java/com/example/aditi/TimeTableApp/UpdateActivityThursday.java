package com.example.aditi.TimeTableApp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivityThursday extends AppCompatActivity {

    EditText Monday_Edit_Subject, Monday_Edit_Book;
    Button update_button;
    String lec_no, subject, book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_thursday);

        Monday_Edit_Subject= findViewById(R.id.Sunday_Edit_Subject);
        Monday_Edit_Book = findViewById(R.id.Sunday_Edit_Book);
        update_button = findViewById(R.id.update_button_Sunday);

        getAndSetIntentData();


        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(subject);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseThursday myDB = new DataBaseThursday(UpdateActivityThursday.this);
                subject = Monday_Edit_Subject.getText().toString().trim();
                book = Monday_Edit_Book.getText().toString().trim();
                myDB.updateData(lec_no, subject, book);
            }
        });


    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("title") &&
                getIntent().hasExtra("author")){

            lec_no = getIntent().getStringExtra("id");
            subject = getIntent().getStringExtra("title");
            book = getIntent().getStringExtra("author");

            //Setting Intent Data
            Monday_Edit_Subject.setText(subject);
            Monday_Edit_Book.setText(book);
        }
        else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }
}



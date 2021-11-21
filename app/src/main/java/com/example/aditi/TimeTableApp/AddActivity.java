package com.example.aditi.TimeTableApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText Monday_Subject_Name, Monday_Book_Name;
    Button Monday_Add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Monday_Subject_Name = findViewById(R.id.Monday_Subject_Name);
        Monday_Book_Name = findViewById(R.id.Monday_Book_Name);
        Monday_Add = findViewById(R.id.Monday_Add);
        Monday_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addBook(Monday_Subject_Name.getText().toString().trim(),
                        Monday_Book_Name.getText().toString().trim());

            }
        });
    }
}

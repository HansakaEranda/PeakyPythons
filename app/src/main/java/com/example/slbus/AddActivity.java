package com.example.slbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    EditText busid_input, stime_input, etime_input;
    Button add_button, button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        busid_input = findViewById(R.id.busid_input);
        stime_input = findViewById(R.id.stime_input);
        etime_input = findViewById(R.id.etime_input);
        add_button = findViewById(R.id.add_button);
        button = findViewById(R.id.button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addRecord(busid_input.getText().toString().trim(),
                        stime_input.getText().toString().trim(),
                        etime_input.getText().toString().trim());
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(AddActivity.this, Bookings.class);
                startActivity(intent);
            }
        });
    }
}
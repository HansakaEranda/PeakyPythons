package com.example.slbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    EditText busid_input, stime_input, etime_input;
    Button add_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        busid_input = findViewById(R.id.busid_input);
        stime_input = findViewById(R.id.stime_input);
        etime_input = findViewById(R.id.etime_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addRecord(busid_input.getText().toString().trim(),
                        stime_input.getText().toString().trim(),
                        etime_input.getText().toString().trim());
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menubook){
            Intent intent= new Intent(AddActivity.this, Bookings.class);
            startActivity(intent);
        }else if(item.getItemId() == R.id.menutimetable){
            Intent intent= new Intent(AddActivity.this, AddActivity.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}
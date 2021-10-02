package com.example.slbus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddBooking extends AppCompatActivity {

    EditText et_from, et_to, et_date, et_time, et_bid, et_pname, et_seat, et_phone;
    Button btnbkadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_booking);

        et_from= findViewById(R.id.et_from);
        et_to= findViewById(R.id.et_to);
        et_date= findViewById(R.id.et_date);
        et_time= findViewById(R.id.et_time);
        et_bid= findViewById(R.id.et_bid);
        et_pname= findViewById(R.id.et_pname);
        et_seat= findViewById(R.id.et_seat);
        et_phone= findViewById(R.id.et_phone);
        btnbkadd= findViewById(R.id.btnbkadd);
        btnbkadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddBooking.this);
                myDB.addBooking(et_from.getText().toString().trim(),
                        et_to.getText().toString().trim(),
                        et_date.getText().toString().trim(),
                        et_time.getText().toString().trim(),
                        et_bid.getText().toString().trim(),
                        et_pname.getText().toString().trim(),
                        Integer.valueOf(et_seat.getText().toString().trim()),
                        Integer.valueOf(et_phone.getText().toString().trim()));
            }
        });

    }
}
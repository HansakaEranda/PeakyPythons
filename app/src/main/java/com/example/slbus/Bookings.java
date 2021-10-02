package com.example.slbus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Bookings extends AppCompatActivity {

    RecyclerView bkrview;
    FloatingActionButton addbk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);

        bkrview = findViewById(R.id.bkrview);
        addbk = findViewById(R.id.addbk);
        addbk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Bookings.this, AddBooking.class);
                startActivity(intent1);
            }
        });
    }
}
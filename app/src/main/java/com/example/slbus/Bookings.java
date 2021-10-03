package com.example.slbus;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Bookings extends AppCompatActivity {

    RecyclerView bkrview;
    FloatingActionButton addbk;

    MyDatabaseHelper1 myDB;
    ArrayList<String> id, from, to, date, time, busID, pname, seatno, phone;
    CustomAdapterK customAdapterK;

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

        myDB = new MyDatabaseHelper1(Bookings.this);
        id = new ArrayList<>();
        from = new ArrayList<>();
        to = new ArrayList<>();
        date = new ArrayList<>();
        time = new ArrayList<>();
        busID = new ArrayList<>();
        pname = new ArrayList<>();
        seatno = new ArrayList<>();
        phone = new ArrayList<>();

        StoreBookings();

        customAdapterK = new CustomAdapterK(Bookings.this,this ,id, from, to, date, time, busID, pname, seatno, phone);
        bkrview.setAdapter(customAdapterK);
        bkrview.setLayoutManager(new LinearLayoutManager(Bookings.this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void StoreBookings() {
        Cursor cursor = myDB.readalldata();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                id.add(cursor.getString(0));
                from.add(cursor.getString(1));
                to.add(cursor.getString(2));
                date.add(cursor.getString(3));
                time.add(cursor.getString(4));
                busID.add(cursor.getString(5));
                pname.add(cursor.getString(6));
                seatno.add(cursor.getString(7));
                phone.add(cursor.getString(8));
            }
        }
    }
}
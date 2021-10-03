package com.example.slbus;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BookingDetails extends AppCompatActivity {

    TextView tv_id, tv_from, tv_to, tv_date, tv_time, tv_busid, tv_seatno;
    Button btndelete;
    String id, from, to, date, time, busid, seatno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);

        tv_id = findViewById(R.id.tv_id);
        tv_from = findViewById(R.id.tv_from);
        tv_to = findViewById(R.id.tv_to);
        tv_date = findViewById(R.id.tv_date);
        tv_time = findViewById(R.id.tv_time);
        tv_busid = findViewById(R.id.tv_busid);
        tv_seatno = findViewById(R.id.tv_seatno);
        btndelete = findViewById(R.id.btndelete);

        getnsetIntentdata();

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmdialog();
            }
        });

    }

    void getnsetIntentdata(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("from") && getIntent().hasExtra("to") && getIntent().hasExtra("date") &&
                getIntent().hasExtra("time") && getIntent().hasExtra("busid") && getIntent().hasExtra("seatno")){
            id = getIntent().getStringExtra("id");
            from = getIntent().getStringExtra("from");
            to = getIntent().getStringExtra("to");
            date = getIntent().getStringExtra("date");
            time = getIntent().getStringExtra("time");
            busid = getIntent().getStringExtra("busid");
            seatno = getIntent().getStringExtra("seatno");

            tv_id.setText(id);
            tv_from.setText(from);
            tv_to.setText(to);
            tv_date.setText(date);
            tv_time.setText(time);
            tv_busid.setText(busid);
            tv_seatno.setText(seatno);

        }else{
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
    void confirmdialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete Booking No. : " + id + " ?");
        builder.setMessage("Are you sure you want to delete booking no. " + id + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper1 myDB = new MyDatabaseHelper1(BookingDetails.this);
                myDB.deleteonerow(id);
                Intent intent= new Intent(BookingDetails.this, Bookings.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
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
            Intent intent= new Intent(BookingDetails.this, Bookings.class);
            startActivity(intent);
        }else if(item.getItemId() == R.id.menutimetable){
            Intent intent= new Intent(BookingDetails.this, AddActivity.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}
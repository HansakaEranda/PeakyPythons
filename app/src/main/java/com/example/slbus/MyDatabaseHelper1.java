package com.example.slbus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper1 extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "bookings.db";
    private static final int DATABASE_VERSION = 1;

    private static final String table_name = "my_bookings";
    private static final String column_id = "_id";
    private static final String column_from = "_from";
    private static final String column_to = "_to";
    private static final String column_date = "_date";
    private static final String column_start_time= "start_time";
    private static final String column_bus_id = "bus_id";
    private static final String column_pname = "passenger_name";
    private static final String column_seat_no = "seat_no";
    private static final String column_number = "_telephone";

    public MyDatabaseHelper1(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Query = "CREATE TABLE " + table_name +
                " (" + column_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                column_from + " TEXT, " +
                column_to + " TEXT, " +
                column_date + " TEXT, " +
                column_start_time + " TEXT, " +
                column_bus_id + " TEXT, " +
                column_pname + " TEXT, " +
                column_seat_no + " INTEGER, " +
                column_number + " INTEGER);";
        sqLiteDatabase.execSQL(Query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + table_name);
        onCreate(sqLiteDatabase);

    }
    void addBooking(String from, String to, String date, String time, String busID, String pname, int seatno, int phone){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(column_from, from);
        cv.put(column_to, to);
        cv.put(column_date, date);
        cv.put(column_start_time, time);
        cv.put(column_bus_id, busID);
        cv.put(column_pname, pname);
        cv.put(column_seat_no, seatno);
        cv.put(column_number, phone);
        long result = db.insert(table_name,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readalldata(){
        String query = "SELECT * FROM " + table_name;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor crsr = null;
        if(db != null){
            crsr = db.rawQuery(query, null);
        }
        return crsr;
    }

}

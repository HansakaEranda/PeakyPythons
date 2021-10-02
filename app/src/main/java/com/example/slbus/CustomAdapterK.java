package com.example.slbus;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterK extends RecyclerView.Adapter<CustomAdapterK.MyViewholder> {

    private Context context;
    private ArrayList id, from, to, date, time, busID, pname, seatno, phone;
    CustomAdapter(Context context, ArrayList id, ArrayList from, ArrayList to, ArrayList date, ArrayList time, ArrayList busID, ArrayList pname, ArrayList seatno, ArrayList phone) {
        this.context = context;
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
        this.time = time;
        this.busID = busID;
        this.pname = pname;
        this.seatno = seatno;


    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

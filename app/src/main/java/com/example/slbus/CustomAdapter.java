package com.example.slbus;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList bus_id, bus_busid, bus_stime, bus_etime;

    CustomAdapter(Activity activity, Context context, ArrayList bus_id, ArrayList bus_busid, ArrayList bus_stime,
                  ArrayList bus_etime){
        this.activity = activity;
        this.context = context;
        this.bus_id = bus_id;
        this.bus_busid = bus_busid;
        this.bus_stime = bus_stime;
        this.bus_etime = bus_etime;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.id_txt.setText(String.valueOf(bus_id.get(position)));
        holder.busid_txt.setText(String.valueOf(bus_busid.get(position)));
        holder.stime_txt.setText(String.valueOf(bus_stime.get(position)));
        holder.etime_txt.setText(String.valueOf(bus_etime.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(bus_id.get(position)));
                intent.putExtra("busid", String.valueOf(bus_busid.get(position)));
                intent.putExtra("stime", String.valueOf(bus_stime.get(position)));
                intent.putExtra("etime", String.valueOf(bus_etime.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return bus_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id_txt,busid_txt, stime_txt, etime_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id_txt = itemView.findViewById(R.id.id_txt);
            busid_txt = itemView.findViewById(R.id.busid_txt);
            stime_txt = itemView.findViewById(R.id.stime_txt);
            etime_txt = itemView.findViewById(R.id.etime_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}

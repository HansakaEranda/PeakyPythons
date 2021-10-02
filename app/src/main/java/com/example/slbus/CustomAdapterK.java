package com.example.slbus;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterK extends RecyclerView.Adapter<CustomAdapterK.MyViewholder> {

    private Context context;
    //private Activity activity;
    private ArrayList id, from, to, date, time, busID, pname, seatno, phone;

    CustomAdapterK(Context context, ArrayList id, ArrayList from, ArrayList to, ArrayList date, ArrayList time, ArrayList busID, ArrayList pname, ArrayList seatno, ArrayList phone) {
        //this.activity = activity;
        this.context = context;
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
        this.time = time;
        this.busID = busID;
        this.pname = pname;
        this.seatno = seatno;
        this.phone = phone;


    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_booking, parent, false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        holder.txtid.setText(String.valueOf(id.get(position)));
        holder.txtfrom.setText(String.valueOf(from.get(position)));
        holder.txtto.setText(String.valueOf(to.get(position)));
        holder.txtdate.setText(String.valueOf(date.get(position)));
        holder.txttime.setText(String.valueOf(time.get(position)));
        holder.txtbusid.setText(String.valueOf(busID.get(position)));
        holder.txtseatno.setText(String.valueOf(seatno.get(position)));

    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {

        TextView txtid, txtfrom, txtto, txtdate, txttime, txtbusid, txtseatno;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            txtid = itemView.findViewById(R.id.txtid);
            txtfrom = itemView.findViewById(R.id.txtfrom);
            txtto = itemView.findViewById(R.id.txtto);
            txtdate = itemView.findViewById(R.id.txtdate);
            txttime = itemView.findViewById(R.id.txttime);
            txtbusid = itemView.findViewById(R.id.txtbusid);
            txtseatno = itemView.findViewById(R.id.txtseatno);
        }
    }
}

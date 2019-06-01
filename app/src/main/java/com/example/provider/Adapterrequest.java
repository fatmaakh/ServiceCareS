package com.example.provider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class Adapterrequest extends ArrayAdapter<request> {
    Context context;
    ArrayList < request > mCategoryList;

    public Adapterrequest(Context context , ArrayList <request> mCategoryList){
        super(context,R.layout.requestlayout,mCategoryList);
        this.context = context;
        this.mCategoryList =mCategoryList;
    }

    public class Holder {
        TextView username;
        TextView date;
        TextView time;
        TextView address;
        TextView notes;
        Button button;
        Button button2;

    }

    public View getView(int position, View convertView, ViewGroup parent){
       request  data = getItem(position);

        Holder viewHolder;

        if (convertView == null){

            viewHolder = new Holder();


            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.requestlayout,parent ,false);


            viewHolder.username = (TextView) convertView.findViewById(R.id.username);
            viewHolder.date = (TextView) convertView.findViewById(R.id.date);
            viewHolder.time = (TextView) convertView.findViewById(R.id.time);
            viewHolder.address = (TextView) convertView.findViewById(R.id.address);
            viewHolder.notes = (TextView) convertView.findViewById(R.id.notes);


            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (Holder) convertView.getTag();
        }

        viewHolder.username.setText(data.getUsername());
        viewHolder.date.setText(data.getDate());
        viewHolder.time.setText(data.getTime());
        viewHolder.address.setText(data.getLatitude());
        viewHolder.notes.setText(data.getNotes());


        return convertView;
    }




}

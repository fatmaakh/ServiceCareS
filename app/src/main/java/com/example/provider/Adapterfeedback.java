package com.example.provider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class Adapterfeedback extends ArrayAdapter<feedback> {
    Context context;
    ArrayList < feedback > mCategoryList;

    public Adapterfeedback(Context context , ArrayList <feedback> mCategoryList){
        super(context,R.layout.feedbacklayout,mCategoryList);
        this.context = context;
        this.mCategoryList =mCategoryList;
    }

    public class Holder {
        TextView username;
        TextView feedback;


    }

    public View getView(int position, View convertView, ViewGroup parent){
      feedback  data = getItem(position);

        Holder viewHolder;

        if (convertView == null){

            viewHolder = new Holder();


            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.feedbacklayout,parent ,false);


            viewHolder.username = (TextView) convertView.findViewById(R.id.username);
            viewHolder.feedback = (TextView) convertView.findViewById(R.id.feedback);



            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (Holder) convertView.getTag();
        }

        viewHolder.username.setText(data.getUsername());
        viewHolder.feedback.setText(data.getFeedback());



        return convertView;
    }




}

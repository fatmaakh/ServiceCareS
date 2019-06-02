package com.example.provider;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapterrequest extends RecyclerView.Adapter<Adapterrequest.ViewHolder> implements ItemClickListner{

    Context context;
    ArrayList < request > mCategoryList;

    public Adapterrequest(Context context , ArrayList <request> mCategoryList){
        this.context = context;
        this.mCategoryList =mCategoryList;
    }

    @NonNull
    @Override
    public Adapterrequest.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View convertView = layoutInflater.inflate(R.layout.requestlayout,viewGroup ,false);
        return new ViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapterrequest.ViewHolder viewHolder, int position) {
        request data = mCategoryList.get(position);


        viewHolder.username.setText(data.getUsername());
        viewHolder.date.setText(data.getDate());
        viewHolder.time.setText(data.getTime());
        viewHolder.address.setText(data.getAddress());
        viewHolder.notes.setText(data.getNotes());

        viewHolder.setItemClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

    @Override
    public void onClick(View view, int position, boolean isLongPress) {
        Current.current_Request = mCategoryList.get(position);
        view.getContext().startActivity(new Intent(view.getContext() , MapsActivity.class));
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView username;
        TextView date;
        TextView time;
        TextView address;
        TextView notes;
        EditText editText,editText2,editText3,editText4,editText5;
        Button button;
        Button button2;

        public ItemClickListner itemClickListner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            username = (TextView) itemView.findViewById(R.id.username);
            date = (TextView) itemView.findViewById(R.id.date);
            time = (TextView) itemView.findViewById(R.id.time);
            address = (TextView) itemView.findViewById(R.id.address);
            notes = (TextView) itemView.findViewById(R.id.notes);
            editText=(EditText)itemView.findViewById(R.id.editText);
            editText2=(EditText)itemView.findViewById(R.id.editText2);
            editText3=(EditText)itemView.findViewById(R.id.editText3);
            editText4=(EditText)itemView.findViewById(R.id.editText4);
            editText5=(EditText)itemView.findViewById(R.id.editText5);
            button2=(Button) itemView.findViewById(R.id.button2);
            button=(Button) itemView.findViewById(R.id.button);

            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListner itemClickListner) {
            this.itemClickListner = itemClickListner;
        }

        @Override
        public void onClick(View v) {
            itemClickListner.onClick(v , getAdapterPosition() , false);
        }

    }
}

/*
public class Adapterrequest extends ArrayAdapter<request> implements ItemClickListner{
    Context context;
    ArrayList < request > mCategoryList;



    public Adapterrequest(Context context , ArrayList <request> mCategoryList){
        super(context,R.layout.requestlayout,mCategoryList);
        this.context = context;
        this.mCategoryList =mCategoryList;
    }

    @Override
    public void onClick(View view, int position, boolean isLongPress) {

    }

    public class Holder {
        public ItemClickListner itemClickListner;

        TextView username;
        TextView date;
        TextView time;
        TextView address;
        TextView notes;
        EditText editText,editText2,editText3,editText4,editText5;
        Button button;
        Button button2;

        public void setItemClickListener(ItemClickListner itemClickListner) {
            this.itemClickListner = itemClickListner;
        }
    }

    public View getView(int position, View convertView, ViewGroup parent){
       request  data = getItem(position);
        Current.current_Request = data;

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
        viewHolder.address.setText(data.getAddress());
        viewHolder.notes.setText(data.getNotes());

        convertView.setOnClickListener(this);
        return convertView;
    }




}
*/
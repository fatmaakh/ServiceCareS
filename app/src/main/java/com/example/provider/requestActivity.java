package com.example.provider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.sql.SQLException;
import java.util.ArrayList;

public class requestActivity extends AppCompatActivity {
   request model;
    getrequest g=new getrequest();
    Adapterrequest adapterrequest;
    ArrayList<request> data;
    RecyclerView listrequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);


        listrequest=(RecyclerView) findViewById(R.id.listrequest);
        try {
            data=new ArrayList<>(g.getdata(requestActivity.this,loginacivity.username));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        adapterrequest=new Adapterrequest(requestActivity.this,data);
        listrequest.setAdapter(adapterrequest); //hna el error
        adapterrequest.notifyDataSetChanged();

    }
}

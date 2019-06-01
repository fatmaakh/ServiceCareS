package com.example.provider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.sql.SQLException;
import java.util.ArrayList;

public class FeedbackActivity extends AppCompatActivity {

    feedback model;
    getfeedback g=new getfeedback();
    Adapterfeedback adapterfeedback;
    ArrayList<feedback> data;
    ListView listfeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        setContentView(R.layout.activity_feedback);
        listfeedback=(ListView)findViewById(R.id.listfeedback);
        try {
            data=new ArrayList<>(g.getdata(FeedbackActivity.this,loginacivity.username));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        adapterfeedback=new Adapterfeedback(FeedbackActivity.this,data);
        listfeedback.setAdapter(adapterfeedback);
        adapterfeedback.notifyDataSetChanged();

    }
}

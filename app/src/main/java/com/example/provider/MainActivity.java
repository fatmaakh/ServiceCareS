package com.example.provider;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    final static int DELAY_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    startActivity(new Intent(MainActivity.this ,loginacivity.class));

                }
            },DELAY_TIME);


    }
}

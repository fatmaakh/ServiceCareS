package com.example.provider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;

public class loginacivity extends AppCompatActivity {

    EditText email ,ppwd;
    Button btnplog;
    TextView forget;
    CheckBox chk;
    public static String  username,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginacivity);

        SharedPreferences share=getSharedPreferences("Service",MODE_PRIVATE);
        String us=share.getString("Username",null);
        if (us!=null)
        {
            username=us;
            startActivity(new Intent(loginacivity.this,providerhActivity.class));
        }

        email=(EditText)findViewById(R.id.email);
        ppwd=(EditText)findViewById(R.id.ppwd);
        chk=(CheckBox)findViewById(R.id.checkBox);
        btnplog=(Button)findViewById(R.id.btnplog);
        btnplog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(email.getText().toString().isEmpty())
                {
                    email.setError("Enter username");
                    email.requestFocus();
                }
                else {
                    if(ppwd.getText().toString().isEmpty())
                    {
                        ppwd.setError("Enter password");
                        ppwd.requestFocus();
                    }
                    else
                    {

                        Database db=new Database();
                        Connection mina=db.ConnectDB();
                        if(mina==null)
                            Toast.makeText(loginacivity.this, "Check internet access", Toast.LENGTH_SHORT).show();
                        else
                        {
                            ResultSet rs=db.RunSearch("select * from worker where Email='"+email.getText()+"' and password='"+ppwd.getText()+"'");
                            try {
                                if(rs.next())
                                {
                                    username=email.getText().toString();
                                    name=rs.getString(2);
                                    String koko=db.RUNIUD("insert into logintemp values ('"+email.getText()+"','Login')");
                                    if(chk.isChecked()) {
                                        getSharedPreferences("Service", MODE_PRIVATE)
                                                .edit()
                                                .putString("Username", email.getText().toString())
                                                .apply();
                                        startActivity(new Intent(loginacivity.this,providerhActivity.class));
                                    }
                                }
                                else
                                    Toast.makeText(loginacivity.this, "Invaild username or password", Toast.LENGTH_SHORT).show();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            } catch (java.sql.SQLException e) {
                                e.printStackTrace();
                            }


                        }




                    }
                }

            }
        });


        forget=(TextView) findViewById(R.id.forget);
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OPEN activity help
            }
        });








    }



}



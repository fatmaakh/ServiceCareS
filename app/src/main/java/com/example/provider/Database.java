package com.example.provider;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    Connection conn=null;
    public Connection ConnectDB()
    {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:jtds:sqlserver://SQL5033.site4now.net/DB_A49337_homeeservicee","DB_A49337_homeeservicee_admin","bis-2019");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    //يستخدم لللاضافة و التعديل و الحذف
    public String RUNIUD(String st)
    {
        try {
            Statement nour=conn.createStatement();
            nour.executeUpdate(st);
            return "Ok";
        } catch (SQLException aya) {
             return aya.getMessage();
        }

    }
    //to search
    public ResultSet RunSearch(String st)
    {
        ResultSet bola;
        try {
            Statement aya=conn.createStatement();
         bola= aya.executeQuery(st);
            return  bola;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}

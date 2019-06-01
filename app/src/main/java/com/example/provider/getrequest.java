package com.example.provider;

import android.content.Context;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class getrequest {

    public List<request> getdata(Context cn,String workername) throws SQLException {

        List<request> data=new ArrayList<>();

        Database hend=new Database();
        hend.ConnectDB();
        ResultSet rs=hend.RunSearch("select * from [request] where [worker name]='"+loginacivity.name+"'");

        try {
            while (rs.next())
            {
                request nourhan=new request();
                nourhan.setReqno(rs.getString(1));
                nourhan.setDate(rs.getString(2));

                nourhan.setNotes(rs.getString(3));
                nourhan.setLatitude(rs.getString(4));
                nourhan.setLongitude(rs.getString(5));
                nourhan.setWorkername(rs.getString(6));
                nourhan.setUsername(rs.getString(7));
                nourhan.setTime(rs.getString(8));

                data.add(nourhan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;


    }

}

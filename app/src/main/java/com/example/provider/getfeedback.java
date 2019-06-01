package com.example.provider;

import android.content.Context;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class getfeedback {

    public List<feedback> getdata(Context cn, String workername) throws SQLException {

        List<feedback> data=new ArrayList<>();

        Database hend=new Database();
        hend.ConnectDB();
        ResultSet rs=hend.RunSearch("select * from [feedback] where [workername]='"+loginacivity.name+"'");
        try {
            while (rs.next())
            {
                feedback nourhan=new feedback();
                nourhan.setFeedbackno(rs.getString(1));
                nourhan.setUsername(rs.getString(2));
                nourhan.setWorkername(rs.getString(3));
                nourhan.setFeedback(rs.getString(4));
                nourhan.setServicename(rs.getString(5));


                data.add(nourhan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;


    }

}


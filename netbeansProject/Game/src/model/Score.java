/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controllers.DBConnect;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author feder
 */
public class Score {
    private int id;
    private int score;
    private int time;
    private Date date;
    
    public Score() throws SQLException{
    DBConnect con = new DBConnect();
    
    int i=con.getScoreId();
    i++;
    id=i;
    
    }
    
    public void setDate(Date d){date=d;}
    public void setScore(int s){score=s;}
    public void setTime(int t ){time=t;}
    public int getId(){return id;}
}

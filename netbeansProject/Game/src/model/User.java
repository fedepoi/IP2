/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controllers.DBConnect;
import java.sql.SQLException;

/**
 *
 * @author feder
 */
public class User {
    private int id;
    private String fName;
    private String lName;
    private String email;
    private String password;
    private boolean admin;
    private DBConnect connection;
    
    //prova
    public User(){}
    
    public User (int id ,String fName,String sName,String email,String password,boolean admin)
    {
    this.id=id;
    this.fName=fName;
    this.lName=sName;
    this.email=email;
    this.password=password;
    this.admin=admin;   
    }
    
    public int getId(){return id;}
    public boolean getAdmin(){return this.admin;}
    
    public void setId(int id){this.id=id;}
    public void setName(String name){this.fName=name;}
    public void setLName(String lName){this.lName=lName;}
    public void setMail(String mail){this.email=mail;}
    public void setPass(String pass){this.password=pass;}
    public void setAdmin(boolean admin){this.admin=admin;}
    
    
    
    
    
    public void startQuiz(String cat) throws SQLException{
    connection=new DBConnect();
    
    }
    
    
    @Override
    public String toString()
    {
        String o = Integer.toString(id)+fName+lName+email+password+admin;
        
    return o;
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

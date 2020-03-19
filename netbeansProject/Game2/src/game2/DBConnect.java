/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import Model.User;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author feder
 */
public class DBConnect {
    private Connection conn;
    private Statement st;
    private ResultSet rs;
    
    
    public DBConnect () throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ip2d","root","");
            st= conn.createStatement();
            
            
        } catch (ClassNotFoundException ex) {
           System.out.println("error"+ex);
        }
            
            }
    
    public void registerSQL(String name , String sur,String mail,String pass) {
    
        String query = "insert into usertable (`firstname`,`lastname`,`email`,`password`) values ('"+name+"',"+"'"+sur+"',"+"'"+mail+"',"+"'"+pass+"')";
        try {
            st.executeUpdate(query);
     } catch (SQLException ex) {
           System.out.println(  "error"+ex);
        }
        
    
    }
    
    public User signInSQL(String mail,String password) throws SQLException{
    String query ="select * FROM usertable where email='"+mail+"'"+" and password ='"+password+"';";
        try {
            rs=st.executeQuery(query);
            System.out.println("retrievin category data from database...");
            while (rs.next()) {
            int id = rs.getInt("userId");
            String name=rs.getString("firstName");
            String surname=rs.getString("lastName");
            String resultMail= rs.getString("email");
            String resultPassword = rs.getString("password");
            boolean admin=rs.getBoolean("admin");
            User user = new User(id, name, surname, resultMail, resultPassword, admin);
            System.out.println(resultMail+resultPassword+"..............."+user.toString());
            }            
        } 
        catch (SQLException ex) {
           System.out.println("error :"+ex);
        }
        return null;
        }
    
    
    
}

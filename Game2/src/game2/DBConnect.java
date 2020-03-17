/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ip2final","root","");
            st= conn.createStatement();
            
            
        } catch (ClassNotFoundException ex) {
           System.out.println("error"+ex);
        }
            
            }
    
    public void getData(String name , String sur,String usern,String pass) {
    
        String query = "insert into usertable (`firstname`,`lastname`,`email`,`password`) values ('"+name+"',"+"'"+sur+"',"+"'"+usern+"',"+"'"+pass+"')";
        try {
            //rs=st.executeQuery(query);
            st.executeUpdate(query);
            //  System.out.println("retrievin category data from database...");
            //while (rs.next())
            //{
            //String id = rs.getString("categoryId");
            //String name = rs.getString("categoryName");
            //System.out.println(id+name);
            
            
            //}
        } catch (SQLException ex) {
           System.out.println(  "error"+ex);
        }
        
    
    }
    
    
    
    
}

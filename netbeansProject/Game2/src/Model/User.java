/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
    
    
    @Override
    public String toString()
    {
        String o = Integer.toString(id)+fName+lName+email+password+admin;
        
    return o;
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
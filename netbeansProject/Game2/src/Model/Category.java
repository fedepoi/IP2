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
public class Category {
private int catId;
private String catName;
 private Question ques;  
 
 public Category(int id,String name){
 this.catId=id;
 this.catName=name;
 
 }
    
 public int getId(){return this.catId;}
 public String getName(){return this.catName;}
 
 
 
 
}

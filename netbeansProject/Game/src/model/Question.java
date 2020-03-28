/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author feder
 */
public class Question {
   private int questionId;
    private String questionDesc;
    private ArrayList answers;
    
    
    public Question(int questionId,String desc){
    this.questionId=questionId;
    this.questionDesc=desc;
    
    
    }
    
    public Question(int questionId,String desc, ArrayList answers){
    this.questionId=questionId;
    this.questionDesc=desc;
    this.answers=answers;
    
    
    }
    
    public ArrayList<Answer> getAnswers(){
    
    return this.answers;
    }
    
    
    
    
    
    
    
    public String getDesc(){
        return questionDesc;}
    
    public int getId(){
        return this.questionId;}
    
    public void setId(int id){
        this.questionId=id;}
    public void setDesc(String desc){this.questionDesc=desc;}
    
    
}

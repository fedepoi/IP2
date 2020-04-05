/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author feder
 */
public class Answer {
    private int answerId;
    private String desc;
    private boolean correct;
    
    
    public Answer (){}
    
    public Answer (int id,String desc,boolean correct){
    this.answerId=id;
    this.desc=desc;
    this.correct=correct;   
    }
    
    public String getDesc(){return this.desc;}
    public int getId(){return this.answerId;}
    public boolean getCorrect(){return this.correct;}
    
    
    
    
    
    @Override
    public String toString(){     
    return answerId+" : "+desc+" - "+correct;
    }
    
   
    
    
    
}

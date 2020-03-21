/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author feder
 */
public class Question {
   private int questionId;
    private String questionDesc;
    private ArrayList answer;
    
    
    public Question(int questionId,String desc){
    this.questionId=questionId;
    this.questionDesc=desc;
    
    }
    
    
    
    
    public String getDesc()
    {
    return questionDesc;
    
    }
    
    public int getId(){return this.questionId;}
    
    
}

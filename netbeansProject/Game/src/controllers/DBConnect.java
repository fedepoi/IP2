/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import model.Answer;
import model.Category;
import model.Question;
import model.User;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TimeZone;
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
    User user;
    
    private Question randQuest;
    private ArrayList<Answer> answers;
    private Category cat;
    private int scoreId;
            
            
    
    public DBConnect () throws SQLException {
        try {
                        
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ip2final?useJDBCCompliantTimezoneShift=true;useLegacyDatetimeCode=false;serverTimezone=UTC;","root","");
            st= conn.createStatement();
            
            
            
        } catch (ClassNotFoundException ex) {
           System.out.println("error"+ex);
        }
            
            }
    
    public Connection getCon() {
    return this.conn;    
    }
    
    public Statement getSt() {
    return this.st;    
    }
    
    public ResultSet getrs() {
    return this.rs;    
    }
    
    
    
    public void registerSQL(String name , String sur,String mail,String pass,int admin) {
    
        String query = "insert into usertable (`firstname`,`lastname`,`email`,`password`,`admin` ) values ('"+name+"',"+"'"+sur+"',"+"'"+mail+"',"+"'"+pass+"',"+"'"+admin+"')";
        try {
            st.executeUpdate(query);
     } catch (SQLException ex) {
           System.out.println(  "error"+ex);
        }
        
    
    }
    
    public User signInSQL(String mail,String password) throws SQLException{
        
    String query ="select * FROM usertable where email='"+mail+"'"+" and password ='"+password+"';";
    rs=st.executeQuery(query);
    System.out.println("retrievin category data from database...");
     while (rs.next()) {
      int id = rs.getInt("userId");
            String name=rs.getString("firstName");
            String surname=rs.getString("lastName");
            String resultMail= rs.getString("email");
            String resultPassword = rs.getString("password");
            boolean admin=rs.getBoolean("admin");
            this.user = new User(id, name, surname, resultMail, resultPassword, admin);
            System.out.println(resultMail+resultPassword+"..............."+user.toString());
     }
    return this.user;
        }
    
    
    public Question getRandomQuestion(int cat) throws SQLException
    {
        String query ="SELECT * FROM questions\n" +
"where categoryId="+cat+"\n" +
"ORDER BY RAND()\n" +
"LIMIT 1";

        String q2="SELECT questions.questionDesc,"
                + " answers.answerdesc,answers.answerId,answers.correct"
                + " from questions "
                + "inner JOIN answers on questions.questionId=answers.questionId "
                + "where questions.questionId=1 "
                + "order by rand() ";
        
        
        rs=st.executeQuery(query);
        
        while(rs.next()){
            int id=rs.getInt("questionId");
            String desc= rs.getString("questionDesc");
           this.randQuest=new Question(id, desc);
         
        }
    return randQuest;
    
    }
    
    
    public ArrayList<Answer> getRelatedAnswer(int questId) throws SQLException
    {
        answers=new ArrayList<>();
    String query="SELECT answers.answerdesc,answers.answerId,answers.correct\n" +
"                from questions \n" +
"                inner JOIN answers on questions.questionId=answers.questionId\n" +
"                where questions.questionId="+questId+" order by rand()";
  
    rs=st.executeQuery(query);
    while (rs.next()){
         
         String answerD=rs.getString("answerdesc");
         int answerId=rs.getInt("answerId");
         boolean correct = rs.getBoolean("correct");
         Answer a = new Answer(answerId, answerD, correct);
         answers.add(a);
         //System.out.println(a.toString()+":prova:");
         
    }
    
    //System.out.println("++++++++++++"+answers.toString());
    
    return answers;
    }
    
    
    
    
    
    
    
     public Category getCategorySQL(int idc) throws SQLException{
         
        String query ="select * from category where id="+idc;
        rs=st.executeQuery(query);
        while (rs.next())
        {
            int id =rs.getInt("categoryId");
            String catName= rs.getString("categoryName");
            cat=new Category(id, catName);
            
        }
        return cat;
    }
     
     public int getScoreId() throws SQLException{
     
      String query ="select count(scoreId) as score from scores";
        rs=st.executeQuery(query);
        while (rs.next())
        {
            scoreId =rs.getInt("score");
           
            
        }
     
     return scoreId;
     
     }
     
     public void addScore(int score,String date,int sec){
      String query = "insert into scores (score, scoreDate, seconds) values ('"+ score +"','"+ date +"','"+sec+"')";
        try {
            st.executeUpdate(query);
     } catch (SQLException ex) {
           System.out.println(  "error"+ex);
        }
     
     
     
     }
     
     
     public void addQuiz(int catID,int userId,int scoreId){
         System.out.println("adding quiz");
     String query = "insert into userquiz (categoryId , scoreId , userId) values ('"+catID+"','"+scoreId+"','"+userId+"');";
        try {
            st.executeUpdate(query);
     } catch (SQLException ex) {
           System.out.println(  "error"+ex);
        }
     
     
     }
     
     
     public void getScore() throws SQLException{
    
      String query ="SELECT scores.score,scores.seconds, userquiz.userId FROM scores\n" +
      "inner JOIN userquiz on userquiz.scoreId=scores.scoreId";
      
        rs=st.executeQuery(query);
        while (rs.next())
        {
            int score =rs.getInt("score");
            int seconds=rs.getInt("seconds");
            
            
           
            
            
        }
     
     
     
     
     }
    
    
    
    
    
    
    
}

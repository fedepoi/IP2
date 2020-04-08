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
    private ArrayList personalReport;
    private ArrayList worldReport;
    private ArrayList questionByCat;
    private ArrayList allCat;
            
            
    
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
    
    
    
    public int registerSQL(String name , String sur,String mail,String pass,int admin) throws SQLException {
    int lastId;
        String query = "insert into usertable (`firstname`,`lastname`,`email`,`password`,`admin` ) values ('"+name+"',"+"'"+sur+"',"+"'"+mail+"',"+"'"+pass+"',"+"'"+admin+"')";
       
            st.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
             rs=st.getGeneratedKeys();
    
             if(rs != null && rs.next()){
                System.out.println("Generated questionId is:"+rs.getInt(1));
                
            }
             lastId=rs.getInt(1);
            
    return lastId;
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
     
     public void addScore(int score,String date,int sec,int rat){
      String query = "insert into scores (score, scoreDate, seconds, rating) values ('"+ score +"','"+ date +"','"+sec+"','"+rat+"')";
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
     
     
     public String getScore(int userId, int cat) throws SQLException{
      personalReport = new ArrayList();
      String query;
      if (cat>0){
      query = "SELECT scores.score,scores.seconds,scores.scoreDate, userquiz.userId FROM scores\n" +
      "inner JOIN userquiz on userquiz.scoreId=scores.scoreId where userquiz.userId="+userId+ " AND userquiz.categoryId="+cat;
      }
      else query = "SELECT scores.score,scores.seconds,scores.scoreDate, userquiz.userId FROM scores\n" +
      "inner JOIN userquiz on userquiz.scoreId=scores.scoreId where userquiz.userId="+userId;
      
        rs=st.executeQuery(query);
        while (rs.next())
        {
            int score =rs.getInt("score");
            int seconds=rs.getInt("seconds");
            String date=rs.getString("scoreDate"); 
            String report ="Your score was: "+score + " on date: "+date+ " - "+seconds+"s";
            personalReport.add(report);
            System.out.println(rs.getRow());
            System.out.println(personalReport);
            
        }
        
        StringBuilder sb = new StringBuilder();
        for (Object s : personalReport){
             sb.append(s);
             sb.append("\n");
       }
       System.out.println(sb.toString());
     return sb.toString();
     }
     
      public String getWorldScore(int cat) throws SQLException{
      worldReport = new ArrayList();
      String query;
      if (cat>0){
      query ="SELECT usertable.email, scores.score,scores.seconds,scores.scoreDate, userquiz.userId FROM scores\n" +
                    "inner JOIN userquiz on userquiz.scoreId=scores.scoreId \n" +
                    "inner JOIN usertable on userquiz.userId=usertable.userId where userquiz.categoryId="+cat;
      }
      else query ="SELECT usertable.email, scores.score,scores.seconds,scores.scoreDate, userquiz.userId FROM scores\n" +
                    "inner JOIN userquiz on userquiz.scoreId=scores.scoreId \n" +
                    "inner JOIN usertable on userquiz.userId=usertable.userId";
              
              
              
              
              
        rs=st.executeQuery(query);
        while (rs.next())
        {
            int score =rs.getInt("score");
            int seconds=rs.getInt("seconds");
            String date=rs.getString("scoreDate"); 
            String mail=rs.getString("email");
            String report ="ID : "+ mail + " your score was: "+score + " on date: "+date+ " - "+seconds+"s";
            worldReport.add(report);
            System.out.println(rs.getRow());
            System.out.println(worldReport);
            
        }
        
        StringBuilder sb = new StringBuilder();
        for (Object s : worldReport){
             sb.append(s);
             sb.append("\n");
       }
       System.out.println(sb.toString());
     return sb.toString();
     }
      
      public void updateUser(User u,String fName,String lName,String mail,String pass,int admin){
        String query = "UPDATE usertable \n"
                +"SET firstname='"+fName+"',"
                +"lastname='"+lName+"',"
                +"email='"+mail+"',"
                +"password='"+pass+"',"
                +"admin='"+admin+"' WHERE userId="+u.getId();
          
        String query1="update usertable set firstname='federico',lastname='vivaldo',email='fviv@cal.com',password='pass1',admin=1 where userId=";
        
        
        System.out.println("thi is the updated user:->"+fName+lName+mail+pass+admin + "--"+u.getId());
        
        try {
            st.executeUpdate(query);
     } catch (SQLException ex) {
           System.out.println(  "error:\n"+ex);
        }  
        
       
      }
     
     
     public ArrayList getQuestionByCat(int cat) throws SQLException{
     
     questionByCat=new ArrayList();
     String query="SELECT questionId, questionDesc FROM `questions` where categoryId="+cat;
     
      rs=st.executeQuery(query);
        
        while(rs.next()){
            int id=rs.getInt("questionId");
            String desc= rs.getString("questionDesc");
            Question q = new Question(id, desc);
            
            
            questionByCat.add(q);
        }
     //System.out.print(questionByCat);
     return questionByCat;
     }
     
      public ArrayList getCategories() throws SQLException{
     
     allCat=new ArrayList();
     String query="SELECT categoryId, categoryName FROM `category`";
     
      rs=st.executeQuery(query);
        
        while(rs.next()){
            int id=rs.getInt("categoryId");
            String desc= rs.getString("categoryName");
            Category cat = new Category(id, desc);
            
            
            allCat.add(cat);
        }
     //System.out.print(questionByCat);
     return allCat;
     }
      
      public void updateCat(String catName,int id){
           String query = "UPDATE category Set categoryName='"+catName+"' where categoryId="+id;
        try {
            st.executeUpdate(query);
     } catch (SQLException ex) {
           System.out.println(  "error:\n"+ex);
        }  
      }
      
      public void updateQues(String quesDes,int id){
           String query = "UPDATE questions Set questionDesc='"+quesDes+"' where questionId="+id;
        try {
            st.executeUpdate(query);
     } catch (SQLException ex) {
           System.out.println(  "error:\n"+ex);
        }  
      }
      
      public void updateAnsw(String answDes,int id){
           String query = "UPDATE answers Set answerdesc='"+answDes+"' where answerId="+id;
        try {
            st.executeUpdate(query);
     } catch (SQLException ex) {
           System.out.println(  "error:\n"+ex);
        }  
      }
      
      public void deleteCat(int catId){
       String query = "DELETE FROM category where categoryId="+catId;
        try {
            st.executeUpdate(query);
     } catch (SQLException ex) {
           System.out.println(  "error:\n"+ex);
        }  
      }
      
      public void deleteQues(int quesId){
       String query = "DELETE FROM questions where questionId="+quesId;
        try {
            st.executeUpdate(query);
     } catch (SQLException ex) {
           System.out.println(  "error:\n"+ex);
        }  
      }
      
      public void deleteAnsw(int answId){
       String query = "DELETE FROM answers where answerId="+answId;
        try {
            st.executeUpdate(query);
     } catch (SQLException ex) {
           System.out.println(  "error:\n"+ex);
        }  
      }
     
     public void addCat(String newCat){
     String query = "insert into category (categoryName) values ('"+newCat+"')";
        try {
            st.executeUpdate(query);
     } catch (SQLException ex) {
           System.out.println(  "error:\n"+ex);
        }  
     
     }
     
      public int addQues(String newQues,int cat) throws SQLException{
          
          
     String query = "insert into questions (questionDesc,categoryId) values ('"+newQues+"','"+cat+"')";
     int lastId;
      
    st.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
    rs=st.getGeneratedKeys();
    //lastId=rs.getInt("questionId");
     if(rs != null && rs.next()){
                System.out.println("Generated questionId is:"+rs.getInt(1));
                
            }
        lastId=rs.getInt(1);
     return lastId;
     }
      
      public void addAnsw(String newAnsw,int ques,int correct){
     String query = "insert into answers (answerdesc,questionId,correct) values ('"+newAnsw+"','"+ques+"','"+correct+"')";
        try {
            st.executeUpdate(query);
     } catch (SQLException ex) {
           System.out.println(  "error:\n"+ex);
        }  
     
     }
     
     
    
     
    
}

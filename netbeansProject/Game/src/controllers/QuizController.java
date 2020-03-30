/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Answer;
import model.Question;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class QuizController implements Initializable {

   @FXML
    private AnchorPane AnchorQuiz;

    @FXML
    private HBox MenuBarQuiz;

    @FXML
    private Button SettingsMenu;

    @FXML
    private Button ReportsMenu;

    @FXML
    private Button LogOut;

    @FXML
    private TextArea textAreaQ;

    @FXML
    private Label questionCounter;

    @FXML
    private Button answer1;

    @FXML
    private Button answer2;

    @FXML
    private Button answer3;

    @FXML
    private Button answer4;

    @FXML
    private Button nextQuestion;

    @FXML
    private Button cancelQuestion;

    @FXML
    private Button PlayB;
    
    @FXML
    private Label numberQLab;
    
    @FXML
    private Button submitButton;

    @FXML
    private AnchorPane scorePane;

    @FXML
    private VBox scoreBox;

    @FXML
    private JFXTextField timeField;

    @FXML
    private VBox scoreSmallBox;

    @FXML
    private JFXTextField scoreField;

    @FXML
    private Button exitScoreButton;
    
    private int category;
    private int i=1;
    
    
    private Question ques;
    private Answer answ;
    private int result=0;
    
    public int getCat(){return this.category;}
    public void setCat(int c){this.category=c;}
   
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    
    
    
    @FXML
    public void goToHome(ActionEvent event) throws IOException{
    
         try {
           Parent windowHome = FXMLLoader.load(getClass().getResource("/game/home.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(windowHomeScene);
           window.show();
       } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       }   
     }
    
    
     @FXML
    public void setQuestionInBox() throws SQLException
    {
       
           DBConnect connection=new DBConnect();
           Question s=connection.getRandomQuestion(getCat());
           //System.out.println(getCat());
           System.out.println(s.toString());
           textAreaQ.setText(s.getDesc());
           connection.getRelatedAnswer(s.getId());
           //ques = new Question(getCat(), s.getDesc(),connection.getRelatedAnswer(s.getId()));
           
           s.setAnswers(connection.getRelatedAnswer(s.getId()));
           this.ques=s;
           System.out.println("----------"+s.getAnswers().toString());
        
           //answer1.setText(s.getAnswers().get(0).getDesc());
           answer1.setText(s.getAnswers().get(0).getDesc());
           answer1.setUserData(ques.getAnswers().get(0));
           
           answer2.setText(s.getAnswers().get(1).getDesc());
           answer2.setUserData(ques.getAnswers().get(1));
           
           answer3.setText(s.getAnswers().get(2).getDesc());
           answer3.setUserData(ques.getAnswers().get(2));
           
           answer4.setText(s.getAnswers().get(3).getDesc());
           answer4.setUserData(ques.getAnswers().get(3));
           
           
    
    } 
    
    
    @FXML
    public void nextQuestion() throws SQLException{
        i++;
        numberQLab.setText(Integer.toString(i));
        setQuestionInBox();        
        if (i==5){nextQuestion.setDisable(true);
        answer1.setDisable(true);
        answer2.setDisable(true);
        answer3.setDisable(true);
        answer4.setDisable(true);
        }     
        
    }
    
    
    @FXML
    public void play() throws SQLException{
        setQuestionInBox();
    
     for (Answer a : ques.getAnswers()) { 		      
          // System.out.println(a); 
           if (a.getCorrect()==true){System.out.println(a);}
      }
     
    this.PlayB.setDisable(true);
         
    }
    
    @FXML
    public void getCorrect(ActionEvent event) throws SQLException{
      
        if(event.getSource()==answer1){
        Answer a = (Answer) answer1.getUserData();
        if (a.getCorrect()){System.out.println("correct"); result++;} else System.out.println("false");
            nextQuestion();
        }        
        else  if(event.getSource()==answer2){
        Answer a = (Answer) answer2.getUserData();
        if (a.getCorrect()){System.out.println("correct");} else System.out.println("false");
           nextQuestion();       
        }
         else  if(event.getSource()==answer3){
        Answer a = (Answer) answer3.getUserData();
        if (a.getCorrect()){System.out.println("correct"); result++;} else System.out.println("false");
        nextQuestion();
         }
         else  if(event.getSource()==answer4){
        Answer a = (Answer) answer4.getUserData();
        if (a.getCorrect()){System.out.println("correct"); result++;} else System.out.println("false");
        nextQuestion();
         }
        
        System.out.println(result);
        
    }
    
     @FXML
    private void openScore(ActionEvent event) throws IOException{
         try {
             FXMLLoader loader = new FXMLLoader();
             loader.setLocation(getClass().getResource("/game/score.fxml"));
             Parent windowHome = loader.load();
             
          // Parent windowHome = FXMLLoader.load(getClass().getResource("/game/quiz.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           //windowHomeScene.setFill(Color.TRANSPARENT);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
          
          
           window.setScene(windowHomeScene);
           window.show();
          
         } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       } 
               
    
}
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXTextField;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.util.Duration;
import model.Answer;
import model.Question;
import model.Score;
import model.User;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class QuizController implements Initializable {

   @FXML
    private AnchorPane AnchorQuiz;

    @FXML
    private HBox MenuBar;

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
    private Score score;
    private User user;
    private Question ques;
    private Answer answ;
    private int result=0;
    private Date date;
    private String strDate;
    private int rating;
   
   private static final Integer STARTTIMEAnswer= 3; 
   private IntegerProperty timeSecondsAnswer = new SimpleIntegerProperty(STARTTIMEAnswer);
   private Timeline timelineAnswer;
                  
   
    
    
    public int getCat(){return this.category;}
    public void setCat(int c){this.category=c;}
    public void setUser(User u){user=u;}
   
   

    @FXML
    private Label timerLabel;
    
    private static final Integer STARTTIME = 30;
    private Timeline timeline;
    private IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        AnchorPane.setTopAnchor(MenuBar,0.0);
        AnchorPane.setLeftAnchor(MenuBar,0.0);
        AnchorPane.setRightAnchor(MenuBar,0.0);
        /**
        timerLabel.textProperty().bind(timeSeconds.asString());
        timerLabel.setTextFill(Color.RED);
        timerLabel.setStyle("-fx-font-size: 14;");
        timer.setOnAction(new EventHandler<ActionEvent>(){
            
          @Override
          public void handle(ActionEvent event) {
        
                if (timeline != null) {
                    timeline.stop();
                }
                timeSeconds.set(STARTTIME);
                timeline = new Timeline();
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(STARTTIME+1),
                        new KeyValue(timeSeconds, 0)));
                timeline.playFromStart();
          
    }    
   });
   */
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
        if (i==6){
        nextQuestion.setDisable(true);
        answer1.setDisable(true);
        answer2.setDisable(true);
        answer3.setDisable(true);
        answer4.setDisable(true);
        submitButton.setDisable(false);
        timeline.stop();
        System.out.println(timeSeconds.intValue()+" -:time now in seconds");
        }     
        
    }
    
    
    @FXML
    public void play() throws SQLException{
    System.out.println(user.toString()+"user in quiz controller ......----.....");
    date = Calendar.getInstance().getTime();  
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
    strDate = dateFormat.format(date);  
    
    
    //timare management
       timerLabel.textProperty().bind(timeSeconds.asString());
        timerLabel.setTextFill(Color.RED);
        timerLabel.setStyle("-fx-font-size: 14;");
       
                if (timeline != null) {
                    timeline.stop();
                }
                timeSeconds.set(STARTTIME);
                timeline = new Timeline();
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(STARTTIME+1),
                        new KeyValue(timeSeconds, 0)));
                timeline.playFromStart();
        
        System.out.println(strDate+"-string Date");
        score=new Score();
        score.setDate(date);
        System.out.println(date+" -date object");
        setQuestionInBox();
    
     for (Answer a : ques.getAnswers()) { 		      
          // System.out.println(a); 
           if (a.getCorrect()==true){System.out.println(a);}
      }
     
    this.PlayB.setDisable(true);
    this.submitButton.setDisable(true);
         
    }
    
    @FXML
    public void getCorrect(ActionEvent event) throws SQLException, InterruptedException{
      
        if(event.getSource()==answer1){
        Answer a = (Answer) answer1.getUserData();
        if (a.getCorrect()){
            System.out.println("correct"); result++;
            answer1.setStyle(".answer:pressed{\n" +
                             "    -fx-border-color:green;\n" +
                             "    -fx-background-color:green;\n" +
                             "}");
           PauseTransition pause = new PauseTransition(Duration.millis(200));
           pause.setOnFinished(e -> answer1.setStyle(""));
           pause.play();
           //nextQuestion();
            
        } else {System.out.println("false");
         answer1.setStyle(".answer:pressed{\n" +
                             "    -fx-border-color:red;\n" +
                             "    -fx-background-color:red;\n" +
                             "}");
           PauseTransition pause = new PauseTransition(Duration.millis(200));
           pause.setOnFinished(e -> answer1.setStyle(""));
           pause.play();
          // nextQuestion();
        }
        }        
        else  if(event.getSource()==answer2){
        Answer a = (Answer) answer2.getUserData();
        if (a.getCorrect()){System.out.println("correct");result++;
        answer2.setStyle(".answer:pressed{\n" +
                             "    -fx-border-color:green;\n" +
                             "    -fx-background-color:green;\n" +
                             "}");
           PauseTransition pause = new PauseTransition(Duration.millis(200));
           pause.setOnFinished(e -> answer2.setStyle(""));
           pause.play();
          // nextQuestion();
        } else {System.out.println("false");
        answer2.setStyle(".answer:pressed{\n" +
                             "    -fx-border-color:red;\n" +
                             "    -fx-background-color:red;\n" +
                             "}");
           PauseTransition pause = new PauseTransition(Duration.millis(200));
           pause.setOnFinished(e -> answer2.setStyle(""));
           pause.play();
           //nextQuestion();
        }       
        }
         else  if(event.getSource()==answer3){
        Answer a = (Answer) answer3.getUserData();
        if (a.getCorrect()){System.out.println("correct"); result++;
        answer3.setStyle(".answer:pressed{\n" +
                             "    -fx-border-color:green;\n" +
                             "    -fx-background-color:green;\n" +
                             "}");
           PauseTransition pause = new PauseTransition(Duration.millis(200));
           pause.setOnFinished(e -> answer3.setStyle(""));
           pause.play();
           //nextQuestion();
        } else {System.out.println("false");
         answer3.setStyle(".answer:pressed{\n" +
                             "    -fx-border-color:red;\n" +
                             "    -fx-background-color:red;\n" +
                             "}");
           PauseTransition pause = new PauseTransition(Duration.millis(200));
           pause.setOnFinished(e -> answer3.setStyle(""));
           pause.play();
       // nextQuestion();
        }
         }
         else  if(event.getSource()==answer4){
        Answer a = (Answer) answer4.getUserData();
        if (a.getCorrect()){System.out.println("correct"); result++;
        answer4.setStyle(".answer:pressed{\n" +
                             "    -fx-border-color:green;\n" +
                             "    -fx-background-color:green;\n" +
                             "}");
           PauseTransition pause = new PauseTransition(Duration.millis(200));
           pause.setOnFinished(e -> answer4.setStyle(""));
           pause.play();
           //nextQuestion();
        } else {System.out.println("false");
         answer4.setStyle(".answer:pressed{\n" +
                             "    -fx-border-color:red;\n" +
                             "    -fx-background-color:red;\n" +
                             "}");
           PauseTransition pause = new PauseTransition(Duration.millis(200));
           pause.setOnFinished(e -> answer4.setStyle(""));
           pause.play();
        //nextQuestion();
        }
         }
        
        System.out.println(result);
        nextQuestion();
        
    }
    
     @FXML
    private void openScore(ActionEvent event) throws IOException, SQLException{
         try {
           timeline.stop();
           
             FXMLLoader loader = new FXMLLoader();
             loader.setLocation(getClass().getResource("/game/score.fxml"));
             Parent windowHome = loader.load();
             
             ScoreController scoreCon = loader.getController();
             scoreCon.setUser(user);
             
          // Parent windowHome = FXMLLoader.load(getClass().getResource("/game/quiz.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           //windowHomeScene.setFill(Color.TRANSPARENT);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
          
          
           ScoreController sCon= loader.getController();
           sCon.setScore(result);
           sCon.setTime(30 - timeSeconds.intValue());
           sCon.setRating(checkRating());
           
           
           window.setScene(windowHomeScene);
           window.show();
           
           DBConnect conn = new DBConnect();
           conn.addScore(result,strDate, timeSeconds.intValue(),rating);
           
           System.out.println(getCat());
           System.out.println(user.getId());
           System.out.println(score.getId());
           conn.addQuiz(getCat(), user.getId(),score.getId());
           
          
           
          
         } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       } 
               
    
}
    public int checkRating(){
    if(30-timeSeconds.intValue()>=0 && 30-timeSeconds.intValue()<=5){
        rating=5;
    return rating;
    }
    else if(30-timeSeconds.intValue()>=6 && 30-timeSeconds.intValue()<=11){
        rating=4;
    return rating;
    } 
    else if(30-timeSeconds.intValue()>=12 && 30-timeSeconds.intValue()<=17){
        rating=3;
    return rating;
    }
    if(30-timeSeconds.intValue()>=18 && 30-timeSeconds.intValue()<=23){
        rating=2;
    return rating;
    }
    
    else
        rating=1;
        return rating;    
    
    }
    
    
    
}

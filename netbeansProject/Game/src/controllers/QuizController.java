/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.stage.Stage;
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
    
    int category;
    
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
           System.out.println(getCat());
           System.out.println(s.toString());
           textAreaQ.setText(s.getDesc());
           connection.getRelatedAnswer(s.getId());
           answer1.setText(connection.getRelatedAnswer(s.getId()).get(0).getDesc());
           answer2.setText(connection.getRelatedAnswer(s.getId()).get(1).getDesc());
           answer3.setText(connection.getRelatedAnswer(s.getId()).get(2).getDesc());
           answer4.setText(connection.getRelatedAnswer(s.getId()).get(3).getDesc());
    
    } 
    
    
    
    
    
}

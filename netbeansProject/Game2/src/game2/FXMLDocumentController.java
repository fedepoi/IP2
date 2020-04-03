/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import Model.Answer;
import Model.Question;
import Model.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXPasswordField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.util.Duration;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Rectangle;
import javax.swing.JCheckBox;


/**
 *
 * @author HP
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Parent root;
    @FXML
    private VBox movingPanel;
    @FXML
    private AnchorPane page;
    @FXML
    private Button cancelQuestion;
     @FXML
    private JFXTextField FirstNameTextReg;
    @FXML
    private JFXTextField LastNameTextReg;
    @FXML
    private JFXPasswordField EmailTextReg;
    @FXML
    private JFXPasswordField PasswordTextReg;
    @FXML
    private JFXTextField EmailTextSignIn;
    @FXML
    private JFXPasswordField PasswordTextSignIn;
    @FXML
    private CheckBox checkBoxA;    
 
    @FXML
    private TextArea textAreaQ;
    @FXML
    private Button PlayB;
    
    @FXML
    private Button answerMaths1;

    @FXML
    private Button answerMaths2;

    @FXML
    private Button answerMths3;

    @FXML
    private Button answerMths4;
    @FXML
    private Button MathsImage;

    @FXML
    private Button GeographyImage;

    @FXML
    private Button ComputerImage;
    
    @FXML
    private JFXTextField FirstNameTextSetAdmin;

    @FXML
    private JFXTextField LastNameTextSetAdmin;

    @FXML
    private JFXTextField EmailTextSetAdmin;

    @FXML
    private JFXPasswordField PasswordTextSetAdmin;
    
    @FXML
    private CheckBox becomeUserCheckBox;

    @FXML
    private Button SaveProfileButtonAdmin;
    
    @FXML
    private JFXComboBox<String> categoryComboBox;

    @FXML
    private JFXComboBox<String> questionComboBox;

    @FXML
    private JFXComboBox<String> answerComboBox;

    @FXML
    private JFXTextArea editTextField;
    
    @FXML
    private Button deleteEditAdmin;

    @FXML
    private Button saveEditAdmin;
    
    private User user;
    private int i=1;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1.2), movingPanel);
        t.setToX(395);
        t.play();
        t.setOnFinished((e) -> {
            try {
                root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
                movingPanel.getChildren().removeAll();
                movingPanel.getChildren().setAll(root);
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
       
    
    @FXML
    private void openLogin(ActionEvent event){
        TranslateTransition t = new TranslateTransition(Duration.seconds(1.2), movingPanel);
        t.setToX(page.getLayoutX());
        t.play();
        t.setOnFinished((e) -> {
            try {
                root = FXMLLoader.load(getClass().getResource("Register.fxml"));
                movingPanel.getChildren().removeAll();
                movingPanel.getChildren().setAll(root);
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
       
}
    
     @FXML
    private void openRegister(ActionEvent event){
        TranslateTransition t = new TranslateTransition(Duration.seconds(1.2), movingPanel);
        t.setToX(395);
        t.play();
        t.setOnFinished((e) -> {
            try {
                root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
                movingPanel.getChildren().removeAll();
                movingPanel.getChildren().setAll(root);
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
   @FXML
    private void openHome(ActionEvent event) throws SQLException{
         try {
           Parent windowHome = FXMLLoader.load(getClass().getResource("Home.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(windowHomeScene);
           window.show();
       } catch (IOException ex) {
           Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }    
         signIn();
         System.out.println(user.toString());
               
    }
    
   @FXML
    private void Logout(ActionEvent event){
         try {
           Parent windowHome = FXMLLoader.load(getClass().getResource("RegisterSignIn.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(windowHomeScene);
           window.show();
       } catch (IOException ex) {
           Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }    
               
    }
    
    @FXML
    private void openMaths(ActionEvent event) throws SQLException{
         try {
           Parent windowHome = FXMLLoader.load(getClass().getResource("QuizMaths.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(windowHomeScene);
           window.show();
          
           
       } catch (IOException ex) {
           Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       } 
      
    }
    
    
    @FXML
    private void openAlert(ActionEvent event){
        
        //MISSING THE CONNECTION!WHERE IS MY WINDOW TO PUT THE ALERT BOX?
        //I TRIES TO USE THE CODE FROM OPENMATHS BUT DIDNT WORK
      
         
        TilePane r = new TilePane(); 
  
        // create a alert 
        Alert a = new Alert(AlertType.NONE); 
  
        // action event 
        EventHandler<ActionEvent> e = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) 
            { 
            // set alert type
            a.setAlertType(AlertType.CONFIRMATION);
            
             a.setContentText("Do you want to exit from the quiz?");
            
            // show the dialog
            a.show();
            }
          }; 
              
            
            cancelQuestion.setOnAction(e);
            
            r.getChildren().add(cancelQuestion);      
    }
    
    @FXML
    private void openSettingsAdmin(ActionEvent event) throws SQLException{
         categoryComboBox = new JFXComboBox<>();//doesnt work!
         categoryComboBox.getItems().addAll("Maths","Geography","Computer Science");//doesnt work
        
         try {
           Parent windowHome = FXMLLoader.load(getClass().getResource("SettingsAdmin.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(windowHomeScene);
           window.show();
          
           
       } catch (IOException ex) {
           Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       } 
      
    }
    
    @FXML
    private void openSettingsUser(ActionEvent event) throws SQLException{
         
    
         try {
           Parent windowHome = FXMLLoader.load(getClass().getResource("SettingsUser.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           
           window.setScene(windowHomeScene);
           window.show();
          
           
       } catch (IOException ex) {
           Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       } 
      
    }
    
   
      
    
    
    @FXML
    public void register() throws SQLException
    {
        int a;
        if (checkBoxA.isSelected()==true)
        {
          a=1;
        } else a=0;
    DBConnect connection= new DBConnect();
    connection.registerSQL(FirstNameTextReg.getText(), LastNameTextReg.getText(), EmailTextReg.getText(), PasswordTextReg.getText(),a);
       
    }
    @FXML
    public void signIn() throws SQLException
    {
    DBConnect connection = new DBConnect();
    user=connection.signInSQL(EmailTextSignIn.getText(), PasswordTextSignIn.getText());
    }
    
    @FXML
    public void setQuestionInBox() throws SQLException
    {
        
        DBConnect connection=new DBConnect();
           Question s=connection.getRandomQuestion(3);
           System.out.println(s.toString());
           textAreaQ.setText(s.getDesc());
           connection.getRelatedAnswer(s.getId());
           answerMaths1.setText(connection.getRelatedAnswer(s.getId()).get(0).getDesc());
           answerMaths2.setText(connection.getRelatedAnswer(s.getId()).get(1).getDesc());
           answerMths3.setText(connection.getRelatedAnswer(s.getId()).get(2).getDesc());
           answerMths4.setText(connection.getRelatedAnswer(s.getId()).get(3).getDesc());
    
    } 
   
}
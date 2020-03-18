/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.layout.TilePane;


/**
 *
 * @author HP
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Parent root;
    
    @FXML
    private VBox movingPanel;
    
    @FXML
    private Button RegisterBeginning;
    @FXML
    private Button SignInBeginning;
    @FXML
    private AnchorPane page;
    @FXML
    private HBox MenuBar;
    @FXML
    private Button SettingsMenu;
    @FXML
    private Button ReportsMenu;
    @FXML
    private Button LogOut;
    @FXML
    private Button MathsImage;
    @FXML
    private Button answerMaths1;
    @FXML
    private Button answerMaths2;
    @FXML
    private Button answerMths3;
    @FXML
    private Button answerMths4;
    @FXML
    private Button nextQuestion;
    @FXML
    private Button cancelQuestion;
     @FXML
    private JFXTextField FirstNameTextReg;

    @FXML
    private JFXTextField LastNameTextReg;

    @FXML
    private JFXTextField EmailTextReg;

    @FXML
    private JFXTextField PasswordTextReg;
      @FXML
    private JFXTextField EmailTextSignIn;

    @FXML
    private JFXTextField PasswordTextSignIn;

    
    
    
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
    private void openMaths(ActionEvent event){
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
    public void register() throws SQLException
    {
    DBConnect connection= new DBConnect();
    connection.registerSQL(FirstNameTextReg.getText(), LastNameTextReg.getText(), EmailTextReg.getText(), PasswordTextReg.getText());
       
    }
    @FXML
    public void signIn() throws SQLException
    {
    DBConnect connection = new DBConnect();
    connection.signInSQL(EmailTextSignIn.getText(), PasswordTextSignIn.getText());
    
  
    
    }
    
}
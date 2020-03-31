/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.User;

/**
 * FXML Controller class
 *
 * @author VT
 */
public class HomeController implements Initializable {

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
    private Button GeographyImage;

    @FXML
    private Button ComputerImage;

    @FXML
    private Button AddCategory;
    private User user;
    public void setUser(User u){user=u;};
   
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    
  @FXML
    private void openQuiz(ActionEvent event) throws IOException{
         try {
             FXMLLoader loader = new FXMLLoader();
             loader.setLocation(getClass().getResource("/game/quiz.fxml"));
             Parent windowHome = loader.load();
             
             
             
          // Parent windowHome = FXMLLoader.load(getClass().getResource("/game/quiz.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(windowHomeScene);
           window.show();
           
           QuizController c = loader.getController();
           c.setUser(user);
           
           if (event.getSource()==MathsImage){
           c.setCat(1);}
           else if (event.getSource()==GeographyImage){c.setCat(2);}
           else if (event.getSource()==ComputerImage){c.setCat(3);}
           
       
         } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       } 
               
    
}
 
    
@FXML
    private void Logout(ActionEvent event){
         try {
           Parent windowHome = FXMLLoader.load(getClass().getResource("/game/registerSignIn.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(windowHomeScene);
           window.show();
       } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       }    
               
    }
    
      @FXML
    private void openSettingsAdmin(ActionEvent event) throws IOException{
         try {
           Parent windowHome = FXMLLoader.load(getClass().getResource("/game/settingsAdmin.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(windowHomeScene);
           window.show();
          
           
       } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       } 
      
    }
    
    @FXML
    private void openSettingsUser(ActionEvent event) throws IOException{
         
    
         try {
           Parent windowHome = FXMLLoader.load(getClass().getResource("/game/settingsUser.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           
           window.setScene(windowHomeScene);
           window.show();
          
           
       } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       } 
      
    }
    
 @FXML
    private void openReports(ActionEvent event) throws IOException{
         try {
             FXMLLoader loader = new FXMLLoader();
             loader.setLocation(getClass().getResource("/game/reports.fxml"));
             Parent windowHome = loader.load();
             
             ReportsController rController = loader.getController();
             rController.setUser(user);
             
             
             
          // Parent windowHome = FXMLLoader.load(getClass().getResource("/game/quiz.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(windowHomeScene);
           window.show();
           
       
         } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       } 
               
    
}
  
    
}

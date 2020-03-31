/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;
import model.User;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ScoreController implements Initializable {
    @FXML
    private JFXTextField scoreField;
    
    private User user;
    public void setUser(User u){user=u;}

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    public void goHome(ActionEvent event) throws IOException{
    
        try {
            FXMLLoader loader = new FXMLLoader();
             loader.setLocation(getClass().getResource("/game/home.fxml"));
             Parent windowHome = loader.load();
            
            HomeController homeC = loader.getController();
            homeC.setUser(user);
            
          // Parent windowHome = FXMLLoader.load(getClass().getResource("/game/home.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(windowHomeScene);
           window.show();
       } catch (IOException ex) {
           Logger.getLogger(controllers.ScoreController.class.getName()).log(Level.SEVERE, null, ex);
       }     
    }
    
     @FXML
    public void openRating(ActionEvent event) throws IOException{
    
        try {
           Parent windowHome = FXMLLoader.load(getClass().getResource("/game/rating.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(windowHomeScene);
           window.show();
       } catch (IOException ex) {
           Logger.getLogger(controllers.ScoreController.class.getName()).log(Level.SEVERE, null, ex);
       }     
    }
    
    public void setScore(int s){scoreField.setText(Integer.toString(s));}
    
        
}

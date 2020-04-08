/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.sun.javafx.stage.StageHelper;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AlertboxController implements Initializable {

    @FXML
    private Button yesAlert;

    @FXML
    private Button cancelAlert;
  
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void goToHome(ActionEvent event) throws IOException{
        
        cancelAlert = (Button) event.getSource();
        Stage window = (Stage) cancelAlert.getScene().getWindow();
        window.close(); 

     }
    
    
     @FXML
    public void goToSignIn(ActionEvent event) throws IOException{
        
        
        yesAlert = (Button) event.getSource();
        Stage window1 = (Stage) yesAlert.getScene().getWindow();
        window1.close(); 
        
        try{
        ObservableList<Stage> windows = StageHelper.getStages();
       for (Stage w : windows) {
       w.close();
       
       }
        }
        finally{
        
         try {
           Parent windowHome = FXMLLoader.load(getClass().getResource("/game/registerSignIn.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(windowHomeScene);
           window.show();
       } catch (IOException ex) {
           Logger.getLogger(controllers.SettingsAdminController.class.getName()).log(Level.SEVERE, null, ex);
       }   
        }       
         
}

}

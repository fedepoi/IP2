/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AlertDeleteController implements Initializable {

    
    @FXML
    private Button yesDelete;

    @FXML
    private Button cancelDelete;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void closeAlertDeleteBox (ActionEvent event) throws IOException{
    
    cancelDelete = (Button) event.getSource();
    Stage window = (Stage) cancelDelete.getScene().getWindow();
    window.close(); 
    yesDelete = (Button) event.getSource();
    window.close(); 
    }
    
  
}

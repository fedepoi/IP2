/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.User;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class EditboxController implements Initializable {

    @FXML
    private TextArea editArea;
    
     @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;
    
    
    private User user;
    public void setUser(User u){user=u;};
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
public void closeEditBox (ActionEvent event) throws IOException{
    
    cancelButton = (Button) event.getSource();
    Stage window = (Stage) cancelButton.getScene().getWindow();
    window.close(); 
    okButton = (Button) event.getSource();
    window.close();
    }
 

    
}

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ReportsController implements Initializable {

    @FXML
    private Button SettingsMenu;

    @FXML
    private Button ReportsMenu;

    @FXML
    private Button LogOut;

    @FXML
    private Label ProfileLabel;

    @FXML
    private JFXTextField date1;

    @FXML
    private JFXTextField date2;

    @FXML
    private JFXTextField date3;

    @FXML
    private JFXTextField date4;

    @FXML
    private JFXTextField date5;

    @FXML
    private JFXTextField score1;

    @FXML
    private JFXTextField score2;

    @FXML
    private JFXTextField score3;

    @FXML
    private JFXTextField score4;

    @FXML
    private JFXTextField score5;

    @FXML
    private Label ProfileLabel1;

    @FXML
    private JFXTextField dateW1;

    @FXML
    private JFXTextField dateW2;

    @FXML
    private JFXTextField dateW3;

    @FXML
    private JFXTextField dateW4;

    @FXML
    private JFXTextField dateW5;

    @FXML
    private JFXTextField scoreW1;

    @FXML
    private JFXTextField scoreW2;

    @FXML
    private JFXTextField scoreW3;

    @FXML
    private JFXTextField scoreW4;

    @FXML
    private JFXTextField scoreW5;
  
     @FXML
    private Button goToHome;
    /**
     * Initializes the controller class.
     */
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
           Logger.getLogger(controllers.ReportsController.class.getName()).log(Level.SEVERE, null, ex);
       }   
     }
}

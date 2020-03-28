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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class SettingsUserController implements Initializable {
    
    @FXML
    private AnchorPane settingsUserPane;

    @FXML
    private HBox MenuBar;

    @FXML
    private Button SettingsMenu;

    @FXML
    private Button ReportsMenu;

    @FXML
    private Button LogOut;

    @FXML
    private VBox RegisterBoxSetUser;

    @FXML
    private Label ProfileLabel;

    @FXML
    private JFXTextField FirstNameTextSetUser;

    @FXML
    private JFXTextField LastNameTextSetUser;

    @FXML
    private JFXTextField EmailTextSetUser;

    @FXML
    private JFXTextField PasswordTextSetUser;

    @FXML
    private HBox HBoxregister;

    @FXML
    private CheckBox becomeAdminCheckBox;

    @FXML
    private Button SaveProfileButtonUser;
    
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
    private void Logout(ActionEvent event){
         try {
           Parent windowHome = FXMLLoader.load(getClass().getResource("/game/registerSignIn.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(windowHomeScene);
           window.show();
       } catch (IOException ex) {
           Logger.getLogger(controllers.SettingsUserController.class.getName()).log(Level.SEVERE, null, ex);
       }    
               
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
           Logger.getLogger(controllers.SettingsUserController.class.getName()).log(Level.SEVERE, null, ex);
       }   
     }
    
}

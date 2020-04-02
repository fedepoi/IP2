/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.stage.Stage;
import model.User;

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
    private Label ProfileLabel1;
     @FXML
    private TextArea personalReportArea;
    @FXML
    private TextArea worldTReport;
    
    private User user;
    public void setUser(User u){user=u;}
    
    @FXML
    private JFXComboBox<String> selectCategoryYou;

    @FXML
    private JFXComboBox<String> selectCategoryWorld;
     @FXML
     
    private Button goToHome;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        selectCategoryYou.getItems().add("Maths");
        selectCategoryYou.getItems().add("Geography");
        selectCategoryYou.getItems().add("Computer Science");
        selectCategoryYou.getItems().add("All");
        selectCategoryWorld.getItems().add("Maths");  
        selectCategoryWorld.getItems().add("Geography"); 
        selectCategoryWorld.getItems().add("Computer Science");  
        selectCategoryWorld.getItems().add("All");  
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
    
    public void setScoresInArea(User u) throws SQLException{
        DBConnect conn = new DBConnect();
        String report = conn.getScore(u.getId());
        personalReportArea.setText(report);
        
        String worldReport = conn.getWorldScore();
        worldTReport.setText(worldReport);
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
}

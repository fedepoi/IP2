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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Category;
import model.User;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddQuestionController implements Initializable {
    
    @FXML
    private HBox MenuBar;

    @FXML
    private Button SettingsMenu;

    @FXML
    private Button ReportsMenu;

    @FXML
    private Button LogOut;

    @FXML
    private JFXComboBox<Category> selectCategory;

    @FXML
    private JFXTextField addQuestionField;

    @FXML
    private JFXTextField addAnswerField1;

    @FXML
    private JFXTextField addAnswerField2;

    @FXML
    private JFXTextField addAnswerField3;

    @FXML
    private JFXTextField addAnswerField4;

    @FXML
    private CheckBox checkBox1;

    @FXML
    private CheckBox checkBox3;

    @FXML
    private CheckBox checkBox2;

    @FXML
    private CheckBox checkBox4;

    @FXML
    private Button saveButton;

    @FXML
    private Button goToHome;
    
    private User user;
    public void setUser(User u){user=u;};


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        AnchorPane.setTopAnchor(MenuBar,0.0);
        AnchorPane.setLeftAnchor(MenuBar,0.0);
        AnchorPane.setRightAnchor(MenuBar,0.0);
    }    
    
    
     @FXML
    public void goToHome(ActionEvent event) throws IOException{
    
         try {
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/game/home.fxml"));
           Parent windowHome = loader.load();
          // Parent windowHome = FXMLLoader.load(getClass().getResource("/game/home.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(windowHomeScene);
           window.show();
           HomeController h = loader.getController();
           h.setUser(user);
       } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       }   
     }
    
}

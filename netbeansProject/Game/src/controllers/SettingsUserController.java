/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import model.User;
import com.jfoenix.controls.JFXPasswordField;
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
    private JFXPasswordField PasswordTextSetUser;

    @FXML
    private HBox HBoxregister;

    @FXML
    private CheckBox becomeAdminCheckBox;

    @FXML
    private Button SaveProfileButtonUser;
    
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
           Logger.getLogger(controllers.SettingsUserController.class.getName()).log(Level.SEVERE, null, ex);
       }   
     }
    
    @FXML
    public void updateDetails(ActionEvent event) throws SQLException, IOException{
         int a;
        if (becomeAdminCheckBox.isSelected()==true)
        {
          a=1;
        } else a=0;
    System.out.print(user);
    DBConnect conn = new DBConnect();
    conn.updateUser(user, FirstNameTextSetUser.getText(), LastNameTextSetUser.getText(), EmailTextSetUser.getText(), PasswordTextSetUser.getText(),a);
    user.setName(FirstNameTextSetUser.getText());
    user.setLName(LastNameTextSetUser.getText());
    user.setMail(EmailTextSetUser.getText());
    user.setPass(PasswordTextSetUser.getText());
    user.setAdmin(becomeAdminCheckBox.isSelected());   
    goToHome(event);
    }
    
}

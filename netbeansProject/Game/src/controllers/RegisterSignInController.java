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
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
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
import javafx.util.Duration;
import model.User;

/**
 *
 * @author VT
 */
public class RegisterSignInController implements Initializable {
    
    @FXML
    private Parent root;
    
    @FXML
    private VBox movingPanel;
    
    @FXML
    private AnchorPane page;
    
    @FXML
    private Button RegisterBeginning;

    @FXML
    private Button SignInBeginning;
   
    @FXML
    private VBox RegisterBox;

    @FXML
    private Label RegisterLabel;

    @FXML
    private JFXTextField FirstNameTextReg;

    @FXML
    private JFXTextField LastNameTextReg;

    @FXML
    private JFXTextField EmailTextReg;

    @FXML
    private JFXTextField PasswordTextReg;

    @FXML
    private HBox HBoxregister;

    @FXML
    private CheckBox checkBoxA;

    @FXML
    private Button RegisterButton;
    
    @FXML
    private VBox SignInBox;

    @FXML
    private Label SingInLabel;

    @FXML
    private JFXTextField EmailTextSignIn;

    @FXML
    private JFXTextField PasswordTextSignIn;

    @FXML
    private Button SignIn;
    
    private User user;
   
    /*private static RegisterSignInController instance;
    
    
    public RegisterSignInController(){
          instance = this;
    
    }
    
    public static RegisterSignInController getInstance(){
            return instance;
    }*/
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1.2), movingPanel);
        t.setToX(395);
        t.play();
        t.setOnFinished((e) -> {
            try {
                root = FXMLLoader.load(getClass().getResource("/game/signIn.fxml"));
                movingPanel.getChildren().removeAll();
                movingPanel.getChildren().setAll(root);
            } catch (IOException ex) {
                Logger.getLogger(controllers.RegisterSignInController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @FXML
    private void openLogin(ActionEvent event){
        TranslateTransition t = new TranslateTransition(Duration.seconds(1.2), movingPanel);
        t.setToX(page.getLayoutX());
        t.play();
        t.setOnFinished((e) -> {
            try {
                root = FXMLLoader.load(getClass().getResource("/game/register.fxml"));
                movingPanel.getChildren().removeAll();
                movingPanel.getChildren().setAll(root);
            } catch (IOException ex) {
                Logger.getLogger(controllers.RegisterSignInController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
       
}
    
     @FXML
    private void openRegister(ActionEvent event){
        TranslateTransition t = new TranslateTransition(Duration.seconds(1.2), movingPanel);
        t.setToX(395);
        t.play();
        t.setOnFinished((e) -> {
            try {
                root = FXMLLoader.load(getClass().getResource("/game/signIn.fxml"));
                movingPanel.getChildren().removeAll();
                movingPanel.getChildren().setAll(root);
            } catch (IOException ex) {
                Logger.getLogger(controllers.RegisterSignInController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    
    
    @FXML
    private void openHome(ActionEvent event) throws IOException, SQLException{
      
          try {
               FXMLLoader loader = new FXMLLoader();
             loader.setLocation(getClass().getResource("/game/home.fxml"));
             Parent windowHome = loader.load();
              
              
              
          // Parent windowHome = FXMLLoader.load(getClass().getResource("/game/home.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(windowHomeScene);
           window.show();
           
          HomeController homeC = loader.getController();
          signIn();
          homeC.setUser(user);
          System.out.println(user.toString());
           
           
       } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       }  
         
     }
    
    
     @FXML
    public void register(ActionEvent event) throws SQLException, IOException
    {
        int a;
        if (checkBoxA.isSelected()==true)
        {
          a=1;
        } else a=0;
    DBConnect connection= new DBConnect();
    connection.registerSQL(FirstNameTextReg.getText(), LastNameTextReg.getText(), EmailTextReg.getText(), PasswordTextReg.getText(),a);
    
       
    }
    @FXML
    public void signIn() throws SQLException
    {
    DBConnect connection = new DBConnect();
    user=connection.signInSQL(EmailTextSignIn.getText(), PasswordTextSignIn.getText());
    }
    
    
    
    
    
    
    
    
    
    
    
    

    
}

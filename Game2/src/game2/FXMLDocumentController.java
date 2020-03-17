/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.io.IOException;
import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author HP
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Parent root;
    
    @FXML
    private VBox movingPanel;
    
    @FXML
    private Button RegisterBeginning;

    @FXML
    private Button SignInBeginning;
    
    @FXML 
    AnchorPane page;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1.2), movingPanel);
        t.setToX(395);
        t.play();
        t.setOnFinished((e) -> {
            try {
                root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
                movingPanel.getChildren().removeAll();
                movingPanel.getChildren().setAll(root);
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
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
                root = FXMLLoader.load(getClass().getResource("Register.fxml"));
                movingPanel.getChildren().removeAll();
                movingPanel.getChildren().setAll(root);
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
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
                root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
                movingPanel.getChildren().removeAll();
                movingPanel.getChildren().setAll(root);
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    
}
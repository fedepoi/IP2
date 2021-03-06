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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.User;
import org.controlsfx.control.Rating;
import com.jfoenix.controls.JFXPasswordField;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ScoreController implements Initializable {
  @FXML
    private AnchorPane scorePane;

    @FXML
    private VBox scoreBox;

    @FXML
    private JFXTextField timeField;

    @FXML
    private VBox scoreSmallBox;

    @FXML
    private JFXTextField scoreField;

    @FXML
    private Button exitScoreButton;

    @FXML
    private Rating ratingStars;

    @FXML
    private Label labelRating;

    @FXML
    private HBox MenuBar;

    @FXML
    private Button SettingsMenu;

    @FXML
    private Button ReportsMenu;

    @FXML
    private Button LogOut;

    @FXML
    private Button goHome;
    
    private User user;
    
    
    public void setUser(User u){user=u;}
    public void setScore(int s){scoreField.setText(Integer.toString(s));}
    public void setTime (int t){timeField.setText(Integer.toString(t));}
    public void setRating(int rat){ratingStars.setRating(rat);}
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AnchorPane.setTopAnchor(MenuBar,0.0);
        AnchorPane.setLeftAnchor(MenuBar,0.0);
        AnchorPane.setRightAnchor(MenuBar,0.0);
        /**
           ratingStars.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
               
                labelRating.setText("Rating: " + newValue.toString());
            }
        });
        */
    }    
     @FXML
    public void goHome(ActionEvent event) throws IOException{
    
        try {
             FXMLLoader loader = new FXMLLoader();
             loader.setLocation(getClass().getResource("/game/home.fxml"));
             Parent windowHome = loader.load();
             
             HomeController hcon = loader.getController();
             hcon.setUser(user);
             
             Scene windowHomeScene = new Scene(windowHome);
             Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
             window.setScene(windowHomeScene);
             window.show();
       } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       }     
    }
    
    
    
    
        
}

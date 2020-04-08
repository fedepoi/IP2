/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Category;
import model.User;
import com.jfoenix.controls.JFXPasswordField;
/**
 * FXML Controller class
 *
 * @author VT
 */
public class HomeController implements Initializable {
    
    @FXML
    private AnchorPane anchorHome;

    @FXML
    private HBox MenuBar;

    @FXML
    private Button SettingsMenu;

    @FXML
    private Button ReportsMenu;

    @FXML
    private Button LogOut;

    @FXML
    private Button MathsImage;

    @FXML
    private Button GeographyImage;

    @FXML
    private Button ComputerImage;
    
    @FXML
    private TilePane tilePane;
    
    @FXML
    private Button addName;
    
    @FXML
    private Button AddCategory;

    @FXML
    private Button AddQuestion;

    @FXML
    private JFXComboBox<Category> selectCategory;

    @FXML
    private Button playButton;

    @FXML
    private Button imageButton;
    
    private User user;
    
    public void setUser(User u){user=u;};
    
  
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            DBConnect conn = new DBConnect();
             selectCategory.getItems().addAll(conn.getCategories());
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        AnchorPane.setTopAnchor(MenuBar,0.0);
        AnchorPane.setLeftAnchor(MenuBar,0.0);
        AnchorPane.setRightAnchor(MenuBar,0.0);
       
       
    }  
    
    
    
  @FXML
    private void openQuiz(ActionEvent event) throws IOException{
         try {
             FXMLLoader loader = new FXMLLoader();
             loader.setLocation(getClass().getResource("/game/quiz.fxml"));
             Parent windowHome = loader.load();
               
          // Parent windowHome = FXMLLoader.load(getClass().getResource("/game/quiz.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(windowHomeScene);
           window.show();
           
           QuizController c = loader.getController();
           c.setUser(user);
           /**
           if (event.getSource()==MathsImage){
           c.setCat(1);}
           else if (event.getSource()==GeographyImage){c.setCat(2);}
           else if (event.getSource()==ComputerImage){c.setCat(3);}
           */
           c.setCat(selectCategory.getSelectionModel().getSelectedItem().getId());
       
         } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       } 
               
    
}
 
    
@FXML
    private void Logout(ActionEvent event){
         try {
           
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/game/alertbox.fxml"));
           Parent windowHome = loader.load();
           
           Dialog dialog = new Dialog();
           dialog.getDialogPane().setContent(windowHome);
           //dialog.initStyle(StageStyle.TRANSPARENT);
           dialog.showAndWait();
           
         
        
         
         
       } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       }    
               
    }
    
    @FXML
    private void openSettingsAdmin(ActionEvent event) throws IOException{
         try {
             
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/game/settingsAdmin.fxml"));
           Parent windowHome = loader.load();           
           //Parent windowHome = FXMLLoader.load(getClass().getResource("/game/settingsAdmin.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(windowHomeScene);
           window.show();
           SettingsAdminController adminCon = loader.getController();
           adminCon.setUser(user);
          
           
       } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       } 
      
    }
    
    @FXML
    private void openSettingsUser(ActionEvent event) throws IOException{
         
    
         try {
            FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/game/settingsUser.fxml"));
           Parent windowHome = loader.load();   
          // Parent windowHome = FXMLLoader.load(getClass().getResource("/game/settingsUser.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           
           window.setScene(windowHomeScene);
           window.show();
           SettingsUserController userCon = loader.getController();
           userCon.setUser(user);
          
           
       } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       } 
      
    }
    @FXML
    public void checkUser(ActionEvent event) throws IOException{
        System.out.println(user.getAdmin()+"  I AM AN ADMIN?");
        if(user.getAdmin()==true){
            openSettingsAdmin(event);}
        else {openSettingsUser(event);}
    
    }
    
 @FXML
    private void openReports(ActionEvent event) throws IOException, SQLException{
         try {
             FXMLLoader loader = new FXMLLoader();
             loader.setLocation(getClass().getResource("/game/reports.fxml"));
             Parent windowHome = loader.load();
             
             ReportsController rController = loader.getController();
             rController.setUser(user);
             rController.setScoresInArea(user);
             
             
             
          // Parent windowHome = FXMLLoader.load(getClass().getResource("/game/quiz.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(windowHomeScene);
           window.show();
           
       
         } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       } 
               
    
}
    @FXML
    private void openAddCategory(ActionEvent event) throws IOException{
         try {
             
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/game/addCategory.fxml"));
           Parent windowHome = loader.load();           
           //Parent windowHome = FXMLLoader.load(getClass().getResource("/game/settingsAdmin.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(windowHomeScene);
           window.show();
           
           AddCategoryController adminCon = loader.getController();
           adminCon.setUser(user);
          
           
       } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       } 
      
    }
    
    @FXML
    private void openAddQuestion(ActionEvent event) throws IOException{
         try {
             
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/game/addQuestion.fxml"));
           Parent windowHome = loader.load();           
           //Parent windowHome = FXMLLoader.load(getClass().getResource("/game/settingsAdmin.fxml"));
           Scene windowHomeScene = new Scene(windowHome);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(windowHomeScene);
           window.show();
           AddQuestionController adminCon = loader.getController();
           adminCon.setUser(user);
           
           
       } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       } 
      
    }
    /**
     * set the bg image of the image button on combobox selection
     */    
    @FXML
    public void setBgImgButton(){
    if(selectCategory.getSelectionModel().getSelectedItem().getId()==1){ 
        imageButton.getStyleClass().clear();
        imageButton.getStyleClass().add("mathsImage");
    }
    else if(selectCategory.getSelectionModel().getSelectedItem().getId()==2){
        imageButton.getStyleClass().clear();
        imageButton.getStyleClass().add("geoImage");
       
    }
    else if(selectCategory.getSelectionModel().getSelectedItem().getId()==3){
        imageButton.getStyleClass().clear();
        imageButton.getStyleClass().add("computerImage");
      }
    else {
        imageButton.getStyleClass().clear();
        imageButton.getStyleClass().add("addCatImage");}
        
    
    }
    
}

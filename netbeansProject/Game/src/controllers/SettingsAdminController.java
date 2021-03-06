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
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Answer;
import model.Category;
import model.Question;
import model.User;
import com.jfoenix.controls.JFXPasswordField;
/**
 * FXML Controller class
 *
 * @author HP
 */
public class SettingsAdminController implements Initializable {

    @FXML
    private AnchorPane AdminSettingsPane;

    @FXML
    private HBox MenuBar;

    @FXML
    private Button SettingsMenu;

    @FXML
    private Button ReportsMenu;

    @FXML
    private Button LogOut;

    @FXML
    private VBox RegisterBoxSetAdmin;

    @FXML
    private Button goToHome;

    @FXML
    private Label ProfileLabel;

    @FXML
    private JFXTextField FirstNameTextSetAdmin;

    @FXML
    private JFXTextField LastNameTextSetAdmin;

    @FXML
    private JFXTextField EmailTextSetAdmin;

    @FXML
    private JFXPasswordField PasswordTextSetAdmin;

    @FXML
    private HBox HBoxregister;

    @FXML
    private CheckBox becomeUserCheckBox;

    @FXML
    private Button SaveProfileButtonAdmin;

    @FXML
    private VBox editCategoryBoxSetAdmin;

    @FXML
    private Label ProfileLabel1;

    @FXML
    private JFXComboBox<Category> categoryComboBox;

    @FXML
    private JFXComboBox<Question> questionComboBox;

    @FXML
    private JFXComboBox<Answer> answerComboBox;

    @FXML
    private JFXTextField editCategory;

    @FXML
    private JFXTextField editQuestionField;

    @FXML
    private JFXTextField editAnwerField;

    @FXML
    private HBox HBoxregister1;

    @FXML
    private Button deleteEditAdmin;
    
     @FXML
    private Button deleteCategoryButton;

    @FXML
    private Button editCategoryButton;
    
    @FXML
    private Button editQuestionButton;

    @FXML
    private Button deleteQuestionButton;
    
    @FXML
    private Button editAnswerButton;

    @FXML
    private Button deleteAnswerButton;

    @FXML
    private Button saveEditAdmin;
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
        
        DBConnect conn;
        try {
            conn = new DBConnect();
            categoryComboBox.getItems().addAll(conn.getCategories());
            
            
            
          
        } catch (SQLException ex) {
            Logger.getLogger(SettingsAdminController.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(controllers.SettingsAdminController.class.getName()).log(Level.SEVERE, null, ex);
       }   
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
           Logger.getLogger(controllers.SettingsAdminController.class.getName()).log(Level.SEVERE, null, ex);
       }    
               
    }
    
     @FXML
    public void updateDetails(ActionEvent event) throws SQLException, IOException{
         int a;
        if (becomeUserCheckBox.isSelected()==true)
        {
          a=0;
        } else a=1;
    System.out.print(user);
    DBConnect conn = new DBConnect();
    conn.updateUser(user, FirstNameTextSetAdmin.getText(), LastNameTextSetAdmin.getText(), EmailTextSetAdmin.getText(), PasswordTextSetAdmin.getText(),a);
    user.setName(FirstNameTextSetAdmin.getText());
    user.setLName(LastNameTextSetAdmin.getText());
    user.setMail(EmailTextSetAdmin.getText());
    user.setPass(PasswordTextSetAdmin.getText());
    user.setAdmin(becomeUserCheckBox.isSelected());   
    goToHome(event);
    }
    
    
    @FXML
    public void getQuestionFromCB() throws SQLException{
     DBConnect conn = new DBConnect();
     questionComboBox.getItems().clear();
     questionComboBox.getItems().addAll(conn.getQuestionByCat(categoryComboBox.getSelectionModel().getSelectedItem().getId()));
    }
    @FXML
    public void getAnswerFromCB() throws SQLException{
     DBConnect conn = new DBConnect();
     answerComboBox.getItems().clear();
     answerComboBox.getItems().addAll(conn.getRelatedAnswer(questionComboBox.getSelectionModel().getSelectedItem().getId()));
    }
    
    @FXML
    public void openEditBoxCat(ActionEvent event) throws IOException{
        
         try {
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/game/editbox.fxml"));
           Parent windowHome = loader.load();
           
           Dialog dialog = new Dialog();
           dialog.getDialogPane().setContent(windowHome);
           //dialog.initStyle(StageStyle.TRANSPARENT);
           dialog.show();
           EditboxController editCon = loader.getController();
           editCon.setCat(categoryComboBox.getSelectionModel().getSelectedItem());
           editCon.setActionCat();
             } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       } 
          
    
    }
    
    @FXML
    public void openEditBoxQues(ActionEvent event) throws IOException{
        
         try {
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/game/editbox.fxml"));
           Parent windowHome = loader.load();
           
           Dialog dialog = new Dialog();
           dialog.getDialogPane().setContent(windowHome);
           //dialog.initStyle(StageStyle.TRANSPARENT);
           dialog.show();
           EditboxController editCon = loader.getController();
           editCon.setQues(questionComboBox.getSelectionModel().getSelectedItem());
           editCon.setActionQues();
             } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       } 
    }
    
    @FXML
    public void openEditBoxAnsw(ActionEvent event) throws IOException{
        
         try {
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/game/editbox.fxml"));
           Parent windowHome = loader.load();
           
           Dialog dialog = new Dialog();
           dialog.getDialogPane().setContent(windowHome);
           //dialog.initStyle(StageStyle.TRANSPARENT);
           dialog.show();
           EditboxController editCon = loader.getController();
           editCon.setAnsw(answerComboBox.getSelectionModel().getSelectedItem());
           editCon.setActionAnsw();
             } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       } 
          
    
    }
    
    
     @FXML
    public void openAlertDeleteCat(ActionEvent event) throws IOException{
        
         try {
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/game/alertDelete.fxml"));
           Parent windowHome = loader.load();
           
           Dialog dialog = new Dialog();
           dialog.getDialogPane().setContent(windowHome);
           //dialog.initStyle(StageStyle.TRANSPARENT);
           dialog.show();
           
           AlertDeleteController aDCon=loader.getController();
           aDCon.setCat(categoryComboBox.getSelectionModel().getSelectedItem());
           aDCon.setOnActionCat();
             } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       } 
          
    
    }
    
    @FXML
    public void openAlertDeleteQues(ActionEvent event) throws IOException{
        
         try {
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/game/alertDelete.fxml"));
           Parent windowHome = loader.load();
           
           Dialog dialog = new Dialog();
           dialog.getDialogPane().setContent(windowHome);
           //dialog.initStyle(StageStyle.TRANSPARENT);
           dialog.show();
           
           AlertDeleteController aDCon=loader.getController();
           aDCon.setQues(questionComboBox.getSelectionModel().getSelectedItem());
           aDCon.setOnActionQues();
             } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       } 
          
    
    }
    
    @FXML
    public void openAlertDeleteAnsw(ActionEvent event) throws IOException{
        
         try {
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/game/alertDelete.fxml"));
           Parent windowHome = loader.load();
           
           Dialog dialog = new Dialog();
           dialog.getDialogPane().setContent(windowHome);
           //dialog.initStyle(StageStyle.TRANSPARENT);
           dialog.show();
           
           AlertDeleteController aDCon=loader.getController();
           aDCon.setAnsw(answerComboBox.getSelectionModel().getSelectedItem());
           aDCon.setOnActionAnsw();
             } catch (IOException ex) {
           Logger.getLogger(controllers.HomeController.class.getName()).log(Level.SEVERE, null, ex);
       } 
          
    
    }
    
}

    


    




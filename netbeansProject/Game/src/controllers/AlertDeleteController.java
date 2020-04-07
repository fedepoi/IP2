/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Answer;
import model.Category;
import model.Question;
import model.User;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AlertDeleteController implements Initializable {

    
    @FXML
    private Button yesDelete;

    @FXML
    private Button cancelDelete;
    
    private Category cat;
    private Question ques;
    private Answer answ;
    private User user;
    public void setUser(User u){user=u;};
    public void setCat(Category c){cat=c;}
    public void setQues(Question q){ques=q;}
    public void setAnsw(Answer a){answ=a;}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void closeAlertDeleteBox (ActionEvent event) throws IOException{
    
    cancelDelete = (Button) event.getSource();
    Stage window = (Stage) cancelDelete.getScene().getWindow();
    window.close(); 
    yesDelete = (Button) event.getSource();
    window.close(); 
    }
    
    public void deleteCat(ActionEvent event) throws SQLException, IOException{
    DBConnect conn = new DBConnect();
    conn.deleteCat(cat.getId());
    closeAlertDeleteBox(event);
    }
    public void setOnActionCat(){
    yesDelete.setOnAction((event) -> {
        try {
            deleteCat(event);
        } catch (SQLException ex) {
            Logger.getLogger(AlertDeleteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AlertDeleteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    }
    
    public void deleteQues(ActionEvent event) throws SQLException, IOException{
    DBConnect conn = new DBConnect();
    conn.deleteQues(ques.getId());
    closeAlertDeleteBox(event);
    }
    public void setOnActionQues(){
    yesDelete.setOnAction((event) -> {
        try {
            deleteQues(event);
        } catch (SQLException ex) {
            Logger.getLogger(AlertDeleteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AlertDeleteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    }
    
    public void deleteAnsw(ActionEvent event) throws SQLException, IOException{
    DBConnect conn = new DBConnect();
    conn.deleteAnsw(answ.getId());
    closeAlertDeleteBox(event);
    }
    public void setOnActionAnsw(){
    yesDelete.setOnAction((event) -> {
        try {
            deleteAnsw(event);
        } catch (SQLException ex) {
            Logger.getLogger(AlertDeleteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AlertDeleteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    }
    
  
}

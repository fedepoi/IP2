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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
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
public class EditboxController implements Initializable {

    @FXML
    private TextArea editArea;
    
     @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;
    
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
    
public void closeEditBox (ActionEvent event) throws IOException{
    
    cancelButton = (Button) event.getSource();
    Stage window = (Stage) cancelButton.getScene().getWindow();
    window.close(); 
    okButton = (Button) event.getSource();
    window.close();
    }
 
public void editCat(ActionEvent event) throws SQLException, IOException{
DBConnect conn= new DBConnect();
conn.updateCat(editArea.getText(), cat.getId());
closeEditBox(event);
}
public void setActionCat(){
okButton.setOnAction((event) -> {
    try {
        editCat(event);
    } catch (SQLException ex) {
        Logger.getLogger(EditboxController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(EditboxController.class.getName()).log(Level.SEVERE, null, ex);
    }
});
}

public void editQues(ActionEvent event) throws SQLException, IOException{
DBConnect conn= new DBConnect();
conn.updateQues(editArea.getText(), ques.getId());
closeEditBox(event);
}
public void setActionQues(){
okButton.setOnAction((event) -> {
    try {
        editQues(event);
    } catch (SQLException ex) {
        Logger.getLogger(EditboxController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(EditboxController.class.getName()).log(Level.SEVERE, null, ex);
    }
});
}

public void editAnsw(ActionEvent event) throws SQLException, IOException{
DBConnect conn= new DBConnect();
conn.updateAnsw(editArea.getText(), answ.getId());
closeEditBox(event);
}
public void setActionAnsw(){
okButton.setOnAction((event) -> {
    try {
        editAnsw(event);
    } catch (SQLException ex) {
        Logger.getLogger(EditboxController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(EditboxController.class.getName()).log(Level.SEVERE, null, ex);
    }
});
}

    
}

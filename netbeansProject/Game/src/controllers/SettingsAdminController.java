/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
    private JFXTextField PasswordTextSetAdmin;

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
    private JFXComboBox<String> categoryComboBox;

    @FXML
    private JFXComboBox<String> questionComboBox;

    @FXML
    private JFXComboBox<String> answerComboBox;

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
    private Button saveEditAdmin;

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

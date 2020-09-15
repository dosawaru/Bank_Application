/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.PasswordField;

/**
 *
 * @author Daniel O
 */
public class ManagerGUI {
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    
    @FXML private TextField usernamem;
    @FXML private PasswordField passwordm;
    @FXML private Label message;
    @FXML private Button deleteCustomer;
    @FXML private Button addCustomer;
    @FXML private Button logout;
    
    public boolean scanInput(String username, String password){
        
        if(username == null || username.isEmpty() || password == null || password.isEmpty()){
            this.message.setText("Invaild, please try again!");
            return false;
        }
        else{
            return true;
        }  
    }
    
    public void deleteCustomer(ActionEvent event){
         
        String username = usernamem.getText();
        String password = passwordm.getText();
        
        boolean output = scanInput(username, password);
        
        if(output == true){
            
            Customer c2 = new Customer(username, password);
            Manager m2 = new Manager("admin", "admin", "manager");
            
            boolean delete = m2.deleteCustomer(c2);
            
            if(delete == false){
                this.message.setText("Invaild, customer was not deleted");
            }else{
                this.message.setText("Customer was deleted");
            }
        }
    }
    
    public void addCustomer(ActionEvent event){
    
        String username = usernamem.getText();
        String password = passwordm.getText();
        
        boolean output = scanInput(username, password);
        
        if(output == true){
            
            Customer c1 = new Customer(username, password);
            Manager m1 = new Manager("admin", "admin", "manager");
            
            boolean add = m1.addCustomer(c1);
            
            if(add == true){
                this.message.setText("Customer was added");
            }else if(add == false){
                this.message.setText("Invaild, customer was not added");
            }
        }
    }
    
    public void logout(ActionEvent event) throws IOException{
        
        Parent bankGUI = FXMLLoader.load(getClass().getResource("BankFXML.fxml"));
        Scene mainGUI = new Scene(bankGUI);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainGUI);
        window.show();
        System.out.println("Logout Successfully!");
    }

    @FXML
    void initialize() {
        assert message != null : "fx:id=\"message\" was not injected: check your FXML file 'ManagerFXML.fxml'.";
        assert addCustomer != null : "fx:id=\"addCustomer\" was not injected: check your FXML file 'ManagerFXML.fxml'.";
        assert logout != null : "fx:id=\"logout\" was not injected: check your FXML file 'ManagerFXML.fxml'.";
        assert deleteCustomer != null : "fx:id=\"deleteCustomer\" was not injected: check your FXML file 'ManagerFXML.fxml'.";
        assert usernamem != null : "fx:id=\"usernamem\" was not injected: check your FXML file 'ManagerFXML.fxml'.";
        assert passwordm != null : "fx:id=\"passwordm\" was not injected: check your FXML file 'ManagerFXML.fxml'.";

    }
}

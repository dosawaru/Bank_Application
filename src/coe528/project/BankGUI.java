/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

/**
 *
 * @author Daniel O
 */
public class BankGUI {
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML private TextField usernameb;
    @FXML private PasswordField passwordb;
    @FXML private TextField roleb;
    @FXML private Label message;
    @FXML private Button managerbutton;
    @FXML private Button customerbutton;
    
     
    public boolean scanInput(String username, String password, String role){
        
        if(username == null || username.isEmpty() || password == null || password.isEmpty() || role == null || role.isEmpty()){
            this.message.setText("Invaild, please try again!");
            System.out.println("Unsuccessful login");
            return false;
        }
        else{
            return true;
        }  
    }
    
    @FXML
    public void managerLogin(ActionEvent event) throws IOException{

        String username = usernameb.getText();
        String password = passwordb.getText();
        String role = roleb.getText();
        
        boolean input = scanInput(username, password, role);
        
        if(input == true){
            
            Manager m = new Manager(username, password, role);
            
            boolean successfully = m.login();

            if(successfully == false){
                this.message.setText("Invaild, you're not the manager");
            }else{    
                System.out.println("Login successfully!");
                
                Parent managerGUI = FXMLLoader.load(getClass().getResource("ManagerFXML.fxml"));
                Scene managerScene = new Scene(managerGUI);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(managerScene);
                window.show(); 
            }
        }  
    }
    
    @FXML
    public void customerLogin(ActionEvent event) throws IOException{
      
        String username = usernameb.getText();
        String password = passwordb.getText();
        String role = roleb.getText();
        
        boolean input = scanInput(username, password, role);
        
        if(input == true){
            if(role.equals("customer") || role.equals("Customer")){

                Manager m = new Manager("admin", "admin", "manager");
                Customer c = new Customer(username, password);

                boolean result = m.searchCustomer(c);

                if(result == true){
                    m.setcrtCustomer(c);
                    System.out.println("Successful login");
                    
                    Parent customerGUI = FXMLLoader.load(getClass().getResource("CustomerFXML.fxml"));
                    Scene customerScene = new Scene(customerGUI);  
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(customerScene);
                    window.show();
                }
                else{
                    this.message.setText("Invaild, try again");
                }
            }else{
                this.message.setText("Invaild, you're not the customer");
            }
        }
        
    }
    
    @FXML
    void initialize() {
        assert managerbutton != null : "fx:id=\"managerbutton\" was not injected: check your FXML file 'BankFXML.fxml'.";
        assert customerbutton != null : "fx:id=\"customerbutton\" was not injected: check your FXML file 'BankFXML.fxml'.";
        assert usernameb != null : "fx:id=\"usernameb\" was not injected: check your FXML file 'BankFXML.fxml'.";
        assert roleb != null : "fx:id=\"roleb\" was not injected: check your FXML file 'BankFXML.fxml'.";
        assert passwordb != null : "fx:id=\"passwordb\" was not injected: check your FXML file 'BankFXML.fxml'.";
        assert message != null : "fx:id=\"message\" was not injected: check your FXML file 'BankFXML.fxml'.";

    }  
}

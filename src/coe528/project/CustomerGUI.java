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


/**
 *
 * @author Daniel O
 */
public class CustomerGUI {
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML private TextField depositmoney;
    @FXML private TextField withdrawmoney;
    @FXML private TextField onlinepurchasemoney;
    @FXML private Label output;
    @FXML private Label level;
    @FXML private Button depositbutton;
    @FXML private Button withdrawbutton;
    @FXML private Button purchasebutton;
    @FXML private Button checkbalancebutton;
    @FXML private Button logoutbutton;
     
    @FXML
    public void deposit() throws IOException{
        
        double deposit = Double.parseDouble(depositmoney.getText());
        
        if(deposit == 0 || deposit < 0){
            output.setText("Please input a value to deposit");
        }else{
           Manager m1 = new Manager("admin", "admin", "manager");
           Customer c1 = m1.getcrtCustomer(); 
           
           c1.depositBalance(deposit);
           
           level.setText("Your Current Level: " + c1.myLevel());
           
           boolean update = m1.updateCustomer(c1);
           
           if(update == false){
               output.setText("Error, try again!");
           }else{
               output.setText("Deposited Successfully!");               
           }
        }
    }
    
    @FXML
    public void withdraw() throws IOException{
         
        double withdraw = Double.parseDouble(withdrawmoney.getText());
        
        if(withdraw == 0 || withdraw < 0){
            output.setText("Please input a value to withdraw");
        }else{
           Manager m1 = new Manager("admin", "admin", "manager");
           Customer c2 = m1.getcrtCustomer(); 
           
           c2.withdrawBalance(withdraw);
           
           level.setText("Your Current Level: " + c2.myLevel());
           
           boolean update = m1.updateCustomer(c2);
           
           if(update == false){
               output.setText("Error, not enough money to withdraw, try again!");
           }else{
               output.setText("Withdrawed Successfully!");               
           }
        }
    }
    
    @FXML
    public void onlinePurchase(){
        
        double onlinepurchasce = Double.parseDouble(onlinepurchasemoney.getText());
        
        if(onlinepurchasce <= 0){
            output.setText("Please input a value for purchase");
        }else{
           Manager m1 = new Manager("admin", "admin", "manager");
           Customer c3 = m1.getcrtCustomer(); 
                   
           boolean update = m1.updateCustomer(c3);
           boolean result = c3.onlinePurchase(onlinepurchasce);
           
           level.setText("Your Current Level: " + c3.myLevel());
           
           if(update == false || result == false){
               if(c3.myLevel().equals("Silver")){
                   output.setText("Error, purchase must be more than $50, try again!");
               }else{
                   output.setText("Error, purchase must be more than $10, try again!");
               }
           }else{
               output.setText("Withdrawed Successfully!");               
           }
        } 
    }
    
    @FXML
    public void currentBalance(){
        Manager m1 = new Manager("admin", "admin", "manager");
        Customer c2 = m1.getcrtCustomer();
        double balance = c2.getbalance();
        level.setText("Your Current Level: " + c2.myLevel());
        output.setText("Your current balance is: $" + balance);
    } 
    
    @FXML
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
        assert depositbutton != null : "fx:id=\"depositbutton\" was not injected: check your FXML file 'CustomerFXML.fxml'.";
        assert withdrawbutton != null : "fx:id=\"withdrawbutton\" was not injected: check your FXML file 'CustomerFXML.fxml'.";
        assert purchasebutton != null : "fx:id=\"onlinepurchasebutton\" was not injected: check your FXML file 'CustomerFXML.fxml'.";
        assert checkbalancebutton != null : "fx:id=\"checkbalancebutton\" was not injected: check your FXML file 'CustomerFXML.fxml'.";
        assert logoutbutton != null : "fx:id=\"logutbutton\" was not injected: check your FXML file 'CustomerFXML.fxml'.";
        assert depositmoney != null : "fx:id=\"depositmoney\" was not injected: check your FXML file 'CustomerFXML.fxml'.";
        assert withdrawmoney != null : "fx:id=\"withdrawmoney\" was not injected: check your FXML file 'CustomerFXML.fxml'.";
        assert onlinepurchasemoney != null : "fx:id=\"onlinepurchasemoney\" was not injected: check your FXML file 'CustomerFXML.fxml'.";
        assert output != null : "fx:id=\"output\" was not injected: check your FXML file 'CustomerFXML.fxml'.";

    }
    
}

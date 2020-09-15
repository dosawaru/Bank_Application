/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Daniel O
 */

/*Overview: This class performs operations for the customer and the account class like
logged in, logging out, depositing, withdrawing, and online purchases
This class is mutable*/

/*Abtraction Function: AF(c) is an abstract customer A where A name is customer.name, 
A password customer.password, A role is A.role, A balance is customer.balance
A account is customer.account. Customer is implemented in the manger class through
an arraylist to control the operations and keep track of the customer in the bank application*/

/*Rep Invariant: RI(c) is true if the suername, password, and role are not empty,
the balance is non-negative ans the object of the account is not null
All the instance variables atr protected*/

public class Customer extends User{
    
    //Global variable
    protected double balance;
    
    //public Customer
    Account ac = new Account(100);
    
    
    //REQUIRES: password and username are strings that are not empty 
    //MODIFIES: these input do not change
    //EFFECTS: this is the constructor of the class, it sets the initials values of the class
    public Customer(String username, String password){
        this.username = username;
        this.password = password; 
        this.balance = 100;
    }
    
    //REQUIRES: none
    //MODIFIES: none
    //EFFECTS: checks the role of to see if it matches the correct role
    public boolean login(){
        if(this.role.equals("customer") || this.role.equals("Customer")){
            return true;
        }else{
            return false;
        }       
    }
    
    //REQUIRES: none
    //MODIFIES: none
    //EFFECTS: makes all the instance variables string empty and sets the balance to 0
    public void logout(){
        this.username = "";
        this.password = "";
        this.role = "";
        this.balance = 0;
    }
    
    //REQUIRES: none
    //MODIFIES: none
    //EFFECTS: return the current level of the customer
    public String myLevel(){
        
        return ac.getLevel();
    }
    
    //REQUIRES: double represents the amount of money deposited, can not deposit negative 
    //MODIFIES: the input is used to perform an operation which adds the current balance with the deposit balance
    //modifies other variables but not itself
    //EFFECTS: this method takes in the amount to deposit, adds its to the global variable, balance, then sets it to
    // the account balance and then updates the new balance and level based on the balance
    public void depositBalance(double amount) throws IOException {
        
        
        if(amount > 0){
            //Operation for deposit
            System.out.println("Deposit balance");
            double depositBalance = ac.getBalance();
            depositBalance += amount; 

            //Updates new balance and level
            ac.setBalance(depositBalance);
            ac.currentLevel(depositBalance);

            //Updates the file
            File file = new File("./Customer\\" + username + ".txt");
            if(file.exists()){
                FileWriter write = new FileWriter(file);
                write.write("Username: " + username + "\n" +  "Password: " + password + "\n" + "Balance: " + (depositBalance));
                write.flush();
                write.close();
                System.out.println("Successfully");
            }
        }else{
            System.out.println("Error, you can not deposit a negative amount");
        }
    }
    
    //REQUIRES: double represents the amount of money deposited, can not deposit negative 
    //MODIFIES: the input is used to perform an operation which subtracting the current balance with the withdraw balance
    //modifies other variables but not itself
    //EFFECTS: this method takes in the amount to withdraw, subtracts its to the global variable, balance, then sets it to
    // the account balance and then updates the new balance and level based on the balance
    public void withdrawBalance(double amount) throws IOException {
        
        //Checks if the amount withdraw is less then current balance
        //True when there is enough money in account
        if(ac.getBalance() > amount){
            System.out.println("Withdraw balance");
            double withdrawBalance = ac.getBalance();
            withdrawBalance -= amount; 
            
             //Updates new balance and level
            ac.setBalance(withdrawBalance);
            ac.currentLevel(withdrawBalance);

            //Updates the file
            File file = new File("./Customer\\" + username + ".txt");
            if(file.exists()){
            FileWriter write = new FileWriter(file);
            write.write("Username: " + username + "\n" +  "Password: " + password + "\n" + "Balance: " + withdrawBalance);
            write.flush();
            write.close();
            System.out.println("Successfully");
            }           
        }else{
            System.out.println("Error, there is not enough money to withdraw");
        }
    }
    
    //REQUIRES: none
    //MODIFIES: none
    //EFFECTS: returns the balance of the current customer balance
    public double getbalance(){
        return ac.getBalance();
    }
    
    //REQUIRES: double represents the amount of money deposited, can not deposit negative 
    //MODIFIES: the input is used to perform an operation which subtracting the current balance with the withdraw balance
    //modifies other variables but not itself
    //EFFECTS: In this method he checks the level of the current account and based on the customer balance a certain
    //amount is need to make a purchase or does not require an purchae limit. It uses the withdraw method beacuse it works
    //in a similar way, money is being deducted.
    public boolean onlinePurchase(double amount){
        
        if("Platinum".equals(ac.getLevel())){
            try {
                withdrawBalance(amount);
                return true;
            } catch (IOException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if("Gold".equals(ac.getLevel())){           
            try {
                if(amount > 10){
                    withdrawBalance(amount);
                    return true;
                }
            } catch (IOException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if("Silver".equals(ac.getLevel())){
            try {
                if(amount > 50){
                    withdrawBalance(amount);
                    return true;
                }
            } catch (IOException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    //Implementing the abstraction function
    @Override
    public String toString(){
        return username + " " + password + " " + role + " " + balance;
    }
    
    //Implementing the repOk function
    public boolean repOk(){
        return !(username == null || password == null || role == null || balance <= 0 || ac == null || !(ac instanceof Account) || username.isEmpty() || password.isEmpty() || role.isEmpty());
    }
}

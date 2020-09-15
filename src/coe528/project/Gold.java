/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author Daniel O
 */
public class Gold extends Account {
    
    public Gold(double balance){
        super(balance);
    }
    
    public double onlinePurchase(double amount, double balance){
        
        double pay = 10 + amount; 
                
        if(pay > balance){
            //customer can not afford purchase
            return balance;
        }
        else{
            //customer can afford purchase
            //pay gets deducted
            balance = balance - pay;
            return balance;
        }
    }
}

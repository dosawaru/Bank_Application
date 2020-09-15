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
public class Platinum extends Account {
    
    public Platinum(double balance){
        super(balance);
    }
    
    public double onlinePurchase(double amount, double balance){
        if(amount > balance){
            //customer can not afford purchase
            return balance;
        }
        else{
            //customer can afford purchase
            //amount gets deducted
            balance = balance - amount;
            return balance;
        }
    }
}

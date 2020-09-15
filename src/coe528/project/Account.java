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
public class Account {
    
    protected String level;
    protected double balance;
    
    Account(double balance){
        this.balance = balance;
        
        if(balance < 10000)
            this.level = "Silver";
        else if(balance >= 10000 && balance < 20000)
            this.level = "Gold";
        else if(balance >= 20000)
            this.level = "Platinum";
    }
    
    public double getBalance(){
        return this.balance;
    }
    
    public void setBalance(double x){
        this.balance = this.balance + x;
    }
    
    public void setLevel(String y){
        this.level = y;
    }
    
    public String getLevel(){
        return this.level;
    }
    
    public void currentLevel(double balance){
        this.balance = balance;
        
        if(balance < 10000)
            this.level = "Silver";
        else if(balance >= 10000 && balance < 20000)
            this.level = "Gold";
        else if(balance >= 20000)
            this.level = "Platinum";
    }
}

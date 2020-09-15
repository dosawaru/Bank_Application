/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.*;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author Daniel O
 */
public class DeleteFile {
    
    protected String username;
    protected String password;
    protected double balance;
    
    public DeleteFile(String username, String password, double balance){
        this.username = username;
        this.password = password;
        this.balance = balance;
    }
    
    public DeleteFile(Customer c){
        this.username = c.username;
        this.password = c.password;
        this.balance = c.balance;
        
        try{
            boolean correct = DeleteFile(c);
        } catch(IOException ex){
            Logger.getLogger(DeleteFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean DeleteFile(Customer a) throws IOException{
        File file = new File("./Customer\\" + a.username + ".txt");
       
        if(file.exists()){
            file.delete();
            System.out.println("The file has be deleted for the customer successfully");
            return true;
        }else{
            return false;
        }
    }

    public String getUersname(){
        return this.username;
    }
    
    public void setUsername(String s){
        this.username = s;
    }
    
    public void setPassword(String p){
        this.password = p;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public double getBalance(){
        return this.balance;
    }
    
    public void setBalance(double b){
        this.balance = b;
    }
    
}
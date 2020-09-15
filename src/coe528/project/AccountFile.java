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
public class AccountFile {
    
    protected String username;
    protected String password;
    protected double balance;
    
    public AccountFile(String username, String password, double balance){
        this.username = username;
        this.password = password;
        this.balance = balance;
    }
    
    public AccountFile(Customer c){
        this.username = c.username;
        this.password = c.password;
        this.balance = c.balance;
        
        try{
            boolean correct = CreateFile(c);
        } catch(IOException ex){
            Logger.getLogger(AccountFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean CreateFile(Customer a) throws IOException{
        File file = new File("./Customer\\" + a.username + ".txt");
       
        if(!file.exists()){
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileWriter write = new FileWriter(file);
            write.write("Username: " + a.username + "\n" +  "Password: " + a.password + "\n" + "Balance: " + this.balance);
            write.flush();
            write.close();
            System.out.println("The file has be created for the customer successfully");
            return true;
        }else{
            return false;
        }
    }

    public boolean UpdateFile(String username, String password, double balance) throws IOException{
    
        File file = new File("./Customer\\" + username + ".txt");
        if(file.exists()){
            FileWriter write = new FileWriter(file);
            write.write("Username: " + username + "\n" +  "Password: " + password + "\n" + "Balance: " + this.balance);
            write.flush();
            write.close();
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
    
    public void setPasswors(String p){
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
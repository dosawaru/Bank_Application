/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.File;
import java.util.ArrayList;
/**
 *
 * @author Daniel O
 */
public class Manager extends User {
    
    private static ArrayList<Customer> customer = new ArrayList<>();
    static public ArrayList<AccountFile> file = new ArrayList();
    protected static Customer crtCustomer = new Customer("ac", "dc");
    
    public Manager(String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public Customer getcrtCustomer(){
        return crtCustomer;
    }
    
    public void setcrtCustomer(Customer c){
        crtCustomer = c;
    }
    
    public boolean login(){
        if(this.username.equals("admin") && this.role.equals("manager") && this.password.equals("admin")){
            return true;
        }else{
            return false;
        }
    }
    
     public boolean addCustomer(Customer ac){
         
        if(customer.isEmpty()){
            customer.add(ac);
            AccountFile file1 = new AccountFile(ac);
            file.add(file1);
            System.out.println("Customer has been added Successfully");
            return true;
        }
        
        for(int i = 0; i < customer.size(); i++){
            if((ac.username.equals(customer.get(i).username))){
                System.out.println("This customer can not be added");
                return false;
            }else{
                customer.add(ac);
                AccountFile file1 = new AccountFile(ac);
                file.add(file1);
                return true;
            }
        } 
        return false;
    }
    
    public boolean deleteCustomer(Customer dc){
    
        customer.add(dc);
               
        for(int j = 0; j < customer.size(); j++ ){
            if(dc.username.equals(customer.get(j).username)){
                customer.remove(dc);
                DeleteFile file2 = new DeleteFile(dc);
                file.remove(file2);
                return true; 
            }else{
                return false;
            }
        }
        return false;
    }
    
    public void logout(){
        this.username = "";
        this.password = "";
        this.role = "";
        
        System.out.println("Logout Sucessful");
    }
    
    public boolean searchCustomer(Customer sc){
        
        customer.add(sc);
        File file = new File("./Customer\\" + sc.username + ".txt");
        
        for(int i = 0; i < customer.size(); i++){
            if(file.exists()){
                System.out.println("Already exisiting account");
                return true;
            }
        }
        System.out.println("Return false");
        return false;
    }
    
    public boolean updateCustomer(Customer uc){
        AccountFile f = new AccountFile(uc);
        
        for(int i = 0; i < customer.size(); i ++){
            if(uc.username.equals(customer.get(i).username)){
                customer.set(i, uc);
                file.set(i, f);
                return true;
            }
        }
        return false;
    }
            
}

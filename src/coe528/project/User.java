/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.util.ArrayList;
/**
 *
 * @author Daniel O
 */
public abstract class User {
    
    protected String username;
    protected String password;
    protected String role;
    
    static public ArrayList <AccountFile> file = new ArrayList<>();
    
    public abstract boolean login();
    
    protected abstract void logout();
}

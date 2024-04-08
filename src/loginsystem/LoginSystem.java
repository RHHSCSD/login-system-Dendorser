/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginsystem;

/**
 *
 * @author michael.roy-diclemen
 */
import java.io.*;
import java.util.*;
public class LoginSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        User a = new User("danmual", "UpL{\\haL}T'v^k9", 10293901, 2, "ao", "aos");
        Register r = new Register();
        Login l = new Login();
        
        User b = new User("b", "p", 10293901, 2, "ao", "aos");
        User c = new User("u", "p", 10293901, 2, "ao", "aos");
        r.loadUsers();
            r.registerUser(a);
            r.registerUser(b);
            r.registerUser(c);
        
        if(r.checkPasswordStrength(a)){
            System.out.println("good password");
        }
        else{
            System.out.println("bad password");
        }
        l.loggingIn("danmual", "UpL{\\haL}T'v^k9");
    }
}
    

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginsystem;

/**
 *
 * @author Ernest
 */
import java.util.*;
import java.io.*;
public class Login {
    Register r = new Register();
    /**
     * Logs the user in
     * @param u - the username inputted
     * @param p - the password inputted
     * @return and int to denote whether or not the login was successful
     */
    public int loggingIn(String u, String p){
        try{
        File f = new File("a");
        Scanner s = new Scanner(f);
        String encryptedPassword= r.encryptPassword(p);
        while(s.hasNextLine()){
            String[] data = (s.nextLine().split(r.getDelimiter(),0));
            if(u.equals(data[0]) && encryptedPassword.equals(data[1])){
                return 0;
            }
        }
        s.close();
        
        }catch(IOException ex){
                System.out.println(ex);
        }
        return 1;
    }
}


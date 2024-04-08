/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginsystem;

/**
 *
 * @author Ernest
 */
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
public class Register {

    private ArrayList<User> accounts= new ArrayList<User>();
    private final String delimiter = ",";
    /**
     * Checks the user's password against several criteria including: length, use of upper, lower and special characters, and containing at least one number
     * @param p - the password the user inputted
     * @return a number used to denote password viability
     */
    public int checkPasswordStrength(String p){
        //will check if the password is strong enough and will return true if it is
        String pass = p;
        boolean length = false;
        boolean uCase = false;
        boolean lCase= false;
        boolean nums = false;
        boolean special = false;
        if(pass.length()>=8){
            length = true;
        }
        for(int i = 0; i<pass.length(); i++){
            if(Character.isUpperCase((pass.charAt(i)))){
                uCase = true;
            }
            else if(Character.isLowerCase((pass.charAt(i)))){
                lCase = true;
            }
            else if(Character.isDigit((pass.charAt(i)))){
                nums = true;
            }
            else if(!Character.isDigit((pass.charAt(i))) && !Character.isLetter((pass.charAt(i)))){
                special = true;
            }
        }
        if(length && uCase && lCase&& nums && special){
            return 1;
        }
        return 2;
    }
    /**
     * Registers a user into the system
     * @param r - passing on the user object
     * @return a number to denote a successful regristration 
     */
    public int registerUser(User r) { //replace with try catch
        //save the user to a file
        //create a printwriter
        //write to a file
        //close
        String password = r.getPassword();
        try {
            if(compareUsername(r.getUsername()) && checkPasswordStrength(password) == 1){
                File f = new File("a");
                PrintWriter pw = new PrintWriter(new FileWriter(f,true));
                r.setPassword(encryptPassword(password));
                System.out.println(r.toString());
                pw.println(r.toString());
                pw.close();
                return 0;
            }
            else if(!compareUsername(r.getUsername())){
                System.out.println("username is taken");
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return 1;
    }
    /**
     * encrypts the viable password
     * @param password - the password to be encrypted
     * @return the encrypted password
     */
    public String encryptPassword(String password){
        try{
            //java helper class to perform encryption
            MessageDigest md = MessageDigest.getInstance("MD5");
            //give the helper function the password
            md.update(password.getBytes());
            //perform the encryption
            byte byteData[] = md.digest();
            //To express the byte data as a hexadecimal number (the normal way)
            String encryptedPassword="";
            for (int i = 0; i < byteData.length; ++i) {
            encryptedPassword += (Integer.toHexString((byteData[i] & 0xFF) |0x100).substring(1,3));
            }
            return encryptedPassword;
    } catch(NoSuchAlgorithmException ex){
        System.out.println(ex);
    }
        return "123";
}
    /**
     * loads all of the data in the text file into an array list
     */
    public void loadUsers(){
        File f = new File("a");
        
        try{
            Scanner s = new Scanner(f);
        
            while(s.hasNext()){
                String[] data = (s.nextLine()).split(delimiter,0);
                User tempUser = new User(data[0], data[1], Long.parseLong(data[2]), Integer.parseInt(data[3]),(String) (data[4]),data[5]);
                getAccounts().add(tempUser);
            }
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
    /**
     * Checks if the inputted username is unique
     * @param u - the username to be checked
     * @return true or false whether or not the username is unique
     */
    public boolean compareUsername(String u){
        //will check if username is unique
        for (int i = 0; i<getAccounts().size(); i++) {
            if(u.equals((getAccounts().get(i)).getUsername())){
                return false;
            }
        }
        return true;
    }

    /**
     * @return the delimiter
     */
    public String getDelimiter() {
        return delimiter;
    }
        /**
     * @return the accounts
     */
    public ArrayList<User> getAccounts() {
        return accounts;
    }
}

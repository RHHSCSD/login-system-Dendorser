/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginsystem;

/**
 *
 * @author Ernes
 */
public class User {
    private String username;
    private String password;
    private long accountID;
    private int age;
    private String fName;
    private String lName;
    String Delimiter = ",";

    //Constructor used for User class
    public User(String u, String p, long aI, int a, String f, String l){
        username = u;
        password = p;
        accountID = aI;
        age = a;
        fName = f;
        lName = l;
    }
    //All setters
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the accountID
     */
    public long getAccountID() {
        return accountID;
    }

    /**
     * @param accountID the accountID to set
     */
    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * @return the lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public void setlName(String lName) {
        this.lName = lName;
    }
/**
 *  Formats the user data into a readable string 
 * @return 
 */    
    @Override
    public String toString(){
        return(username+Delimiter+password+Delimiter+accountID+Delimiter+age+Delimiter+fName+Delimiter+lName);
    }
    }

package cmis_wasted2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import cmis_wasted.*; 

import java.math.BigInteger;
import java.sql.Blob;

public class User {
    private int userID;
    private String username;
    private String email;
    private String password; 
    private String userType;
    private String address;
    private BigInteger phoneNo;
    private Blob profileImg;
    
    final String driver = "com.mysql.cj.jdbc.Driver";
    final String dbUrl = "jdbc:mysql://localhost:3306/wastedDB";
    
    String sql = ""; 
    String uname = "root";
    String pword = "";
    
    static Statement stmt = null;
    static ResultSet rs = null; 
    
    public User() {
        
    }
    
    public User(String username, String email, String password, String userType, String address, BigInteger phoneNo, Blob profileImg) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.address = address;
        this.phoneNo = phoneNo;
        this.profileImg = profileImg;
    }
    
    public void createUser(JTextField tfUname, JTextField tfEmail, JTextField tfPword, JFrame frm){
        if (tfUname.getText().toString().isEmpty() || tfEmail.getText().toString().isEmpty() || tfPword.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(frm, "Invalid Input! Text Fields must not be null");
                } else {
                    try {
                        Class.forName(driver);
                        Connection con = DriverManager.getConnection(dbUrl, uname, pword);
 
                        stmt = con.createStatement();
                        stmt.executeUpdate("Insert into user(username, password, email) Values('" +tfUname.getText().toString()+ "', '" +tfPword.getText().toString()+ "', '" +tfEmail.getText().toString()+ "')");
                        JOptionPane.showMessageDialog(frm, "Account Registered!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(frm, "SQL Error: " + e);
                    }
                }
    }
    
    public void editUser(JFrame frm){
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(dbUrl, uname, pword);
 
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE table_name\n" +
                                "SET column1 = value1, column2 = value2, ...\n" +
                                "WHERE condition;");
            JOptionPane.showMessageDialog(frm, "Update Successful!");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(frm, "SQL Error: " + e);
        }
    }
    
    public void deleteUser(JFrame frm){
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(dbUrl, uname, pword);
 
            stmt = con.createStatement();
            stmt.executeUpdate("Delete * Where email = " +getEmail());
            JOptionPane.showMessageDialog(frm, "Account Deleted!");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(frm, "SQL Error: " + e);
        }
    }
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigInteger getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(BigInteger phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Blob getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(Blob profileImg) {
        this.profileImg = profileImg;
    }
}

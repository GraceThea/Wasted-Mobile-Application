package cmis_wasted;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login {
    final String driver = "com.mysql.cj.jdbc.Driver";
    final String dbUrl = "jdbc:mysql://localhost:3306/wastedDB";
    
    String sql = ""; 
    String uname = "root";
    String pword = "";
    
    static Statement stmt = null;
    static ResultSet rs = null;    
    
    JFrame frm;
    JPanel panelMain;
    
    String email;
    String password;
    
    public Login(){
        frm = new JFrame("Wasted");
        panelMain = new JPanel();
        
        log(); 
        showFrame(); 
    }
    
    public void log(){
        JTextField tfEmail = new JTextField();
        tfEmail.setBounds(50,340,405,100); 
        tfEmail.setFont(new Font ("Arial", Font.ITALIC ,25));
        tfEmail.setText("email@company.com");
        
        JPasswordField tfPword = new JPasswordField();
        tfPword.setBounds(50,450,405,100); 
        tfPword.setFont(new Font ("Arial", Font.ITALIC,25));
        tfPword.setText("password");
        
        JButton btnRedirect = new JButton("     ");
        btnRedirect.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                new CreateAccount();
                frm.dispose();
            }  
        });
        btnRedirect.setBorderPainted(false);
        btnRedirect.setFocusPainted(false);
        btnRedirect.setContentAreaFilled(false);
        btnRedirect.setBounds(50,900,405,50);
        
        JButton btnForgot = new JButton("     ");
        btnForgot.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){    
                frm.dispose();
                //forgotPass(connect);
            }  
        });
        btnForgot.setBorderPainted(false);
        btnForgot.setFocusPainted(false);
        btnForgot.setContentAreaFilled(false);
        btnForgot.setBounds(225,555,160,20);
        
        JButton btnLogin = new JButton(" ");
        btnLogin .addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent ae){  
                
                try {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(dbUrl, uname, pword);
            
                    stmt = con.createStatement();
                    rs = stmt.executeQuery("Select * from user Where email = '" + tfEmail.getText()+ "' And password = '" + tfPword.getText()+ "'");
                    if (rs.next()) {

                        email = tfEmail.getText(); 
                        password = tfPword.getText();
                        new Home(email, password); 
                        frm.dispose();
                        JOptionPane.showMessageDialog(frm, "Login Success.");
                         
                       
                    } else {
                        JOptionPane.showMessageDialog(frm, "Login Failed.");
                    }
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frm, "SQL Error: " + e);
                }   
            }  
        });
        
        btnLogin.setBorderPainted(false);
        btnLogin.setFocusPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setBounds(50,635,405,65);

        
        String iconfilePath = this.getClass().getClassLoader().getResource("Login.png").getFile();
        ImageIcon background = new ImageIcon(iconfilePath);
        Image img = background.getImage();
        Image temp = img.getScaledInstance(500,975,Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        JLabel back=new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,0,500,975);
        
        back.add(btnRedirect); 
        back.add(btnForgot);
        back.add(tfEmail);
        back.add(tfPword);
        back.add(btnLogin);
        
        panelMain.add(back); 
    } 
    
    public void showFrame(){
        frm.setResizable(false);
        frm.setSize(500,1020);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frm.setLocationRelativeTo(null);
        frm.add(panelMain);
        frm.setVisible(true);
    }
}
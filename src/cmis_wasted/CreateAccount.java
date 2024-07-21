package cmis_wasted;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import cmis_wasted2.*; 

public class CreateAccount {
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
    
    public CreateAccount(){
        frm = new JFrame("Wasted");
        panelMain = new JPanel(); 
        create(); 
        showFrame(); 
    }
    
    public void create(){
        JTextField tfUname = new JTextField();
        tfUname.setBounds(50,365,405,90); 
        tfUname.setFont(new Font ("Arial", Font.ITALIC ,25)); 
        tfUname.setText("Username");
        
        JTextField tfEmail = new JTextField();
        tfEmail.setBounds(50,475,405,90); 
        tfEmail.setFont(new Font ("Arial", Font.ITALIC ,25));
        tfEmail.setText("Email");
        
        JPasswordField tfPword = new JPasswordField();
        tfPword.setBounds(50,590,405,90); 
        tfPword.setFont(new Font ("Arial", Font.ITALIC ,25));
        tfPword.setText("Password");

        JButton btnRedirect = new JButton();
        btnRedirect.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){  
                frm.dispose();
                new Login();  
            }  
        });
        btnRedirect.setBorderPainted(false);
        btnRedirect.setFocusPainted(false);
        btnRedirect.setContentAreaFilled(false);
        btnRedirect.setBounds(5,20,50,50);
        
        JButton btnSignup = new JButton();
        btnSignup.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent ae){  
                  User u = new User();
                  u.createUser(tfUname, tfEmail, tfPword, frm); 
            }  
        });
        btnSignup.setBorderPainted(false);
        btnSignup.setFocusPainted(false);
        btnSignup.setContentAreaFilled(false);
        btnSignup.setBounds(50,705,405,65);
        
        String iconfilePath = this.getClass().getClassLoader().getResource("SignUp.png").getFile();
        ImageIcon background = new ImageIcon(iconfilePath);
        Image img = background.getImage();
        Image temp = img.getScaledInstance(500,1020,Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        JLabel back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,0,500,975); 
        
        back.add(tfUname);
        back.add(tfEmail);
        back.add(tfPword);
        back.add(btnSignup);
        back.add(btnRedirect); 
        
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

package cmis_wasted;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Wishlist implements ActionListener{
    final String driver = "com.mysql.cj.jdbc.Driver";
    final String dbUrl = "jdbc:mysql://localhost:3306/wastedDB";
    
    String sql = ""; 
    String uname = "root";
    String pword = "";
    
    static Statement stmt = null;
    static ResultSet rs = null;
    
    JFrame frm;
    JLabel back;
    JPanel panelMain;
    
    String email;
    String password;
    
    public Wishlist(String email, String password){
        frm = new JFrame("Wasted");
        panelMain = new JPanel(); 
        
        String iconfilePath = this.getClass().getClassLoader().getResource("Wishlist.png").getFile();
        ImageIcon background = new ImageIcon(iconfilePath);
        Image img = background.getImage();
        Image temp = img.getScaledInstance(500,975,Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,0,500,975); 
        
        panelMain.add(back);
        
        this.email = email;
        this.password = password;
                
        icons();
        showFrame(); 
    }
    
    public void icons() {
        //Home
        JButton btnHome = new JButton("       ");
        btnHome.addActionListener(this);
        btnHome .setBorderPainted(false);
        btnHome.setFocusPainted(false);
        btnHome .setContentAreaFilled(false);
        btnHome .setBounds(10,910,80,72);
        
        back.add(btnHome);
        //Wishlist
        JButton btnWish = new JButton("  ");
        btnWish.addActionListener(this);
        btnWish .setBorderPainted(false);
        btnWish .setFocusPainted(false);
        btnWish .setContentAreaFilled(false);
        btnWish .setBounds(100,910,80,72);
        
        back.add(btnWish);
        //Payment
        JButton btnPay = new JButton("   ");
        btnPay.addActionListener(this);
        btnPay.setBorderPainted(false);
        btnPay.setFocusPainted(false);
        btnPay.setContentAreaFilled(false);
        btnPay.setBounds(220,910,80,72);
        
        back.add(btnPay);
        //Messages
        JButton btnMsg= new JButton("    ");
        btnMsg.addActionListener(this);
        btnMsg.setBorderPainted(false);
        btnMsg.setFocusPainted(false);
        btnMsg.setContentAreaFilled(false);
        btnMsg.setBounds(320,910,80,72);
        
        back.add(btnMsg);
        //Profile
        JButton btnProf = new JButton("     ");
        btnProf.addActionListener(this);
        btnProf.setBorderPainted(false);
        btnProf.setFocusPainted(false);
        btnProf.setContentAreaFilled(false);
        btnProf.setBounds(400,910,80,72);
        
        back.add(btnProf);
        
        JButton btnRedirect = new JButton();
        btnRedirect.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){  
                frm.dispose();
                new Home(email, password);  
            }  
        });
        btnRedirect.setBorderPainted(false);
        btnRedirect.setFocusPainted(false);
        btnRedirect.setContentAreaFilled(false);
        btnRedirect.setBounds(5,20,50,50);
        
        back.add(btnRedirect);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    String action = ae.getActionCommand();
        switch(action){
            case "       ":
                frm.dispose();
                new Home(email, password);
                break; 
            case "  ":
                frm.dispose();
                new Wishlist(email, password);
                break;
            case "   ":
                frm.dispose();
                new Payment(email, password);
                break;
            case "    ":
                frm.dispose();
                new Messages(email, password);
                break;
            case "     ":
                frm.dispose();
                new Profile(email, password);
                break;
        }
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

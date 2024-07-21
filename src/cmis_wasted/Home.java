package cmis_wasted;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Home implements ActionListener{
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
    
    public Home(String email, String password){
        frm = new JFrame("Wasted");
        panelMain = new JPanel(); 
        
        String iconfilePath = this.getClass().getClassLoader().getResource("Home.png").getFile();
        ImageIcon background = new ImageIcon(iconfilePath);
        Image img = background.getImage();
        Image temp = img.getScaledInstance(500,975,Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,0,500,975); 
        
        this.email = email;
        this.password = password; 
        
        buttons();
        icons();
        showFrame(); 
    }
    
    public void buttons() {
        //Sell Waste
        JButton btnSell = new JButton("      ");
        btnSell.addActionListener(this);
        btnSell .setBorderPainted(false);
        btnSell .setFocusPainted(false);
        btnSell .setContentAreaFilled(false);
        //btnSell .setBounds(30,190,140,125);
        btnSell .setBounds(345,250,140,125);
        
        back.add(btnSell);
        //Donate Waste
        JButton btnDonate = new JButton("       ");
        btnDonate.addActionListener(this);
        btnDonate .setBorderPainted(false);
        btnDonate .setFocusPainted(false);
        btnDonate .setContentAreaFilled(false);
        //btnDonate .setBounds(190,190,140,125);
        btnDonate .setBounds(30,190,140,125);
        
        back.add(btnDonate);

        //Forum
        JButton btnForum = new JButton("         ");
        btnForum .addActionListener(this);
        btnForum  .setBorderPainted(false);
        btnForum  .setFocusPainted(false);
        btnForum  .setContentAreaFilled(false);
        btnForum  .setBounds(30,350,140,125);
        
        back.add(btnForum);
        //Barter
        JButton btnBarter = new JButton("          ");
        btnBarter .addActionListener(this);
        btnBarter  .setBorderPainted(false);
        btnBarter  .setFocusPainted(false);
        btnBarter  .setContentAreaFilled(false);
        btnBarter  .setBounds(190,350,140,125);
        
        back.add(btnBarter);
        //Tracking
        JButton btnTracking = new JButton("           ");
        btnTracking.addActionListener(this);
        btnTracking .setBorderPainted(false);
        btnTracking .setFocusPainted(false);
        btnTracking.setContentAreaFilled(false);
        //btnTracking .setBounds(345,350,140,125);
        btnTracking .setBounds(195,190,140,125);
        
        
        back.add(btnTracking);
    }
    
    //Icons
    public void icons() {
        //Home
        JButton btnHome = new JButton("");
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
            case "             ":
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
            case "      ":
                frm.dispose();
                new SellWaste();
                break;
            case "       ":
                frm.dispose();
                new DonateWaste();
                break;
            case "        ":
                frm.dispose();
                new Report();
                break;
            case "         ":
                frm.dispose();
                new Forum();
                break;
            case "          ":
                frm.dispose();
                new OfferBarter();
                break;
            case "           ":
                frm.dispose();
                new DeliveryTracking();
                break;
            }
    }
    
    public void showFrame(){
        panelMain.add(back);
        
        frm.setResizable(false);
        frm.setSize(500,1020);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frm.setLocationRelativeTo(null);
        frm.add(panelMain);
        frm.setVisible(true);
    }
}

package cmis_wasted;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import cmis_wasted2.*; 
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Profile implements ActionListener{
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
    
    private User user; 
    
    public Profile(String email, String password){
        frm = new JFrame("Wasted");
        panelMain = new JPanel(); 
        
        String iconfilePath = this.getClass().getClassLoader().getResource("Profile.png").getFile();
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
              
        info(); 
        icons();
        showFrame(); 
    }
    
    public void info() {
        JLabel greet = new JLabel ();
        greet.setFont(new Font("Arial", Font.PLAIN, 50));
        greet.setForeground(Color.WHITE); 
        greet.setBounds(125,125,500,100);
        try {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(dbUrl, uname, pword);
                    
                    stmt = con.createStatement();
                    rs = stmt.executeQuery("Select username from user Where email = '" +email+ "' And password = '" + password+ "'");
                    if (rs.next()) {
                        String username = rs.getString("username");
                        greet.setText("Hi, " +username+ "!");
                    }
                } catch (Exception e) {
                } 
        back.add(greet);  
        
        
        JLabel img = new JLabel(); 
        img.setBounds(180,230,150,150);
        try {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(dbUrl, uname, pword);
                    
                    stmt = con.createStatement();
                    rs = stmt.executeQuery("Select profImg from user Where email = '" +email+ "' And password = '" + password+ "'");
                    
                    byte[] image = null;
                    
                    if (rs.next()) {
                        image = rs.getBytes("profImg");
                        
                        Image pic = Toolkit.getDefaultToolkit().createImage(image);
                        ImageIcon icon = new ImageIcon(pic);
                        Image pic2 = icon.getImage();
                        Image temp = pic2.getScaledInstance(150,150,Image.SCALE_SMOOTH);
                        icon = new ImageIcon(temp);
                        img.setIcon(icon);
                        
                    }

                } catch (Exception e) {
                } 
        back.add(img);

        JLabel name = new JLabel ();
        name.setFont(new Font("Arial", Font.PLAIN, 30));
        name.setForeground(Color.BLACK); 
        name.setBounds(50,425,200,100);
        try {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(dbUrl, uname, pword);
                    
                    stmt = con.createStatement();
                    rs = stmt.executeQuery("Select username from user Where email = '" +email+ "' And password = '" + password+ "'");
                    if (rs.next()) {
                        String username = rs.getString("username");
                        name.setText(username);
                    }
                } catch (Exception e) {
                } 
        back.add(name);
 
        
        JLabel number = new JLabel ();
        number.setFont(new Font("Arial", Font.PLAIN, 30));
        number.setForeground(Color.BLACK); 
        number.setBounds(50,500,200,100);
        try {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(dbUrl, uname, pword);
                    
                    stmt = con.createStatement();
                    rs = stmt.executeQuery("Select phoneNo from user Where email = '" +email+ "' And password = '" + password+ "'");
                    if (rs.next()) {
                        String num = rs.getString("phoneNo");
                        number.setText(num);
                    }
                } catch (Exception e) {
                } 
        back.add(number);
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

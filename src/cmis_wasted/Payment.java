package cmis_wasted;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Payment {
    final String driver = "com.mysql.cj.jdbc.Driver";
    final String dbUrl = "jdbc:mysql://localhost:3306/wastedDB";
    
    String sql = ""; 
    String uname = "root";
    String pword = "";
    
    static Statement stmt = null;
    static ResultSet rs = null;
    
    JFrame frm, frm2, frm3;
    JLabel back, back2, back3;
    JPanel panelMain, panelMain2, panelMain3;
    
    String email;
    String password;
    
    public Payment(String email, String password){
        frm = new JFrame("Wasted");
        panelMain = new JPanel(); 
        
        String iconfilePath = this.getClass().getClassLoader().getResource("Payment1.png").getFile();
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
                
        icons(back, frm);
        showFrame(); 
    }
    
    public void checkout() {
        frm2 = new JFrame();
        panelMain2 = new JPanel(); 
        back2 = new JLabel();
        
        String iconfilePath = this.getClass().getClassLoader().getResource("Payment2.png").getFile();
        ImageIcon background = new ImageIcon(iconfilePath);
        Image img = background.getImage();
        Image temp = img.getScaledInstance(500,975,Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        back2 = new JLabel(background);
        back2.setLayout(null);
        back2.setBounds(0,0,500,975); 

        panelMain2.add(back2);
        
        JButton btnOut2 = new JButton();
        btnOut2.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){  
                frm2.dispose();
                checkout2(); 
            }  
        });
        btnOut2 .setBorderPainted(false);
        btnOut2.setFocusPainted(false);
        btnOut2.setContentAreaFilled(false);
        btnOut2.setBounds(20,760,450,50);
        back2.add(btnOut2);
        
        icons(back2, frm2);
        
        
        frm2.setResizable(false);
        frm2.setSize(500,1020);
        frm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frm2.setLocationRelativeTo(null);
        frm2.add(panelMain2);
        frm2.setVisible(true);
        
    }
    
     public void checkout2() {
        frm3 = new JFrame();
        panelMain3 = new JPanel(); 
        back3 = new JLabel();
        
        String iconfilePath = this.getClass().getClassLoader().getResource("Payment3.png").getFile();
        ImageIcon background = new ImageIcon(iconfilePath);
        Image img = background.getImage();
        Image temp = img.getScaledInstance(500,975,Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        back3 = new JLabel(background);
        back3.setLayout(null);
        back3.setBounds(0,0,500,975); 
        
        panelMain3.add(back3);
        
        icons(back3, frm3);
        
        frm3.setResizable(false);
        frm3.setSize(500,1020);
        frm3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frm3.setLocationRelativeTo(null);
        frm3.add(panelMain3);
        frm3.setVisible(true);
    }
    
    public void icons(JLabel background, JFrame frame) {
        //Checkout 
        JButton btnOut = new JButton();
        btnOut.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){  
                frm.dispose();
                checkout(); 
            }  
        });
        btnOut .setBorderPainted(false);
        btnOut.setFocusPainted(false);
        btnOut.setContentAreaFilled(false);
        btnOut.setBounds(20,725,450,50);
        
        back.add(btnOut);
 
        //Home
        JButton btnHome = new JButton();
        btnHome.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){  
                frame.dispose();
                new Home(email, password);  
            }  
        });
        btnHome .setBorderPainted(false);
        btnHome.setFocusPainted(false);
        btnHome .setContentAreaFilled(false);
        btnHome .setBounds(10,910,80,72);
        
        background.add(btnHome);
        
        //Wishlist
        JButton btnWish = new JButton();
        btnWish.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){  
                frame.dispose();
                new Wishlist(email, password);  
            }  
        });
        btnWish .setBorderPainted(false);
        btnWish .setFocusPainted(false);
        btnWish .setContentAreaFilled(false);
        btnWish .setBounds(100,910,80,72);
        
        background.add(btnWish);
        //Payment
        JButton btnPay = new JButton();
        btnPay.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){  
                frame.dispose();
                new Payment(email, password);  
            }  
        });
        btnPay.setBorderPainted(false);
        btnPay.setFocusPainted(false);
        btnPay.setContentAreaFilled(false);
        btnPay.setBounds(220,910,80,72);
        
        background.add(btnPay);
        //Messages
        JButton btnMsg= new JButton();
        btnMsg.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){  
                frame.dispose();
                new Messages(email, password);  
            }  
        });
        btnMsg.setBorderPainted(false);
        btnMsg.setFocusPainted(false);
        btnMsg.setContentAreaFilled(false);
        btnMsg.setBounds(320,910,80,72);
        
        background.add(btnMsg);
        //Profile
        JButton btnProf = new JButton();
        btnProf.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){  
                frame.dispose();
                new Profile(email, password);  
            }  
        });
        btnProf.setBorderPainted(false);
        btnProf.setFocusPainted(false);
        btnProf.setContentAreaFilled(false);
        btnProf.setBounds(400,910,80,72);
        
        background.add(btnProf);
        
        JButton btnRedirect = new JButton();
        btnRedirect.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){  
                frame.dispose();
                new Home(email, password);  
            }  
        });
        btnRedirect.setBorderPainted(false);
        btnRedirect.setFocusPainted(false);
        btnRedirect.setContentAreaFilled(false);
        btnRedirect.setBounds(5,20,50,50);
        
        background.add(btnRedirect);
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

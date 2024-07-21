package cmis_wasted;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Messages{
    final String driver = "com.mysql.cj.jdbc.Driver";
    final String dbUrl = "jdbc:mysql://localhost:3306/wastedDB";
    
    String sql = ""; 
    String uname = "root";
    String pword = "";
    
    static Statement stmt = null;
    static ResultSet rs = null;
    
    JFrame frm, frm2;
    JLabel back, back2;
    JPanel panelMain, panelMain2;
    
    String email;
    String password;
    
    public Messages(String email, String password){
        frm = new JFrame("Wasted");
        panelMain = new JPanel(); 
        
        String iconfilePath = this.getClass().getClassLoader().getResource("Messages1.png").getFile();
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
    
    public void icons(JLabel background, JFrame frame) {
        //Maria Message
        JButton btnMessage = new JButton();
        btnMessage .addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){  
                frm.dispose();
                message(); 
            }  
        });
        btnMessage  .setBorderPainted(false);
        btnMessage .setFocusPainted(false);
        btnMessage  .setContentAreaFilled(false);
        btnMessage .setBounds(15,220,500,100);
        
        back.add(btnMessage);
        
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
    
    
    public void message() {
        frm2 = new JFrame();
        panelMain2 = new JPanel(); 
        back2 = new JLabel();
        
        String iconfilePath = this.getClass().getClassLoader().getResource("Messages2.png").getFile();
        ImageIcon background = new ImageIcon(iconfilePath);
        Image img = background.getImage();
        Image temp = img.getScaledInstance(500,975,Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        back2 = new JLabel(background);
        back2.setLayout(null);
        back2.setBounds(0,0,500,975); 
        
        panelMain2.add(back2);
        
        icons(back2, frm2);
        
        frm2.setResizable(false);
        frm2.setSize(500,1020);
        frm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frm2.setLocationRelativeTo(null);
        frm2.add(panelMain2);
        frm2.setVisible(true);
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

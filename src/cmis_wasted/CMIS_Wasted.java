package cmis_wasted;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*; 

public class CMIS_Wasted implements ActionListener{

    JFrame frm;
    JPanel panelMain;
    JTextField tfUname;

    Connection conn = null;
    Statement stmt = null; 
    ResultSet rs = null;

    public CMIS_Wasted(){
        
        frm = new JFrame("Wasted");
        panelMain = new JPanel();
    
        welcome();
        showFrame();
    
    }
    
    public void welcome() {
        JButton btnLogo = new JButton(" ");
        btnLogo.addActionListener(this);
        btnLogo.setBorderPainted(false);
        btnLogo.setFocusPainted(false);
        btnLogo.setContentAreaFilled(false);
        btnLogo.setBounds(0, 0,500,975);
        
        String iconfilePath = this.getClass().getClassLoader().getResource("Logo.png").getFile();
        ImageIcon background = new ImageIcon(iconfilePath);
        Image img = background.getImage();
        Image temp = img.getScaledInstance(500,975,Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        
        JLabel back=new JLabel(background);
        back.setBounds(0,0,500,1020);
        back.setLayout(null);
        
        back.add(btnLogo);
        panelMain.add(back);
    }
    
    public void showFrame(){
        frm.setResizable(true);
        frm.setSize(500,1020);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frm.setLocationRelativeTo(null);
        frm.add(panelMain);
        frm.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new CMIS_Wasted();
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    String action = ae.getActionCommand();
        switch(action){
            case " ":
                new Login(); 
                frm.dispose(); 
                break;
            case "Login":
                new Login();
                frm.dispose();
                break;
            }
    }  
    
}

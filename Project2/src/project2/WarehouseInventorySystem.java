/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WarehouseInventorySystem{

    JFrame Maingui=new JFrame("MainPage System");
    JLabel title=new JLabel("Online Shopping/Management System");
    JLabel username=new JLabel("Username: ");
    JLabel password=new JLabel("Password");
    JLabel usertype=new JLabel("Identity");
    JTextField name=new JTextField();
    JTextField pwd=new JPasswordField();
    JComboBox box=new JComboBox(new String[]{"Administrator","Customer"});
    JButton login=new JButton("Login");
    JButton signUp=new JButton("SignUp");
    ImageIcon background=new ImageIcon("src/project2/Network-Inventory-Management.png");
    JLabel bgl=new JLabel(background);
    
    public void Maingui(){
        
        bgl.setSize(background.getIconWidth(),background.getIconHeight());
        Maingui.getLayeredPane().add(bgl,new Integer(Integer.MIN_VALUE));
        
        JPanel pan=(JPanel)Maingui.getContentPane();
        pan.setOpaque(false);
        pan.setLayout(null);
        
        pan.add(title);
        pan.add(login);
        pan.add(signUp);
        
        int frameWidth=background.getIconWidth();
        int frameHeight=background.getIconHeight();
        int buttonWidth=150;
        int buttonHeight=50;
        int buttonX=(frameWidth-buttonWidth)/2;
        int loginButton=(frameHeight-(2*buttonHeight+20))/2;
        int signUpButton=loginButton+buttonHeight+20;
        
        login.setBounds(buttonX,loginButton, buttonWidth, buttonHeight);
        signUp.setBounds(buttonX, signUpButton,buttonWidth, buttonHeight);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setBounds(100, 100, 800, 50);
        title.setForeground(Color.WHITE);
        Maingui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Maingui.setSize(background.getIconWidth(),background.getIconHeight());
        Maingui.setLocationRelativeTo(null);
        Maingui.setVisible(true);
        
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Maingui.dispose(); // Close the main GUI
                new Login().LoginGui(); // Open the login GUI
            }
        });
        
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Maingui.dispose(); // Close the main GUI
                new SignUp().SignUpGui(); // Open the sign-up GUI
            }
        });
    }
    
    public static void main(String[] args) {
        WarehouseInventorySystem wis=new WarehouseInventorySystem();
        wis.Maingui();
        
    }
}

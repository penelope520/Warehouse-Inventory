/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SignUp {
    JFrame SignUpgui=new JFrame("UserSignUp System");
    JLabel title=new JLabel("Online Shopping/Management System");
    JLabel username=new JLabel("Username: ");
    JLabel password=new JLabel("Password");
    JLabel ConformPW =new JLabel("Comfirm Password: ");
    JLabel usertype=new JLabel("Identity");
    JTextField name=new JTextField();
    JPasswordField pwd=new JPasswordField();
    JPasswordField cpwd=new JPasswordField();
    JComboBox box=new JComboBox(new String[]{"Administrator","Customer"});
    JButton signUp=new JButton("SignUp");
    JButton cancel=new JButton("Cancel");
    JLabel error = new JLabel("");
    ImageIcon background=new ImageIcon("src/project2/Network-Inventory-Management.png");
    JLabel bgl=new JLabel(background);
    
    public void SignUpGui(){
        bgl.setSize(background.getIconWidth(),background.getIconHeight());
        SignUpgui.getLayeredPane().add(bgl,new Integer(Integer.MIN_VALUE));
        
        JPanel pan=(JPanel)SignUpgui.getContentPane();
        pan.setOpaque(false);
        pan.setLayout(null);
        
        pan.add(title);
        pan.add(username);
        pan.add(name);
        pan.add(password);
        pan.add(pwd);
        pan.add(usertype);
        pan.add(signUp);
        pan.add(cancel);
        pan.add(ConformPW);
        pan.add(cpwd);
        pan.add(box);
        pan.add(error);
        
        int bgWidth = background.getIconWidth();
        int bgHeight = background.getIconHeight();
        
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setBounds(195, 100, 800, 100);
        title.setForeground(Color.WHITE);
        username.setBounds(bgWidth / 3 - 50, bgHeight / 2 - 90, 150, 30);
        name.setBounds(bgWidth / 3 + 90, bgHeight / 2 - 90, 270, 30);
        password.setBounds(bgWidth / 3 - 50, bgHeight / 2 - 40, 150, 30);
        pwd.setBounds(bgWidth / 3 + 90, bgHeight / 2 - 40, 270, 30);
        ConformPW.setBounds(bgWidth / 3 - 50, bgHeight / 2 + 10, 150, 30);
        cpwd.setBounds(bgWidth / 3 + 90, bgHeight / 2 + 10, 270, 30);
        error.setForeground(Color.RED);
        error.setBounds(bgWidth / 3 + 370, bgHeight / 2 + 10, 200, 30);
        usertype.setBounds(bgWidth / 3 - 50, bgHeight / 2 + 60, 150, 30);
        box.setBounds(bgWidth / 3 + 90, bgHeight / 2 + 60, 270, 30);
        signUp.setBounds(bgWidth / 2 - 120, bgHeight / 2 + 140, 100, 30);
        cancel.setBounds(bgWidth / 2 + 20, bgHeight / 2 + 140, 100, 30);
        
        new StartEvents(pwd, cpwd, error, name);
        
        SignUpgui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SignUpgui.setSize(background.getIconWidth(),background.getIconHeight());
        SignUpgui.setLocationRelativeTo(null);
        SignUpgui.setVisible(true);
    }
    
     public static void main(String[] args) {
        new SignUp().SignUpGui();
    }
}

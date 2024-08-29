/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    JFrame Logingui=new JFrame("Userlogin System");
    JLabel title=new JLabel("Online Shopping/Management System");
    JLabel username=new JLabel("Username: ");
    JLabel password=new JLabel("Password: ");
    JTextField name=new JTextField();
    JPasswordField pwd=new JPasswordField();
    JButton login=new JButton("Login");
    JButton signUp=new JButton("SignUp");
    JLabel error = new JLabel("");
    JButton cancel=new JButton("Cancel");
    ImageIcon background=new ImageIcon("src/project2/Network-Inventory-Management.png");
    JLabel bgl=new JLabel(background);
    
    
    public void LoginGui(){
        bgl.setSize(background.getIconWidth(),background.getIconHeight());
        Logingui.getLayeredPane().add(bgl,new Integer(Integer.MIN_VALUE));
        
        JPanel pan=(JPanel)Logingui.getContentPane();
        pan.setOpaque(false);
        pan.setLayout(null);
        
        pan.add(title);
        pan.add(username);
        pan.add(name);
        pan.add(password);
        pan.add(pwd);
        pan.add(login);
        pan.add(cancel);
        pan.add(error);
        
        int bgWidth = background.getIconWidth();
        int bgHeight = background.getIconHeight();
        
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setBounds(100, 100, 800, 50);
        title.setForeground(Color.WHITE);
        username.setBounds(bgWidth/3-50, bgHeight/2-70, 100, 30);
        username.setForeground(Color.WHITE);
        name.setBounds(bgWidth/3+90, bgHeight/2-70, 270, 30);
        password.setBounds(bgWidth/3-50, bgHeight/2-10, 100, 30);
        password.setForeground(Color.WHITE);
        pwd.setBounds(bgWidth/3+90, bgHeight/2-10, 270, 30);
        login.setBounds(bgWidth/2-120, bgHeight/2+70, 100, 30); 
        cancel.setBounds(bgWidth/2+20, bgHeight/2+70, 100, 30);
        Logingui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Logingui.setSize(background.getIconWidth(),background.getIconHeight());
        Logingui.setLocationRelativeTo(null);
        Logingui.setVisible(true);
        
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Logingui.dispose();
                new WarehouseInventorySystem().Maingui(); // Reopen the main GUI
            }
        });
        
        login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String username=name.getText();
                String paassword=new String(pwd.getPassword());
                
                User user=userService.verify(username,password);
                if(user !=null){
                    if(user instanceof Admin){
                        //Admin
                    }else
                        //Customer
                }else
                    error.setText("Invalid username or password");
            }
        });
    }
}

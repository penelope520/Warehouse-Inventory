/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

import javax.swing.*;

public class Admin extends User{
    public Admin(String username, String password) {
        super(username, password);
    }
    
    public void show(){
        JFrame adminFrame = new JFrame("Admin Dashboard");
        JLabel label = new JLabel("Welcome, Admin!");
        adminFrame.add(label);

        adminFrame.setSize(400, 200);
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setVisible(true);
    }
}

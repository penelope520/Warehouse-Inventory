/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

import javax.swing.*;

public class Customer extends User{
    public Customer(String username, String password) {
        super(username, password);
    }
    
    public void show(){
        JFrame customerFrame = new JFrame("Customer Dashboard");
        JLabel label = new JLabel("Welcome, Customer!");
        customerFrame.add(label);

        customerFrame.setSize(400, 200);
        customerFrame.setLocationRelativeTo(null);
        customerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customerFrame.setVisible(true);
    }
}

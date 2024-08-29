/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class StartEvents {
    private JPasswordField pwd;
    private JPasswordField cpwd;
    private JLabel error;
    private JTextField username;
    
    public StartEvents(JPasswordField pwd, JPasswordField cpwd, JLabel error, JTextField username) {
        this.pwd = pwd;
        this.cpwd = cpwd;
        this.error = error;
        this.username = username;

        addPasswordListener();
    }
    
    private void addPasswordListener() {
        KeyAdapter keyAdapter = new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                validatePasswords();
            }
        };
        
        pwd.addKeyListener(keyAdapter);
        cpwd.addKeyListener(keyAdapter);
        
        FocusAdapter focusAdapter = new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                if (e.getSource() == pwd || e.getSource() == cpwd) {
                    validatePasswords();
                }
            }
        };
        pwd.addFocusListener(focusAdapter);
        cpwd.addFocusListener(focusAdapter);

    }

    private void validatePasswords() {
        String password = new String(pwd.getPassword());
        String confirmPassword = new String(cpwd.getPassword());
        
        if (password.isEmpty() || confirmPassword.isEmpty()) {
            error.setText("Please input");
        } else if (!isPasswordValid(password)) {
            error.setText("Password must be at least 8 characters and include letters, digits, and symbols.");
            positionErrorLabel(pwd);
        } else if (!password.equals(confirmPassword)) {
            error.setText("Wrong input");
            positionErrorLabel(cpwd);
        }
    }
    
    private boolean isPasswordValid(String password) {
        return password.length() >= 8 && 
               password.matches(".*[a-zA-Z].*") && 
               password.matches(".*\\d.*") && 
               password.matches(".*[^a-zA-Z0-9].*");
    }
    
    private void positionErrorLabel(JComponent relatedComponent) {
        int x = relatedComponent.getX() + relatedComponent.getWidth() + 10; 
        int y = relatedComponent.getY();
        error.setBounds(x, y, 300, 30); 
    }
}

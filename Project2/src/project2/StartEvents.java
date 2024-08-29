/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StartEvents {
    private JPasswordField pwd;
    private JPasswordField cpwd;
    private JLabel errorLabel;
    private JTextField usernameField;
    
    public StartEvents (JPasswordField pwd, JPasswordField cpwd, JLabel errorLabel, JTextField usernameField) {
        this.pwd = pwd;
        this.cpwd = cpwd;
        this.errorLabel = errorLabel;
        this.usernameField = usernameField;

        addPasswordListener();
    }
    
     private void addPasswordListener() {
        cpwd.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String passwordText = new String(pwd.getPassword());
                String confirmPasswordText = new String(cpwd.getPassword());

                if (passwordText.isEmpty() || confirmPasswordText.isEmpty()) {
                    errorLabel.setText("");
                } else if (!passwordText.equals(confirmPasswordText)) {
                    errorLabel.setText("Passwords do not match!");
                } else
                    errorLabel.setText("");
            }
        });
    }
}

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

    JFrame Maingui=new JFrame("Userlogin System");
    JLabel title=new JLabel("Online Shopping/Management System");
    JLabel username=new JLabel("Username: ");
    JLabel password=new JLabel("Password");
    JLabel usertype=new JLabel("Identity");
    JTextField name=new JTextField();
    JTextField pwd=new JPasswordField();
    JComboBox box=new JComboBox(new String[]{"Administrator","Customer"});
    JButton login=new JButton("Login");
    JButton signUp=new JButton("SignUp");
    
    public void Maingui(){
        Maingui.setBounds(450, 200, 550, 350);
        Maingui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Maingui.setLayout(new GridLayout(6,2,10,10));
        
        Maingui.add(title);
        Maingui.add(login);
        Maingui.add(signUp);
        
        title.setFont(new Font("Arial", Font.BOLD, 16));
        Maingui.add(new JLabel(""));
        
        
        Maingui.setLocationRelativeTo(null);
        Maingui.setVisible(true);
    }
    
    public static void main(String[] args) {
        WarehouseInventorySystem wis=new WarehouseInventorySystem();
        wis.Maingui();
        
    }
    class Background extends JPanel{
        private Image backgroundImage;
        
        protected void paintComonent(Graphics g){
            backgroundImage = new ImageIcon("Network-Inventory-Management.png").getImage();
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    
    }
}

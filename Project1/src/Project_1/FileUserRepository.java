/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUserRepository implements UserRepository{
    private static final String FILE_PATH= "./resources/users.txt";
    
    @Override
    public List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String username = parts[0];
                String password = parts[1];
                String role = parts[2];
                User user = createUser(username, password, role);
                users.add(user);
            }
        } catch (IOException e) {
            System.out.println("Failed to load users: " + e.getMessage());
        }
        return users;
    }
    
    @Override
    public void saveUsers(List<User> users) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (User user : users) {
                String role = user instanceof Admin ? "Admin" : "Customer";
                pw.println(user.getUsername() + "," + user.getPassword() + "," + role);
            }
        } catch (IOException e) {
            System.out.println("Failed to save users: " + e.getMessage());
        }
    }
    
    private User createUser(String username, String password, String role) {
        Inventory inventory = new Inventory(new FileProductRepository());
        if (role.equals("Admin")) {
            return new Admin(username, password, inventory);
        } else 
            return new Customer(username, password, inventory);
    }
}

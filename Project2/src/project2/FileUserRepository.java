/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

import java.io.*;

public class FileUserRepository {
    private static final String FILE_PATH = "./resources/users.txt";
    private UserService userservice;

    public FileUserRepository(UserService userservice) {
        this.userservice = userservice;
    }

    public void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String username = parts[0];
                String password = parts[1];
                String role = parts[2];

                User user;
                if (role.equals("Administrator")) {
                    user = new Admin(username, password);
                } else {
                    user = new Customer(username, password);
                }
                userservice.getUsers().add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveUsers(User user) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            pw.println(user.getUsername() + "," + user.getPassword() + "," +
                    (user instanceof Admin ? "Administrator" : "Customer"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

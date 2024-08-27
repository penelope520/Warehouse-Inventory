/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_1;

import java.util.List;

public class UserService {
    private List<User> users;
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.users = userRepository.loadUsers();
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public User verify(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.verify(password)) {
                return user;
            }
        }
        return null;
    }

    public void registerUser(User user) {
        users.add(user);
        userRepository.saveUsers(users);
    }

    public List<User> getAllUsers() {
        return users;
    }
}

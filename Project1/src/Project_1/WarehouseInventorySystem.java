/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_1;

import java.util.*;

public class WarehouseInventorySystem {

    public static void main(String[] args){
        UserRepository userRepository = new FileUserRepository();
        UserService userService = new UserService(userRepository);
    
        Scanner scanner=new Scanner(System.in);
        
        while(true){
            System.out.println("Welcome Warehouse Online Shopping/Management System");
            System.out.println("1.Login ");
            System.out.println("2.SignUp");
            System.out.println("Please Select a option or press any key to exit the program ");
            
            try{
                int choice=scanner.nextInt();
            scanner.nextLine();
                switch (choice) {
                    case 1:
                        login(userService, scanner);
                        break;
                    case 2:
                        register(userService, scanner);
                        break;
                    default:
                        System.out.println("System close");
                        System.exit(0);
                }
            }catch(Exception e){
                System.out.println("Invalid input. System close");
                System.exit(0);
            }     
        }
    }
    
    private static void login(UserService userService, Scanner scanner){
        System.out.print("Enter username: ");
        String username=scanner.nextLine();
        System.out.print("Enter password: ");
        String password=scanner.nextLine();
        
        User user= userService.verify(username, password);
        if(user !=null){
            System.out.println("Login successful!");
            user.displayMenu();
        }else{
            System.out.println("Wrong username or password!");
        }
    }
    
    private static void register(UserService userService, Scanner scanner){
        System.out.print("Enter Username: ");
        String username=scanner.nextLine();
        System.out.print("Enter Password: ");
        String password=scanner.nextLine();
        System.out.print("Is this an administrator T(true）or any key mean false: ");
        String isAdmin=scanner.nextLine();
        
        Inventory inventory=new Inventory(new FileProductRepository());
        
        User user;
        if(isAdmin.equalsIgnoreCase("T")){
            user=new Admin(username, password, inventory);
        }else
            user=new Customer(username,password, inventory);
        
        userService.registerUser(user);
        System.out.println("Registration successful, please log in!");
    }
}

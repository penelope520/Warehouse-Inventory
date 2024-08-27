/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package Project_1;

import java.util.*;

public class Admin extends User{
    private Inventory inventory;
    
    public Admin(String username, String password, Inventory inventory){
        super(username, password);
        this.inventory=inventory;
    }
    
    @Override
    public void displayMenu(){
        Scanner scanner=new Scanner(System.in);
        OUTER:
        while (true) {
            System.out.println("Administrator System");
            inventory.displayProductsforAdmin();
            System.out.println("1.Modify product");
            System.out.println("2.Add product");
            System.out.println("3.Exit");
            System.out.println("Please Select: ");
            try {
                int choice=scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        modifyProduct();
                        break;
                    case 2:
                        addProduct();
                        break;
                    case 3:
                        break OUTER;
                    default:
                        System.out.println("Invalid input! Please select a valid option (1, 2, or 3).");
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid input! Please enter a number (1, 2, or 3).");
                scanner.nextLine();
            }
        }
    }
    
    public void modifyProduct(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Please enter the product id to modify:");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid product number.");
            scanner.next();
        }
        int id=scanner.nextInt();
        scanner.nextLine();
        Product product=inventory.getProductById(id);
        
        if(product !=null ){
            System.out.println("1. Remove Product");
            System.out.println("2. Price Modify");
            System.out.println("3. Add products");
            System.out.println("Please select: ");
            int choice=scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    while(true){
                        System.out.println("Enter quantity to remove: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Please enter a valid quantity.");
                            scanner.next();
                        }
                        int quantityToRemove = scanner.nextInt();
                        scanner.nextLine();
                        if (quantityToRemove > 0 && quantityToRemove <= product.getQuantity()) {
                            product.setQuantity(product.getQuantity() - quantityToRemove);
                            inventory.updateProduct(product);
                            System.out.println("Quantity removed successfully. Remaining quantity: " + product.getQuantity());
                            break;
                        }else if(quantityToRemove > product.getQuantity()){
                            System.out.println("Invalid quantity. Available quantity: " + product.getQuantity());
                        }else
                            return;
                    }   break;
                case 2:
                    System.out.println("Enter new price： ");
                    double priceChange=scanner.nextDouble();
                    scanner.nextLine();
                    product.setPrice(priceChange);
                    inventory.updateProduct(product);
                    System.out.println("Price updated to $" + priceChange);
                    break;
                case 3:
                    System.out.println("Enter quantity to add： ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Please enter a valid quantity.");
                        scanner.next();
                    }       int quantityIncrease=scanner.nextInt();
                    scanner.nextLine();
                    product.setQuantity(product.getQuantity()+quantityIncrease);
                    inventory.updateProduct(product);
                    System.out.println("Quantity updated. New quantity: " + product.getQuantity());
                    break;
                default:
                    break;
            }
        }else
            System.out.println("Product ID was not found.");
    }
    
    public void addProduct(){
        Scanner scanner=new Scanner(System.in);
        int id;
        
        while(true){
            System.out.println("Enter Item Id: ");
            id=scanner.nextInt();
            scanner.nextLine();
            if(inventory.getProductById(id)!=null){
                System.out.println("Product ID already exists. Please enter a different ID.");
            }else
                break;
        }
        
        
        System.out.println("Enter Item Name: ");
        String name=scanner.nextLine();
        
        System.out.println("Enter Item Price: ");
        double price=scanner.nextDouble();
        
        System.out.println("Enter Item Quantity: ");
        int quantity=scanner.nextInt();
        scanner.nextLine();
        
        Product product=new Product(id, name, price, quantity);
        inventory.addProduct(product);
        System.out.println("Item added successfully.");
    }
}

/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package Project_1;

import java.util.*;

public class Customer extends User{
    private Inventory inventory;
    private Cart cart;
    
    public Customer(String username, String password, Inventory inventory){
        super(username,password);
        this.inventory=inventory;
        this.cart=new Cart();
    }
    
    @Override
    public void displayMenu(){
        Scanner scanner=new Scanner(System.in);
        OUTER:
        while (true) {
            System.out.println("Customer System");
            inventory.displayProductsforCustomer();
            System.out.println("1. Purchase Items");
            System.out.println("2. View Cart");
            System.out.println("3. Exit");
            System.out.print("Please Select: ");
            int choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    purchaseItems(scanner);
                    break;
                case 2:
                    viewCart(scanner);
                    break;
                case 3:
                    break OUTER;
                default:
                    break;
            }
        }
    }
    
    private void purchaseItems(Scanner scanner){
        System.out.print("Enter Item ID you wish to buy: ");
        while(!scanner.hasNextInt()){
            System.out.println("Please enter a valid number.");
            scanner.next();
        }
        String input=scanner.nextLine();
        
        Product product=getProductById(input);
        if(product !=null){
            while(true){
                System.out.println("1. Buy Item");
                System.out.println("2. Add to Cart");
                System.out.println("3. Cancel");
                System.out.print("Please select: ");
                
                int action=scanner.nextInt();
                scanner.nextLine();
                
                switch (action) {
                    case 1:
                        handlePurchase(product, scanner);
                        break;
                    case 2:
                        handleAddToCart(product, scanner);
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid item id. Please try again");
                        break;
                }
            }
        }else
            System.out.println("Invalid item id. Please try again");
    }
    
        private Product getProductById(String input){
        try{
            int id=Integer.parseInt(input);
            return inventory.getProductById(id);
        }catch(NumberFormatException e){
            System.out.println("Invalid input. Please enter a valid item id.");
            return null;
        }
    }
        
    private void handlePurchase(Product product, Scanner scanner){
        
        while(true){
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            
            if(quantity<=0){
                System.out.println("Purchase quantity cannot be zero or negative. Please enter a valid quantity.");
            }else if (quantity <= product.getQuantity()){
                double totalPrice = product.getPrice() * quantity;
                System.out.println("Total Proice: "+totalPrice);
                System.out.println("1. Purchase");
                System.out.println("2. Cancel");
                System.out.print("Please select: ");
                int choice=scanner.nextInt();
                scanner.nextLine();
                
                if(choice==1){
                    product.setQuantity(product.getQuantity() - quantity);
                    System.out.println("Purchase successful");
                    inventory.saveProducts();
                }
                break;
            }else
                System.out.println("Not enough inventory. Available quantity: " + product.getQuantity());
        }
        
    }
        
    private void handleAddToCart(Product product, Scanner scanner){
        while(true){
            System.out.print("Enter quantity to add to cart: ");
            int quantity = scanner.nextInt();
            if (quantity > 0 && quantity <= product.getQuantity()) {
                cart.addProduct(product, quantity);
                System.out.println("Item added to cart.");
                return;
            }else
                System.out.println("Invalid quantity. Available quantity: " + product.getQuantity());
        }
    }
    
    private void viewCart(Scanner scanner){
        OUTER:
        while (true) {
            cart.displayCart();
            System.out.println("1. Purchase Cart Items");
            System.out.println("2. Remove Item from Cart");
            System.out.println("3. Return to Main Menu");
            int choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    purchaseCartItems(scanner);
                    break;
                case 2:
                    removeItemFromCart(scanner);
                    break;
                case 3:
                    break OUTER;
                default:
                    System.out.println("Invalid option. Please select 1, 2, or 3.");
                    break;
            }
        }
    }
    
    private void purchaseCartItems(Scanner scanner){
        double total=cart.getTotal();
        System.out.println("Total Cart Price: "+total);
        System.out.println("1. Confirm Purchase");
        System.out.println("2. Cancel");
        
        int action=scanner.nextInt();
        scanner.nextLine();
        
        if(action==1){
            for (Map.Entry<Product, Integer> entry : cart.getItems()) {
                Product product = entry.getKey();
                int quantity = entry.getValue();
                if (product.getQuantity() >= quantity) {
                    product.setQuantity(product.getQuantity() - quantity);
                    inventory.updateProduct(product);
                }
            }
            cart.clear();
            System.out.println("Purchase successful! Total amount: " + total);
        }else
            System.out.println("Purchase canceled.");
    }
    
    private void removeItemFromCart(Scanner scanner){
        if (cart.getItems().isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        
        while (true) {
            System.out.print("Enter the item ID to remove from cart: ");
            String input = scanner.nextLine();
            if (!isNumeric(input)) {
                System.out.println("Please enter a valid numeric item ID.");
                continue;
            }
            
            int id = Integer.parseInt(input);
            Product productToRemove = cart.getProductById(id);
            
            if (productToRemove == null) {
                System.out.println("Item ID not found in cart. Please try again.");
                continue;
            }
            int currentQuantity = cart.getQuantityById(id);
            
            while (true) {
                System.out.print("Enter the quantity to remove: ");
                String quantityInput = scanner.nextLine();
                
                if (!isNumeric(quantityInput)) {
                    System.out.println("Please enter a valid quantity.");
                    continue;
                }
                
                int quantityToRemove = Integer.parseInt(quantityInput);
                
                if (quantityToRemove <= 0) {
                    System.out.println("Quantity must be greater than zero. Please try again.");
                } else if (quantityToRemove > currentQuantity) {
                    System.out.println("Invalid quantity. Available quantity in cart: " + currentQuantity);
                } else {
                    cart.removeProductQuantity(id, quantityToRemove);
                    System.out.println("Item removed successfully.");
                    break;
                }
            }
            break;
        }
    }
    private boolean isNumeric(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
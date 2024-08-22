/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_1;

import java.util.*;

public class Cart {
    private Map<Product, Integer> items=new HashMap();
    
    public void addProduct(Product product, int quantity){
        items.merge(product, quantity, Integer ::sum);
    }
    
    public void removeProduct(int id){
        items.entrySet().removeIf(entry->entry.getKey().getId()==id);
    }
    
    public void displayCart(){
        if(items.isEmpty()){
            System.out.println("Your cart is empty.");
            return;
        }
        
        System.out.println("Cart Items: ");
        double total=0;
        for(Map.Entry<Product, Integer> entry : items.entrySet()){
            Product product=entry.getKey();
            int quantity=entry.getValue();
            System.out.println("ID: " + product.getId() + " | Item: " + product.getName() + " | Price: $" + product.getPrice() + "(each) | Quantity: " + quantity);
            total += product.getPrice() * quantity;
        }
        System.out.println("Total: "+total);
    }
    
    public Product getProductById(int id) {
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            if (entry.getKey().getId() == id) {
                return entry.getKey();
            }
        }
        return null;
    }
    
    public int getQuantityById(int id) {
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            if (entry.getKey().getId() == id) {
                return entry.getValue();
            }
        }
        return 0;
    }
    
     public void removeProductQuantity(int id, int quantity) {
        Product productToRemove = getProductById(id);
        if (productToRemove != null) {
            int currentQuantity = items.get(productToRemove);
            if (currentQuantity > quantity) {
                items.put(productToRemove, currentQuantity - quantity);
            } else {
                items.remove(productToRemove);
            }
        }
    }
     
    public double getTotal(){
        return items.entrySet().stream().mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue()).sum();
    }
    
    public void clear(){
        items.clear();
    }
    
    public Set<Map.Entry<Product, Integer>> getItems() {
        return items.entrySet();
    }
}

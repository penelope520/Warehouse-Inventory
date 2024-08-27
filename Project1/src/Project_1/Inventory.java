/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_1;
import java.io.*;
import java.util.*;
/**
 *
 * @author Administrator
 */
public class Inventory {
    private Map <Integer, Product> products=new HashMap<>();
    private ProductRepository productRepository;
    
    public Inventory(ProductRepository productRepository){
        this.productRepository=productRepository;
        loadProducts();
    }
    
    public void loadProducts(){
        List<Product> loadedProducts=productRepository.loadProducts();
        for(Product product : loadedProducts){
            products.put(product.getId(), product);
        }
    }
    
    public void saveProducts(){
        productRepository.saveProducts(new ArrayList<>(products.values()));
    }
    
    public void displayProductsforCustomer(){
        System.out.println("Product List");
        for(Product product : products.values()){
            System.out.println("ID: " + product.getId() + " | Item: " + product.getName() + " | Price: $" + product.getPrice());
        }
    }
    
    public void displayProductsforAdmin(){
        System.out.println("Product List");
        for(Product product : products.values()){
            System.out.println(product);
        }
    }
    
    
    public void removeProduct(int id){
        products.remove(id);
        saveProducts();
    }
    
    public void updateProduct(Product product){
        products.put(product.getId(),product);
        saveProducts();
    }
    
    public void addProduct(Product product){
        products.put(product.getId(),product);
        saveProducts();
    }
    
    public Product getProductById(int id){
        return products.get(id);
    }
}

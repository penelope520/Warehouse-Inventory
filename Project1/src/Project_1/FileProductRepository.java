/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileProductRepository implements ProductRepository {
    private static final String FILE_PART="./resources/products.txt";
    
    @Override
    public List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PART))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                int quantity = Integer.parseInt(parts[3]);
                products.add(new Product(id, name, price, quantity));
            }
        } catch (IOException e) {
            System.out.println("Failed to load products: " + e.getMessage());
        }
        return products;
    }

    @Override
    public void saveProducts(List<Product> products) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PART))) {
            for (Product product : products) {
                pw.println(product.getId() + "," + product.getName() + "," + product.getPrice() + "," + product.getQuantity());
            }
        }catch (IOException e) {
            System.out.println("Failed to save products: " + e.getMessage());
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_1;

import java.util.List;

public interface ProductRepository {
    List<Product> loadProducts();
    void saveProducts(List<Product>products);
}

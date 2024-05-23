package org.example.ports.in;

import org.example.domain.Product;

import java.util.List;

public interface ProductServicePort {
    void createProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void updateProduct(Product product);
    void deleteProduct(Long id);
}
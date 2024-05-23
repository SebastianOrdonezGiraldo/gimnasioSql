package org.example.ports.out;

import org.example.domain.Product;

import java.util.List;

public interface ProductRepositoryPort {
    void save(Product product);
    List<Product> findAll();
    Product findById(Long id);
    void update(Product product);
    void delete(Long id);
}
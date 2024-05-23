package org.example.application;

import org.example.domain.Product;
import org.example.ports.in.ProductServicePort;
import org.example.ports.out.ProductRepositoryPort;

import java.util.List;

public class ProductServiceImpl implements ProductServicePort {

    private final ProductRepositoryPort productRepository;

    public ProductServiceImpl(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.update(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.delete(id);
    }
}
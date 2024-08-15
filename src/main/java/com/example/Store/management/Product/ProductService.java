package com.example.Store.management.Product;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}

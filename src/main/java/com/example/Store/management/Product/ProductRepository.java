package com.example.Store.management.Product;


import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface ProductRepository extends CrudRepository<Product, Long> {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int productId);
    List<Product> getAllProducts();
    Product getProduct(int productId);
}

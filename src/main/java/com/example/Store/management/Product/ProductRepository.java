package com.example.Store.management.Product;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    void addProduct(Product product);
//    void updateProduct(Product product);
//    void deleteProduct(int productId);
//    List<Product> getAllProducts();
//    Product getProduct(int productId);
}

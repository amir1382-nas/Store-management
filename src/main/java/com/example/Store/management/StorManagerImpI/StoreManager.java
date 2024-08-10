package com.example.Store.management.StorManagerImpI;

import com.example.Store.management.Product.Product;

public interface StoreManager {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int productId);
    Product getProduct(int productId);
}

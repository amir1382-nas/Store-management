package com.example.Store.management.StorManagerImpI;

import com.example.Store.management.Product.Product;

import java.util.HashMap;
import java.util.Map;

public class StoreManagerImpI implements StoreManager {
    private Map<Integer, Product> products = new HashMap<>();


    @Override
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void updateProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void deleteProduct(int productId) {
        products.remove(productId);
    }

    @Override
    public Product getProduct(int productId) {
        return products.get(productId);
    }
}

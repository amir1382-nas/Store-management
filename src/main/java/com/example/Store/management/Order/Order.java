package com.example.Store.management.Order;

import com.example.Store.management.Product.Product;

import java.util.List;

public class Order {
    private int id;
    private int customerId;
    private List<Product> products;

    // Constructor, getters, and setters
    public Order(int id, int customerId, List<Product> products) {
        this.id = id;
        this.customerId = customerId;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

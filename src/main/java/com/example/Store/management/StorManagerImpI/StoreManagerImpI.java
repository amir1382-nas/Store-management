package com.example.Store.management.StorManagerImpI;

import com.example.Store.management.Customer.Customer;
import com.example.Store.management.Product.Product;
import com.example.Store.management.Order.Order;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class StoreManagerImpI implements StoreManager {
    private Map<Integer, Product> products = new HashMap<>();
    private Map<Integer, Customer> customers = new HashMap<>();
    private Map<Integer, Order> orders = new HashMap<>();


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
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getProduct(int productId) {
        return null;
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        customers.remove(customerId);
    }

    @Override
    public Customer getCustomer(int customerId) {
        return customers.get(customerId);
    }

    @Override
    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }

    @Override
    public void updateOrder(Order order) {
        orders.put(order.getId(), order);
    }

    @Override
    public void deleteOrder(int orderId) {
        orders.remove(orderId);
    }

    @Override
    public Order getOrder(int orderId) {
        return orders.get(orderId);
    }
}

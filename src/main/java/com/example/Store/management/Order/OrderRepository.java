package com.example.Store.management.Order;


import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    void addOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(int orderId);
    Order getOrder(int orderId);
}
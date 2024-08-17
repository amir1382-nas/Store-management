package com.example.Store.management.Order;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface OrderRepository extends JpaRepository<Order, Long> {
//    void addOrder(Order order);
//    void updateOrder(Order order);
//    void deleteOrder(Long orderId);
//
//    Order findById(Long id);

}
package com.example.Store.management.Order;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface OrderRepository extends JpaRepository<Order, Long> {
}
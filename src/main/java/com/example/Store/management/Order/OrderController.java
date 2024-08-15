package com.example.Store.management.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // دریافت لیست همه سفارشات
    @GetMapping
    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    // ایجاد یک سفارش جدید
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order savedOrder = orderRepository.save(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    // دریافت یک سفارش با ID مشخص
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> order = orderRepository.findById(Math.toIntExact(id));
        return order.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // به‌روزرسانی یک سفارش موجود
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        Optional<Order> orderOptional = orderRepository.findById(Math.toIntExact(id));
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setCustomerId(orderDetails.getCustomerId());
            order.setProducts(orderDetails.getProducts()); // در دیتابیس ذخیره نمی‌شود
            Order updatedOrder = orderRepository.save(order);
            return ResponseEntity.ok(updatedOrder);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // حذف یک سفارش
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        if (orderRepository.existsById(Math.toIntExact(id))) {
            orderRepository.deleteById(Math.toIntExact(id));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

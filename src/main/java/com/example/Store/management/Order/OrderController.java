package com.example.Store.management.Order;

import com.example.Store.management.CreateOrderRequest;
import com.example.Store.management.CreateOrderResponse;
import com.example.Store.management.Product.Product;
import com.example.Store.management.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders/1")
public class OrderController {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    // Get a list of all orders
    @GetMapping("/All-order")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Create a new order
    @PostMapping
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequest request) {
        Order order = new Order();
        order.setCustomerId(request.getCustomerId());

        // Fetch products by their IDs
        List<Product> products = productRepository.findAllById(request.getProductIds());
        order.setProducts(products);

        Order savedOrder = orderRepository.save(order);

        CreateOrderResponse response = new CreateOrderResponse(
                savedOrder.getId(),
                "Order created successfully"
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Receive an order with a specified ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update an existing order
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody UpdateOrderRequest request) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setCustomerId(request.getCustomerId());

            // Fetch products by their IDs
            List<Product> products = productRepository.findAllById(request.getProductIds());
            order.setProducts(products);

            Order updatedOrder = orderRepository.save(order);
            return ResponseEntity.ok(updatedOrder);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete an order
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

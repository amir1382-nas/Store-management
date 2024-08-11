package com.example.Store.management;

import com.example.Store.management.Customer.Customer;
import com.example.Store.management.Order.Order;
import com.example.Store.management.Product.Product;
import com.example.Store.management.StorManagerImpI.StoreManagerImpI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StoreManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreManagementApplication.class, args);
		StoreManagerImpI storeManagerImpI = new StoreManagerImpI();


		// Add products
		Product product1 = new Product(1, "Laptop", 1600);
		Product product2 = new Product(2, "phone", 900);
		storeManagerImpI.addProduct(product1);
		storeManagerImpI.addProduct(product2);

		// Adding customers
		Customer customer1 = new Customer(1, "John Doe", "john@example.com");
		Customer customer2 = new Customer(2, "Jane Smith", "jane@example.com");
		storeManagerImpI.addCustomer(customer1);
		storeManagerImpI.addCustomer(customer2);

		// Adding orders
		List<Product> order1Products = new ArrayList<>();
		order1Products.add(product1);
		Order order1 = new Order(1, customer1.getId(), order1Products);
		storeManagerImpI.addOrder(order1);

		// Updating a product
		product1.setPrice(1400.00);
		storeManagerImpI.updateProduct(product1);

		// Deleting a product
		storeManagerImpI.deleteProduct(2);

		// Displaying all products
		Product product = storeManagerImpI.getProduct(1);
		if (product != null) {
			System.out.println("Product: " + product.getName() + " - " + product.getPrice());
		} else {
			System.out.println("Product not found.");
		}
		}
	}

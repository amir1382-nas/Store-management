package com.example.Store.management;


import com.example.Store.management.Customer.Customer;
import com.example.Store.management.Customer.CustomerRepository;
import com.example.Store.management.Order.Order;
import com.example.Store.management.Order.OrderRepository;
import com.example.Store.management.Product.Product;
import com.example.Store.management.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class StoreManagementApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(StoreManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// ایجاد و ذخیره محصولات
		Product product1 = new Product(null, "Laptop", 1200.0);

		productRepository.saveAll(Arrays.asList(product1));

		// ایجاد و ذخیره مشتری
		Customer customer = new Customer(null, "John Doe", "john.doe@example.com");
		customerRepository.save(customer);

		// ایجاد و ذخیره سفارش با استفاده از شناسه‌های محصولات و مشتری
		Order order = new Order(null, customer.getId(), Arrays.asList(product1.getId()));
		orderRepository.save(order);

		// خواندن و نمایش اطلاعات سفارش‌ها
		System.out.println("Orders in the database:");
		orderRepository.findAll().forEach(System.out::println);

		// بروز رسانی اطلاعات یک محصول
		product1.setPrice(1100.0);
		productRepository.save(product1);

		// حذف یک محصول
		productRepository.delete(product1);

		// خواندن و نمایش اطلاعات محصولات باقی‌مانده
		System.out.println("Products in the database:");
		productRepository.findAll().forEach(System.out::println);
	}
}
//import com.example.Store.management.Product.Product;
//import com.example.Store.management.Product.ProductService;
//import jakarta.annotation.PostConstruct;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class StoreManagementApplication {
//	private final ProductService productService;
//
//	public StoreManagementApplication(ProductService productService) {
//		this.productService = productService;
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(StoreManagementApplication.class, args);
//
//
//	}
//	@PostConstruct // بخونم دربارش
//	public void init() {
//		// Add a new product
//		Product product = new Product();
//		product.setName("Sample Product");
//		product.setPrice(29.99);
//
//		Product savedProduct = productService.saveProduct(product);
//		System.out.println("Product added: " + savedProduct.getName() + " with ID: " + savedProduct.getId());
//
//
//
//		// Add products
////		Product product1 = new Product( "Laptop", 1600);
////		Product product2 = new Product( "phone", 900);
////		storeManagerImpI.addProduct(product1);
////		storeManagerImpI.addProduct(product2);
//
////		// Adding customers
////		Customer customer = new Customer( "John Doe", "john@example.com");
////		savedProduct.addCustomer(customer);
//
////
////		// Adding orders
////		List<Product> order1Products = new ArrayList<>();
////		order1Products.add(product1);
////		Order order1 = new Order( 2, 1);
////		storeManagerImpI.addOrder(order1);
////
////		// Updating a product
////		product1.setPrice(1400.00);
////		storeManagerImpI.updateProduct(product1);
////
////		// Deleting a product
////		storeManagerImpI.deleteProduct(2);
////
////		// Displaying all products
////		Product product = storeManagerImpI.getProduct(1);
////		if (product != null) {
////			System.out.println("Product: " + product.getName() + " - " + product.getPrice());
////		} else {
////			System.out.println("Product not found.");
////		}
//
//	}
//	}

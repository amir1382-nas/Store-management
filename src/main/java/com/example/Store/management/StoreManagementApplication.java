package com.example.Store.management;

import com.example.Store.management.Customer.Customer;
import com.example.Store.management.Product.Product;
import com.example.Store.management.Product.ProductService;
import com.example.Store.management.StorManagerImpI.StoreManager;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreManagementApplication {
	private final ProductService productService;

	public StoreManagementApplication(ProductService productService) {
		this.productService = productService;
	}

	public static void main(String[] args) {
		SpringApplication.run(StoreManagementApplication.class, args);


	}
	@PostConstruct // بخونم دربارش
	public void init() {
		// Add a new product
		Product product = new Product();
		product.setName("Sample Product");
		product.setPrice(29.99);

		Product savedProduct = productService.saveProduct(product);
		System.out.println("Product added: " + savedProduct.getName() + " with ID: " + savedProduct.getId());



		// Add products
//		Product product1 = new Product( "Laptop", 1600);
//		Product product2 = new Product( "phone", 900);
//		storeManagerImpI.addProduct(product1);
//		storeManagerImpI.addProduct(product2);

//		// Adding customers
//		Customer customer = new Customer( "John Doe", "john@example.com");
//		savedProduct.addCustomer(customer);

//
//		// Adding orders
//		List<Product> order1Products = new ArrayList<>();
//		order1Products.add(product1);
//		Order order1 = new Order( 2, 1);
//		storeManagerImpI.addOrder(order1);
//
//		// Updating a product
//		product1.setPrice(1400.00);
//		storeManagerImpI.updateProduct(product1);
//
//		// Deleting a product
//		storeManagerImpI.deleteProduct(2);
//
//		// Displaying all products
//		Product product = storeManagerImpI.getProduct(1);
//		if (product != null) {
//			System.out.println("Product: " + product.getName() + " - " + product.getPrice());
//		} else {
//			System.out.println("Product not found.");
//		}

	}
	}

package com.example.Store.management;

import com.example.Store.management.Product.Product;
import com.example.Store.management.StorManagerImpI.StoreManager;
import com.example.Store.management.StorManagerImpI.StoreManagerImpI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreManagementApplication.class, args);
		StoreManager storeManager = new StoreManagerImpI();

		// Add products
		Product product1 = new Product(1, "Laptop", 1600);
		Product product2 = new Product(2, "phone", 900);
		storeManager.addProduct(product1);
		storeManager.addProduct(product2);
	}

}

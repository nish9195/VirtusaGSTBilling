package com.yrrhelp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.yrrhelp.models.Product;

@Service 
public class ProductService {

	public List<Product> getAllProducts() {
		
		List<Product> listOfProducts = new ArrayList<>();
		listOfProducts.add(new Product("1", "Nutella", 300, 5));
		listOfProducts.add(new Product("2", "Mayonnaise", 120, 4));
		listOfProducts.add(new Product("3", "Peanut Butter", 90, 7));
		listOfProducts.add(new Product("4", "Tomato Sauce", 80, 6));
		listOfProducts.add(new Product("5", "Maggi", 20, 3));
		listOfProducts.add(new Product("6", "Pringles", 250, 5));

		return listOfProducts;
	}

	public Product getProductById(String id) {

		Predicate<Product> byId = p -> p.getId().equals(id);
		return filterProducts(byId);
	}

	public Product filterProducts(Predicate<Product> strategy) {
		return getAllProducts().stream().filter(strategy).findFirst().orElse(null);
	}
}

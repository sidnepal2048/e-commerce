package com.personal.service;

import java.util.List;

import com.personal.entity.Product;

public interface ProductService {
	void addProduct(Product product);
	List<Product> getAllProduct();
	Product getProductById(int productId);
	void deleteProduct(int productId);
	void editProduct(Product product);
}

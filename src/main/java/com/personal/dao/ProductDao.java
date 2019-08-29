package com.personal.dao;

import java.util.List;

import com.personal.entity.Product;

public interface ProductDao {
	void addProduct(Product product);
	List<Product> getAllProduct();
	Product getProductById(int productId);
	void deleteProduct(int productId);
	void editProduct(Product product);
}

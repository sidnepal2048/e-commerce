package com.personal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.dao.ProductDao;
import com.personal.entity.Product;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}
	@Override
	public List<Product> getAllProduct() {
		return productDao.getAllProduct();
	}
	@Override
	public Product getProductById(int productId) {
		return productDao.getProductById(productId);
	}
	@Override
	public void deleteProduct(int productId) {
		productDao.deleteProduct(productId);
	}
	@Override
	public void editProduct(Product product) {
		productDao.editProduct(product);
	}

}

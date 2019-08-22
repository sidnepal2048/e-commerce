package com.personal.service;

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

}

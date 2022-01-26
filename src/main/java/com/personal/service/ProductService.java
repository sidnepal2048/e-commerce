package com.personal.service;

import com.personal.entity.Product;
import java.util.List;

public interface ProductService {
  void addProduct(Product product);

  List<Product> getAllProduct();

  Product getProductById(int productId);

  void deleteProduct(int productId);

  void editProduct(Product product);
}

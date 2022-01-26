package com.personal.dao;

import com.personal.entity.Product;
import java.util.List;

public interface ProductDao {
  void addProduct(Product product);

  List<Product> getAllProduct();

  Product getProductById(int productId);

  void deleteProduct(int productId);

  void editProduct(Product product);
}

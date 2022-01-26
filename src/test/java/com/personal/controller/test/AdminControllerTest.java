package com.personal.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.personal.controller.AdminController;
import com.personal.dao.UserDaoImpl;
import com.personal.entity.Product;
import com.personal.service.ProductServiceImpl;
import com.personal.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

public class AdminControllerTest {
  public Model model;

  @InjectMocks private UserServiceImpl userService;
  @InjectMocks private ProductServiceImpl productService;

  @Mock private UserDaoImpl userDao;

  @BeforeEach
  void initMocks() {
    model = new ExtendedModelMap();
    MockitoAnnotations.initMocks(this);
  }

  @InjectMocks AdminController adminController;

  Product generateProduct() {
    Product product = new Product();
    product.setProductId(1);
    product.setProductName("iphone");
    product.setProductCategory("mobile");
    product.setProductDescription("iphone 11 pro max");
    product.setStock(10);
    product.setProductPrice(1100.00);
    return product;
  }

  @Test
  public void test_admin_home() {
    String returnUrl = adminController.admin_home();
    assertEquals("dashboard", returnUrl);
  }

  @Test
  public void test_addProduct() {
    String returnUrl = adminController.addProduct(model);
    assertEquals("admin_home", returnUrl);
  }

  @Test
  public void test_addProductToDB() {}
}

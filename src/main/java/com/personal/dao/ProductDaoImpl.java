package com.personal.dao;

import com.personal.entity.Product;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductDaoImpl implements ProductDao {
  @Autowired private SessionFactory sessionFactory;

  @Transactional
  @Override
  public void addProduct(Product product) {
    Session session = sessionFactory.openSession();
    session.saveOrUpdate(product);
    session.flush();
  }

  @Override
  @Transactional
  public List<Product> getAllProduct() {
    Session session = sessionFactory.openSession();
    Query query = session.createQuery("from Product");
    List<Product> product = query.list();
    session.flush();
    return product;
  }

  @Override
  @Transactional
  public Product getProductById(int productId) {
    Session session = sessionFactory.openSession();
    Product product = (Product) session.get(Product.class, productId);
    session.close();
    return product;
  }

  @Override
  @Transactional
  public void deleteProduct(int productId) {
    Session session = sessionFactory.openSession();
    Product product = (Product) session.get(Product.class, productId);
    session.delete(product);
    session.flush();
    session.close();
  }

  public void editProduct(Product product) {
    Session session = sessionFactory.openSession();
    session.update(product);
    session.flush();
    session.close();
  }
}

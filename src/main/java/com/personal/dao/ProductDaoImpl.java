package com.personal.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.personal.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public void addProduct(Product product) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(product);
		session.flush();
	}

}

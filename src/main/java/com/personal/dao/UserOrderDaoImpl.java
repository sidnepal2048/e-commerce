package com.personal.dao;

import com.personal.entity.UserOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserOrderDaoImpl implements UserOrderDao {

  @Autowired private SessionFactory sessionFactory;

  @Override
  @Transactional
  public void addCustomerOrder(UserOrder orders) {
    Session session = sessionFactory.openSession();
    session.saveOrUpdate(orders);
    session.flush();
    session.close();
  }
}

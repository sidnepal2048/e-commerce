package com.personal.dao;

import com.personal.entity.Authorities;
import com.personal.entity.Cart;
import com.personal.entity.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl implements UserDao {
  @Autowired private SessionFactory sessionFactory;

  private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

  @Override
  @Transactional
  public void addUser(User user) {
    Session session = sessionFactory.openSession();
    user.setEnabled(true);
    session.saveOrUpdate(user);
    Authorities authorities = new Authorities();
    authorities.setAuthority("ROLE_USER");
    authorities.setEmail(user.getEmail());
    session.saveOrUpdate(authorities);
    Cart cart = new Cart();
    // it is to set CartId for customer table

    user.setCart(cart); // set the cart to the customer
    // if we omit this statement, hen it will insert null for customerid in cart
    // to set the customerid in cart table
    cart.setUser(user);
    session.flush();
  }

  @Override
  @Transactional
  public List<User> getAllUser() {
    Session session = sessionFactory.openSession();
    // Query query = session.createQuery("from User");
    List<User> user =
        session.createQuery("from User where email!='siddharthanepal05@gmail.com'").list();
    for (User u : user) {
      logger.info("User List::" + u);
    }
    session.flush();
    return user;
  }

  @Override
  @Transactional
  public User getUserByEmail(String email) {
    Session session = sessionFactory.openSession();
    Query query = session.createQuery("from User where email=?");
    query.setString(0, email);
    System.out.println(email);
    return (User) query.uniqueResult();
  }
}

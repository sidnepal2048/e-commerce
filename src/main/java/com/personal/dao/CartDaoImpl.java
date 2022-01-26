package com.personal.dao;

import com.personal.entity.Cart;
import com.personal.service.UserOrderService;
import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CartDaoImpl implements CartDao {

  @Autowired private SessionFactory sessionFactory;

  @Autowired private UserOrderService userOrderService;

  @Transactional
  @Override
  public Cart getCartByCartId(int CartId) {
    Session session = sessionFactory.openSession();
    Cart cart = (Cart) session.get(Cart.class, CartId);
    // System.out.println(cart.getCartId() + " " + cart.getCartItem());
    System.out.println(cart);
    session.close();
    return cart;
  }

  @Transactional
  @Override
  public Cart validate(int cartId) throws IOException {
    Cart cart = getCartByCartId(cartId);
    if (cart == null || cart.getCartItem().size() == 0) {
      throw new IOException(cartId + "");
    }
    update(cart);
    return cart;
  }

  @Transactional
  @Override
  public double update(Cart cart) {

    int cartId = cart.getCartId();
    double grandTotal = userOrderService.getCustomerOrderGrandTotal(cartId);
    cart.setTotalPrice(grandTotal);

    Session session = sessionFactory.openSession();
    session.saveOrUpdate(cart);
    session.flush();
    session.close();
    return grandTotal;
  }
}

package com.personal.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.personal.entity.Cart;
import com.personal.entity.CartItem;

@Repository
public class CartItemDaoImpl implements CartItemDao {

	@Autowired
	private SessionFactory sessionFactory;
    
	@Transactional
	@Override
	public void addCartItem(CartItem cartItem) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(cartItem);
		session.flush();
		session.close();
	}
	
	@Transactional
	@Override
	public void removeCartItem(int cartItemId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("delete from CartItem where cartItemId=?");
		query.setInteger(0, cartItemId);
		query.executeUpdate();
		session.flush();
		session.close();
	}
	
	@Override
	@Transactional
	public List<CartItem> getCartItem(int cartId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from CartItem where cartId=?");
		query.setInteger(0, cartId);
		List<CartItem> cartItem = query.list();
		session.flush();
		return cartItem;		
	}

	@Override
	@Transactional
	public void removeAllCartItems(Cart cart) {
		Session session = sessionFactory.openSession();
		int cartId = cart.getCartId();
		Query query = session.createQuery("delete from CartItem where cartId=?");
		query.setInteger(0, cartId);
		query.executeUpdate();
		session.flush();
		session.close();
	}
}
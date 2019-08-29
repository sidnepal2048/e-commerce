package com.personal.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.dao.CartDao;
import com.personal.entity.Cart;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;

	@Override
	public Cart getCartByCartId(int CartId) {
		return cartDao.getCartByCartId(CartId);
	}

	@Override
	public Cart validate(int cartId) throws IOException {
		return cartDao.validate(cartId);
	}

	@Override
	public double update(Cart cart) {
		return cartDao.update(cart);
	}
	
	
}

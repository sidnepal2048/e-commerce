package com.personal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.dao.CartItemDao;
import com.personal.entity.Cart;
import com.personal.entity.CartItem;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemDao cartItemDao;

	
	@Override
	public void addCartItem(CartItem cartItem) {
		cartItemDao.addCartItem(cartItem);
	}

	@Override
	public void removeCartItem(int CartItemId) {
		cartItemDao.removeCartItem(CartItemId);
	}

	@Override
	public List<CartItem> getCartItem(int cartId) {
		return cartItemDao.getCartItem(cartId);
	}

	@Override
	public void removeAllCartItems(Cart cart) {
		cartItemDao.removeAllCartItems(cart);
	}

}

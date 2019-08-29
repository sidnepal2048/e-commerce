package com.personal.service;

import java.util.List;

import com.personal.entity.Cart;
import com.personal.entity.CartItem;

public interface CartItemService {
	void addCartItem(CartItem cartItem);
	void removeCartItem(int CartItemId);
	public List<CartItem> getCartItem(int cartId);
	void removeAllCartItems(Cart cart);
}

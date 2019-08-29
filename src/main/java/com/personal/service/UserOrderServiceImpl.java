package com.personal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.dao.UserOrderDao;
import com.personal.entity.Cart;
import com.personal.entity.CartItem;
import com.personal.entity.UserOrder;

@Service
public class UserOrderServiceImpl implements UserOrderService {

	@Autowired
	private UserOrderDao userOrderDao;
	
	@Autowired
	private CartService cartService;

	@Override
	public void addCustomerOrder(UserOrder orders) {
		userOrderDao.addCustomerOrder(orders);
	}

	@Override
	public double getCustomerOrderGrandTotal(int cartId) {
		double grandTotal=0;
		Cart cart = cartService.getCartByCartId(cartId);
		List<CartItem> cartItems = cart.getCartItem();
		
		for(CartItem item: cartItems){
			grandTotal += item.getPrice();
		}
		return grandTotal;

	}

}

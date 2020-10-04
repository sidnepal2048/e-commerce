package com.personal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.personal.entity.Cart;
import com.personal.entity.User;
import com.personal.entity.UserOrder;
import com.personal.service.CartService;
import com.personal.service.UserOrderService;

@Controller
public class OrderController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private UserOrderService userOrderService;
	
	
	@RequestMapping("/order/{cartId}")
	public String createOrder(@PathVariable("cartId") int cartId) {

		UserOrder userOrder = new UserOrder();
		Cart cart = cartService.getCartByCartId(cartId);
		// Update CartId for customerOrder - set CartId
		userOrder.setCart(cart);
		User user = cart.getUser();
		userOrder.setUser(user);
		userOrder.setShippingAddress(user.getShippingAddress());
		userOrder.setBillingAddress(user.getBillingAddress());
		userOrderService.addCustomerOrder(userOrder);
		return "checkout";
		//return "redirect:/checkout?cartId=" + cartId;
	}

}

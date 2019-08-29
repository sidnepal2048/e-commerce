package com.personal.service;

import java.io.IOException;

import com.personal.entity.Cart;

public interface CartService {
	Cart getCartByCartId(int CartId);
	Cart validate(int cartId) throws IOException;
	double update(Cart cart);

}

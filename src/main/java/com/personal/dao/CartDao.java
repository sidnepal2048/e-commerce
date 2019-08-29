package com.personal.dao;

import java.io.IOException;

import com.personal.entity.Cart;

public interface CartDao {
	Cart getCartByCartId(int CartId);
	Cart validate(int cartId) throws IOException;
	double update(Cart cart);

}

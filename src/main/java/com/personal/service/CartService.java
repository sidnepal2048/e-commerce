package com.personal.service;

import com.personal.entity.Cart;
import java.io.IOException;

public interface CartService {
  Cart getCartByCartId(int CartId);

  Cart validate(int cartId) throws IOException;

  double update(Cart cart);
}

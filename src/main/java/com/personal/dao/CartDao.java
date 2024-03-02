package com.personal.dao;

import com.personal.entity.Cart;
import java.io.IOException;

public interface CartDao {
  Cart getCartByCartId(int CartId);

  Cart validate(int cartId) throws IOException;

  double update(Cart cart);
}

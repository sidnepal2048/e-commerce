package com.personal.dao;

import com.personal.entity.Cart;
import com.personal.entity.CartItem;
import java.util.List;

public interface CartItemDao {

  void addCartItem(CartItem cartItem);

  void removeCartItem(int CartItemId);

  public List<CartItem> getCartItem(int cartId);

  void removeAllCartItems(Cart cart);
}

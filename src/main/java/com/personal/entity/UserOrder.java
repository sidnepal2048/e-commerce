package com.personal.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_order")
public class UserOrder implements Serializable {

  private static final long serialVersionUID = -6571020025726257848L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int orderId;

  @OneToOne
  @JoinColumn(name = "cartId")
  private Cart cart;

  @OneToOne
  @JoinColumn(name = "id")
  private User user;

  @OneToOne
  @JoinColumn(name = "shippingAddressId")
  private ShippingAddress shippingAddress;

  @OneToOne
  @JoinColumn(name = "billingAddressId")
  private BillingAddress billingAddress;

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public Cart getCart() {
    return cart;
  }

  public void setCart(Cart cart) {
    this.cart = cart;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public ShippingAddress getShippingAddress() {
    return shippingAddress;
  }

  public void setShippingAddress(ShippingAddress shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  public BillingAddress getBillingAddress() {
    return billingAddress;
  }

  public void setBillingAddress(BillingAddress billingAddress) {
    this.billingAddress = billingAddress;
  }
}

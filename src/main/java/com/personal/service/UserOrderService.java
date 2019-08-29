package com.personal.service;

import com.personal.entity.UserOrder;

public interface UserOrderService {
	void addCustomerOrder(UserOrder orders);
	double getCustomerOrderGrandTotal(int cartId);

}

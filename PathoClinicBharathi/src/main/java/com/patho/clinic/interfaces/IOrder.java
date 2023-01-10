package com.patho.clinic.interfaces;

import java.util.List;

import com.patho.clinic.models.Order;

public interface IOrder {

	public Order addOrder(Order order);
	
	public List<Order> getAllOrders();

}

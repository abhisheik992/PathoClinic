package com.patho.clinic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patho.clinic.interfaces.IOrder;
import com.patho.clinic.models.Order;
import com.patho.clinic.repositories.OrderRepository;

@Service
public class OrderService implements IOrder {

	@Autowired
	private OrderRepository orderRepository;
	
	
	@Override
	public Order addOrder(Order order) {
		return this.orderRepository.save(order);
	}

}

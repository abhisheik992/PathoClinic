package com.patho.clinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patho.clinic.interfaces.IOrder;
import com.patho.clinic.models.Invoice;
import com.patho.clinic.models.Order;
import com.patho.clinic.services.OrderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class OrderController {
	
	@Autowired
	private IOrder orderService;
	
	@PostMapping("/order")
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		Order _order = this.orderService.addOrder(order);
		return new ResponseEntity<>(_order, HttpStatus.CREATED);
	}

}

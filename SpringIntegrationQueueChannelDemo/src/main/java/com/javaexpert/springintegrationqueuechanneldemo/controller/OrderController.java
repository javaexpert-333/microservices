package com.javaexpert.springintegrationqueuechanneldemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpert.springintegrationqueuechanneldemo.entity.Order;
import com.javaexpert.springintegrationqueuechanneldemo.gateway.OrderGateway;

@RestController
public class OrderController {

	@Autowired
	public OrderGateway orderGateway;
	
	@PostMapping("/placeOrder")
	public Order placeOrder(@RequestBody Order order) {
		Message<Order> orderResponse = orderGateway.placeOrder(order);
		return orderResponse.getPayload();
	}
}

package com.javaexpert.springintegrationqueuechanneldemo.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

import com.javaexpert.springintegrationqueuechanneldemo.entity.Order;

@MessagingGateway
public interface OrderGateway {

	@Gateway(requestChannel="request-in-channel")
	public Message<Order> placeOrder(Order order);
}

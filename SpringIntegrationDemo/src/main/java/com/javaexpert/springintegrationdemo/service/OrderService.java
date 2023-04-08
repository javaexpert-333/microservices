package com.javaexpert.springintegrationdemo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import com.javaexpert.springintegrationdemo.model.Order;

@Service
public class OrderService {
	
	@Bean(name="order-process-channel")
	public MessageChannel processChannel() {
		return new DirectChannel();
	}

	@ServiceActivator(inputChannel="request-in-channel", outputChannel="order-process-channel")
	public Message<Order> placeOrder(Message<Order> order) {
		return order;
	}
	
	@ServiceActivator(inputChannel="order-process-channel",outputChannel="order-reply-channel")
	public Message<Order> processOrder(Message<Order> order) {
		order.getPayload().setOrderStatus("Order successfully placed !!!");
		return order;
	}
	
	@ServiceActivator(inputChannel="order-reply-channel")
	public void replyOrder(Message<Order> order) {
		MessageChannel replyChannel = (MessageChannel)order.getHeaders().getReplyChannel();
		replyChannel.send(order);
	}
}

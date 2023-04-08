package com.javaexpert.springintegrationqueuechanneldemo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import com.javaexpert.springintegrationqueuechanneldemo.entity.Order;

@Service
public class OrderService {

	@Bean(name="order-process-channel")
	public MessageChannel orderProcessChannel() {
		return new QueueChannel(10);
	}
	
	@Bean(name="order-reply-channel")
	public MessageChannel orderReplyChannel() {
		return new QueueChannel(10);
	}
	
	
	@ServiceActivator(inputChannel="request-in-channel", outputChannel="order-process-channel")
	public Message<Order> placeOrder(Message<Order> order) {
		return order;
	}
	
	@ServiceActivator(inputChannel="order-process-channel", outputChannel="order-reply-channel", poller=@Poller(fixedDelay="100",maxMessagesPerPoll="1" ))
	public Message<Order> processOrder(Message<Order> order) {
		order.getPayload().setOrderStatus("Order is successfully placed !!!");
		return order;
	}
	
	@ServiceActivator(inputChannel="order-reply-channel", poller=@Poller(fixedDelay="100",maxMessagesPerPoll="1" ))
	public void replyChannel(Message<Order> order) {
		MessageChannel replyChannel = (MessageChannel)order.getHeaders().getReplyChannel();
		replyChannel.send(order);
	}
	
}

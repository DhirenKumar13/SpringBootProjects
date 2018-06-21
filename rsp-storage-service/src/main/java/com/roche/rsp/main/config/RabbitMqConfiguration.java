package com.roche.rsp.main.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {
	
	@Value("${storage.service.response.queue}")
	private String storageServiceQueue;

	@Value("${storage.service.response.exchange}")
	private String storageServiceExchange;

	@Value("${storage.service.response.routingkey}")
	private String storageServiceRoutingkey;

	@Bean
	Queue initiateQueue() {
		return new Queue(storageServiceQueue, true);
	}

	@Bean
	DirectExchange initiateExchange() {
		return new DirectExchange(storageServiceExchange);
	}

	@Bean
	Binding initiateBinding(Queue storageServiceQueue, DirectExchange storageServiceExchange) {
		return BindingBuilder.bind(storageServiceQueue).to(storageServiceExchange).with(storageServiceRoutingkey);
	}
}

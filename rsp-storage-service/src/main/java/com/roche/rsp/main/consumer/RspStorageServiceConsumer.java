package com.roche.rsp.main.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.roche.rsp.main.model.GetStoragePathParameters;

@Service
public class RspStorageServiceConsumer {
	
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${rsp.azure.blob.storage.client.url}")
	private String url;
	
	@Value("${storage.service.response.exchange}")
	private String storageServiceExchange;
	
	@Value("${storage.service.response.routingkey}")
	private String storageServiceRoutingkey;
	
	@RabbitListener(queues = "${rsp.storage.service.queue}")
	public void listen(GetStoragePathParameters storagePathParams) {
		
		HttpEntity<GetStoragePathParameters> entity = new HttpEntity<>(storagePathParams);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		if(response.getBody() != null) {
			amqpTemplate.convertAndSend(storageServiceExchange,storageServiceRoutingkey, response.getBody());
		} else {
			LOGGER.debug("Invalid Response Captured",response.getBody());
		}
	}
}

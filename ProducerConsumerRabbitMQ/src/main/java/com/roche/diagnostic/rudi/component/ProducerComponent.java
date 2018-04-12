package com.roche.diagnostic.rudi.component;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.roche.diagnostic.rudi.rabbit.model.PersonModel;

@Component
public class ProducerComponent {
	
	private static Integer ageCounter = 23;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE = "sales_data_exchange";
    private static final String ROUTING_KEY = "customer.order";
	
    @Scheduled(fixedRate = 500)
	public void sendMessage() {
    	PersonModel model = createPerson();
    	rabbitTemplate.convertAndSend(EXCHANGE,ROUTING_KEY,model);
	}
    
    public PersonModel createPerson() {
    	ageCounter ++;
    	return new PersonModel("Dhiren",ageCounter);
    }
}

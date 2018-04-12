package com.roche.diagnostic.rudi.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.roche.diagnostic.rudi.rabbit.model.PersonModel;

@Component
@RabbitListener(queues = {"orders_queue"})
public class ConsumerComponent {
	@RabbitHandler
    public void receiveMessage(PersonModel model)
    {
        System.out.println(model.getPersonName());
        System.out.println(model.getPersonAge());
    }
}

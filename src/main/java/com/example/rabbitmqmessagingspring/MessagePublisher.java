package com.example.rabbitmqmessagingspring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${rabbitmq.exchange.name}")
    private String EXCHANGE_NAME;
    @Value("${rabbitmq.keyroute.name}")
    private String KEYROUTE_NAME;
    public void sendMessage(String message){
        rabbitTemplate.convertAndSend(EXCHANGE_NAME,KEYROUTE_NAME,message);
    }
}

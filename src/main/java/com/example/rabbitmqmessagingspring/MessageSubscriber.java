package com.example.rabbitmqmessagingspring;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageSubscriber {

    @RabbitListener(queues ="queue-message")
    public void listen(String message){
        System.out.println("messages receiveds "+ message);
    }
}

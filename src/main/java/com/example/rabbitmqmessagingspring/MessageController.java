package com.example.rabbitmqmessagingspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired

    private MessagePublisher messagePublisher;

    @GetMapping("/publish")
    public void sendMessage(@RequestParam String message){
        messagePublisher.sendMessage(message);
        System.out.println("Message send succesfully "+ message);
    }
}

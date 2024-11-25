package com.example.rabbitmqmessagingspring;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${rabbitmq.queue.name}")
    private static String QUEUE_NAME;
    @Value("${rabbitmq.exchange.name}")
    private static String EXCHANGE_NAME;
    @Value("${rabbitmq.keyroute.name}")
    private static String KEYROUTE_NAME;

    @Bean
    public Queue myQueue(){
        return new Queue("queue-message");
    }

    @Bean
    public Exchange myExchange(){
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding bindQueue(){
        return BindingBuilder.bind(myQueue())
                .to(myExchange())
                .with(KEYROUTE_NAME)
                .noargs();
    }
}

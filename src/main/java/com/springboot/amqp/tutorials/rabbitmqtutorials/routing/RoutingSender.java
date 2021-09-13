package com.springboot.amqp.tutorials.rabbitmqtutorials.routing;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class RoutingSender {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private DirectExchange direct;

    private final String[] keys = {"orange", "black", "green","white"};

    public void send() {
        for (int i = 0; i < 10; i++) {
            String key = keys[ i % keys.length];
            String message = "hello to " + key;
            template.convertAndSend(direct.getName(), key, message);
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}

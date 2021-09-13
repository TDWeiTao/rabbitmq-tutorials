package com.springboot.amqp.tutorials.rabbitmqtutorials.topics;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class TopicsSender {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private TopicExchange topic;

    private final String[] keys = {"quick.orange.rabbit", "lazy.orange.elephant", "quick.orange.fox",
            "lazy.brown.fox", "lazy.pink.rabbit", "quick.brown.fox", "lazy.orange.male.rabbit"};

    public void send() {
        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            String message = "hello to " + key;
            template.convertAndSend(topic.getName(), key, message);
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}

package com.springboot.amqp.tutorials.rabbitmqtutorials.pubsub;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class PublishSender {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private FanoutExchange fanout;

    public void send() {
        for (int i = 0; i < 10; i++) {
            String message = "hello."+i;
            template.convertAndSend(fanout.getName(), "", message);
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}

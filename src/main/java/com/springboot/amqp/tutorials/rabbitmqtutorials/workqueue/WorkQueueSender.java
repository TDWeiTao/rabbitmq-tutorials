package com.springboot.amqp.tutorials.rabbitmqtutorials.workqueue;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

public class WorkQueueSender {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    public void send() {
        for (int i = 0; i < 10; i++) {
            String message = "hello."+i;
            template.convertAndSend(queue.getName(), message);
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}

package com.springboot.amqp.tutorials.rabbitmqtutorials.helloworld;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

//消息监听器，监听hello队列
@RabbitListener(queues = "hello")
public class HelloWorldReceiver {

    @RabbitHandler
    public void receive(String in) {
        System.out.println(" [x] Received '" + in + "'");
    }
}

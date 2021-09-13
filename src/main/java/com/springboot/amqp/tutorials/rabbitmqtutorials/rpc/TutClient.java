package com.springboot.amqp.tutorials.rabbitmqtutorials.rpc;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class TutClient {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private DirectExchange exchange;


    public String send(Integer start) {
        System.out.println(" [x] Requesting fib(" + start + ")");
        //routingKey必须是rpc,不然报错
        Integer response = (Integer) template.convertSendAndReceive
                (exchange.getName(), "rpc", start);
        System.out.println(" [.] Got '" + response + "'");
        return response.toString();
    }
}

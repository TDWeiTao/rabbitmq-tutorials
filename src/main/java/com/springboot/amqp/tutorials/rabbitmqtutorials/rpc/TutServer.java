package com.springboot.amqp.tutorials.rabbitmqtutorials.rpc;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class TutServer {
    @RabbitListener(queues = "tut.rpc.requests1")
    public int fibonacci(int n) {
        System.out.println(" [x] Received request for " + n);
        int result = compute(n);
        System.out.println(" [.] Returned " + result);
        return result;
    }

    public int compute(int n) {
        return n * 10;
    }
}

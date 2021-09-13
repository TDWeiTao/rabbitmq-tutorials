package com.springboot.amqp.tutorials.rabbitmqtutorials.pubconfirm;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class ConfirmSender {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private TopicExchange topic;

    @Autowired
    private Queue queue;

    @Autowired
    private Queue ackQueue;

    public void sendConfirm() {
        String message = "confirm message";
        this.template.convertAndSend(queue.getName(), message);
        this.template.setConfirmCallback((correlationData, ack, cause) -> {
            if (!ack) {
                System.out.println(" [P] message returned");
            } else {
                System.out.println(" [P] message send success!");
            }
        });
        System.out.println(" [P] Sent '" + message + "'");
    }

    public void sendReturn() {
        String message = "return message";
        //发送一个不可路由的消息
        this.template.convertAndSend(topic.getName(), "black", message);
        this.template.setReturnsCallback((returnedMessage) -> {
            StringBuilder sb = new StringBuilder(" [P] returnedMessage ===> replyCode=").append(returnedMessage.getReplyCode()).append(", ")
                    .append("replyText=").append(returnedMessage.getReplyText()).append(", ")
                    .append("exchange=").append(returnedMessage.getExchange()).append(", ")
                    .append("routingKey=").append(returnedMessage.getRoutingKey());
            System.out.println(sb);

        });
        System.out.println(" [P] Sent '" + message + "'");
    }

    public void send() {
        String message = "ack message";
        this.template.convertAndSend(ackQueue.getName(), message);
        System.out.println(" [P] Sent '" + message + "'");
    }
}

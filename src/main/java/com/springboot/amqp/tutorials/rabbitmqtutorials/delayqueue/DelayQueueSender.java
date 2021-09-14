package com.springboot.amqp.tutorials.rabbitmqtutorials.delayqueue;

import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class DelayQueueSender {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private CustomExchange direct;

    public final String DELAY_ROUTING_KEY = "delay-routing-key";

    public void send(Integer time) {
        String content = "延迟消息";
        template.convertAndSend(direct.getName(),DELAY_ROUTING_KEY,content,message -> {
            message.getMessageProperties().setHeader("x-delay",time);
            return message;
        });
        this.template.setConfirmCallback((correlationData, ack, cause) -> {
            if (!ack) {
                System.out.println(" [delay_queue_sender]：send fail");
            } else {
                System.out.println("[delay_queue_sender]：send '" + content + "'，send time: " + DateUtils.getCurrentDate());
            }
        });

    }
}

package com.springboot.amqp.tutorials.rabbitmqtutorials.delayqueue;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;

@RabbitListener(queues = "delay-queue")
public class DelayQueueReceiver {

    @RabbitHandler
    public void receive(String in, Channel channel, Message message) throws IOException {
        System.out.println("[delay_queue_receiver]: Received '" + in +
                "',recevied time:" + DateUtils.getCurrentDate());
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}

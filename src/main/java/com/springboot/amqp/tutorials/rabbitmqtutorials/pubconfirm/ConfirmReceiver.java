package com.springboot.amqp.tutorials.rabbitmqtutorials.pubconfirm;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class ConfirmReceiver {
    private AtomicInteger count = new AtomicInteger(0);

    @RabbitListener(queues = "confirm")
    @RabbitHandler
    public void receive(String in, Channel channel, Message message) {
        System.out.println(" [C] Received '" + in + "'");
    }

    @RabbitListener(queues = "ack")
    @RabbitHandler
    public void ackReceive(String in, Channel channel, Message message) {
        System.out.println(" [C] Received '" + in + "'");
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            // 业务处理成功后调用，消息会被确认消费
            if (count.incrementAndGet() == 5) {
                System.out.println("[C] ack the message:" + message);
                count.set(0);
                channel.basicAck(deliveryTag, false);
            } else {
                // 业务处理失败后调用
                System.out.println("[C] nack or reject the message:" + message);
//                channel.basicNack(deliveryTag, false, true);
                channel.basicReject(deliveryTag, true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

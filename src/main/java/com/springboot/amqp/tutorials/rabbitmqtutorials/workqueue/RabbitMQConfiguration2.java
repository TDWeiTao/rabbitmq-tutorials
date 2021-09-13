package com.springboot.amqp.tutorials.rabbitmqtutorials.workqueue;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"work-queue"})
@Configuration
public class RabbitMQConfiguration2 {
    //声明一个名称为work-queue的队列
    @Bean
    public Queue hello() {
        return new Queue("work-queue");
    }
    //声明一个消费者实例1
    @Bean
    public WorkQueueReceiver receiver1() {
        return new WorkQueueReceiver(1);
    }
    //声明一个消费者实例2
    @Bean
    public WorkQueueReceiver receiver2() {
        return new WorkQueueReceiver(2);
    }
    //声明一个生产者实例
    @Bean
    public WorkQueueSender sender() {
        return new WorkQueueSender();
    }
}

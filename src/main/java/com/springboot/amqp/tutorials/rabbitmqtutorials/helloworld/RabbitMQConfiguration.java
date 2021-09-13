package com.springboot.amqp.tutorials.rabbitmqtutorials.helloworld;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"hello-world"})
@Configuration
public class RabbitMQConfiguration {
    //声明一个名称为hello的队列
    @Bean
    public Queue hello() {
        return new Queue("hello");
    }
    //声明一个消费者
    @Bean
    public HelloWorldReceiver receiver() {
        return new HelloWorldReceiver();
    }
    //声明一个生产者
    @Bean
    public HelloWorldSender sender() {
        return new HelloWorldSender();
    }
}

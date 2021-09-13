package com.springboot.amqp.tutorials.rabbitmqtutorials.routing;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"routing"})
@Configuration
public class RabbitMQConfiguration4 {
    //声明一个交换机，类型为direct
    @Bean
    public DirectExchange direct() {
        return new DirectExchange("tut.direct");
    }

    @Bean(name = "autoDeleteQueue1")
    public Queue autoDeleteQueue1() {
        return new AnonymousQueue();
    }

    @Bean(name = "autoDeleteQueue2")
    public Queue autoDeleteQueue2() {
        return new AnonymousQueue();
    }

    //声明一个绑定关系，autoDeleteQueue1->direct, routingKey:orange
    @Bean
    public Binding binding1a(DirectExchange direct, Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1).to(direct).with("orange");
    }

    //声明一个绑定关系，autoDeleteQueue1->direct, routingKey:black
    @Bean
    public Binding binding1b(DirectExchange direct, Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1).to(direct).with("black");
    }

    //声明一个绑定关系，autoDeleteQueue2->direct, routingKey:green
    @Bean
    public Binding binding2a(DirectExchange direct, Queue autoDeleteQueue2) {
        return BindingBuilder.bind(autoDeleteQueue2).to(direct).with("green");
    }

    //声明一个绑定关系，autoDeleteQueue1->direct, routingKey:black
    @Bean
    public Binding binding2b(DirectExchange direct, Queue autoDeleteQueue2) {
        return BindingBuilder.bind(autoDeleteQueue2).to(direct).with("black");
    }

    @Bean
    public RoutingReceiver receiver() {
        return new RoutingReceiver();
    }

    @Bean
    public RoutingSender sender() {
        return new RoutingSender();
    }
}

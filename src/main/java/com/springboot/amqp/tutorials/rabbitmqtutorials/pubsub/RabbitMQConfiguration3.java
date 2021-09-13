package com.springboot.amqp.tutorials.rabbitmqtutorials.pubsub;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"pub-sub"})
@Configuration
public class RabbitMQConfiguration3 {
    //声明一个faount类型的交换机
    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("tut.fanout");
    }


    //声明一个队列，名称为autoDeleteQueue1
    @Bean(name = "autoDeleteQueue1")
    public Queue autoDeleteQueue1() {
        return new AnonymousQueue();
    }

    //声明一个队列，名称为autoDeleteQueue2
    @Bean(name = "autoDeleteQueue2")
    public Queue autoDeleteQueue2() {
        return new AnonymousQueue();
    }

    //声明一个绑定关系，autoDeleteQueue1跟fanout交换机绑定
    @Bean
    public Binding binding1(FanoutExchange fanout, Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1).to(fanout);
    }

    //声明一个绑定关系，autoDeleteQueue2跟fanout交换机绑定
    @Bean
    public Binding binding2(FanoutExchange fanout, Queue autoDeleteQueue2) {
        return BindingBuilder.bind(autoDeleteQueue2).to(fanout);
    }

    //声明一个消息订阅者
    @Bean
    public SubscribeReceiver receiver() {
        return new SubscribeReceiver();
    }

    //声明一个消息发布者
    @Bean
    public PublishSender sender() {
        return new PublishSender();
    }
}

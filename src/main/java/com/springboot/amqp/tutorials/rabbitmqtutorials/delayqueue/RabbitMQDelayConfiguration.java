package com.springboot.amqp.tutorials.rabbitmqtutorials.delayqueue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

@Profile({"delay-queue"})
@Configuration
public class RabbitMQDelayConfiguration {
    public final String DELAY_QUEUE = "delay-queue";
    public final String DELAY_EXCHANGE = "delay-exchange";
    public final String DELAY_ROUTING_KEY = "delay-routing-key";
    //声明一个延迟队列
    @Bean
    public Queue delayQueue () {
        return new Queue(DELAY_QUEUE,true);
    }
    //声明一个延迟交换机
    @Bean
    public CustomExchange delayExchange(){
        Map<String,Object> args = new HashMap<>();
        args.put("x-delayed-type","direct");
        return new CustomExchange(DELAY_EXCHANGE,"x-delayed-message",true,false,args);
    }
    //队列绑定交换机
    @Bean
    public Binding delayBinding(Queue queue,CustomExchange customExchange){
       return BindingBuilder.bind(queue).to(customExchange).with(DELAY_ROUTING_KEY).noargs();
    }
    //声明一个消费者实例
    @Bean
    public DelayQueueReceiver receiver1() {
        return new DelayQueueReceiver();
    }
    //声明一个生产者实例
    @Bean
    public DelayQueueSender sender() {
        return new DelayQueueSender();
    }
}

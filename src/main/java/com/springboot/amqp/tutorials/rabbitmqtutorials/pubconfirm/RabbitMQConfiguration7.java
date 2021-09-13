package com.springboot.amqp.tutorials.rabbitmqtutorials.pubconfirm;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"confirm"})
@Configuration
public class RabbitMQConfiguration7 {

    @Bean
    public TopicExchange topic() {
        return new TopicExchange("tut.topic");
    }

    @Bean
    public Queue queue() {
        return new Queue("confirm");
    }

    @Bean(name = "ackQueue")
    public Queue queue1() {
        return new Queue("ack");
    }

    @Bean
    public Binding binding1a(TopicExchange topic, Queue queue) {
        return BindingBuilder.bind(queue).to(topic).with("*.orange.*");
    }

    @Bean
    public ConfirmReceiver receiver() {
        return new ConfirmReceiver();
    }

    @Bean
    public ConfirmSender sender() {
        return new ConfirmSender();
    }
}

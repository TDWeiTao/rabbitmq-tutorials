package com.springboot.amqp.tutorials.rabbitmqtutorials.topics;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"topics"})
@Configuration
public class RabbitMQConfiguration5 {

    @Bean
    public TopicExchange topic() {
        return new TopicExchange("tut.topic");
    }

    @Bean(name = "autoDeleteQueue1")
    public Queue autoDeleteQueue1() {
        return new AnonymousQueue();
    }

    @Bean(name = "autoDeleteQueue2")
    public Queue autoDeleteQueue2() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding binding1a(TopicExchange topic, Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1).to(topic).with("*.orange.*");
    }

    @Bean
    public Binding binding1b(TopicExchange topic, Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1).to(topic).with("*.*.rabbit");
    }

    @Bean
    public Binding binding2a(TopicExchange topic, Queue autoDeleteQueue2) {
        return BindingBuilder.bind(autoDeleteQueue2).to(topic).with("lazy.#");
    }

    @Bean
    public TopicsReceiver receiver() {
        return new TopicsReceiver();
    }

    @Bean
    public TopicsSender sender() {
        return new TopicsSender();
    }
}

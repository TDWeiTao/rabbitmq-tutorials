package com.springboot.amqp.tutorials.rabbitmqtutorials.rpc;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"rpc"})
@Configuration
public class RabbitMQConfiguration6 {

    //定义client
    @Bean
    public TutClient client() {
        return new TutClient();
    }

    //定义队列
    @Bean(name = "queue")
    public Queue hello() {
        return new Queue("tut.rpc.requests1");
    }

    //定义交换机
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("tut.rpc1");
    }

    //定义绑定关系
    @Bean
    public Binding binding(DirectExchange exchange,
                           Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with("rpc");
    }

    //定义server
    @Bean
    public TutServer server() {
        return new TutServer();
    }
}

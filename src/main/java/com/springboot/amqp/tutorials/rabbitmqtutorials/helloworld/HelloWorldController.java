package com.springboot.amqp.tutorials.rabbitmqtutorials.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@ConditionalOnBean(HelloWorldSender.class)
@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldSender sender;

    @GetMapping("/mq/hello_world")
    public String helloWorld() {
        sender.send();
        return "ok";
    }
}

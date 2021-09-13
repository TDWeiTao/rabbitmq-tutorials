package com.springboot.amqp.tutorials.rabbitmqtutorials.routing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@ConditionalOnBean(RoutingSender.class)
@RestController
public class RoutingController {

    @Autowired
    private RoutingSender sender;

    @GetMapping("/mq/routing")
    public String helloWorld() {
        sender.send();
        return "ok";
    }
}

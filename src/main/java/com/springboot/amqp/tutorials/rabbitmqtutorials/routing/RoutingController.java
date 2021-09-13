package com.springboot.amqp.tutorials.rabbitmqtutorials.routing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile({"routing"})
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

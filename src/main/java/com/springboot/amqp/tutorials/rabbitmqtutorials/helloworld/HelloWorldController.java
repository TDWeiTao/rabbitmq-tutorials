package com.springboot.amqp.tutorials.rabbitmqtutorials.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile({"hello-world"})
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

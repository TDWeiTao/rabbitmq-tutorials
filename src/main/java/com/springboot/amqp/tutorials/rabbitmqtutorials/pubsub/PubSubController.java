package com.springboot.amqp.tutorials.rabbitmqtutorials.pubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@ConditionalOnBean(PublishSender.class)
@RestController
public class PubSubController {

    @Autowired
    private PublishSender sender;

    @GetMapping("/mq/pubsub")
    public String helloWorld() {
        sender.send();
        return "ok";
    }
}

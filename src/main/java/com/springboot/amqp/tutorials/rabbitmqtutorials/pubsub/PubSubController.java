package com.springboot.amqp.tutorials.rabbitmqtutorials.pubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile({"pub-sub"})
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

package com.springboot.amqp.tutorials.rabbitmqtutorials.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile({"topics"})
@RestController
public class TopicsController {

    @Autowired
    private TopicsSender sender;

    @GetMapping("/mq/topics")
    public String helloWorld() {
        sender.send();
        return "ok";
    }
}

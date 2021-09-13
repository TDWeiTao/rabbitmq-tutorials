package com.springboot.amqp.tutorials.rabbitmqtutorials.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@ConditionalOnBean(TopicsSender.class)
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

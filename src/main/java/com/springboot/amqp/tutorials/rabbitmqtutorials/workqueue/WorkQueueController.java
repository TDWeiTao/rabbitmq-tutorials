package com.springboot.amqp.tutorials.rabbitmqtutorials.workqueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@ConditionalOnBean(WorkQueueSender.class)
@RestController
public class WorkQueueController {
    @Autowired
    private WorkQueueSender sender;

    @GetMapping("/mq/work_queue")
    public String helloWorld() {
        sender.send();
        return "ok";
    }
}

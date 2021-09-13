package com.springboot.amqp.tutorials.rabbitmqtutorials.workqueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Profile({"work-queue"})
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

package com.springboot.amqp.tutorials.rabbitmqtutorials.delayqueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DelayQueueController {
    @Autowired
    private  DelayQueueSender delayQueueSender;

    @GetMapping("/mq/delay_queue")
    public String pubConfirm() {
        //延迟1000ms发送
        delayQueueSender.send(10000);
        return "ok";
    }
}

package com.springboot.amqp.tutorials.rabbitmqtutorials.pubconfirm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@ConditionalOnBean(ConfirmSender.class)
@RestController
public class ConfirmController {
    @Autowired
    private ConfirmSender sender;

    @GetMapping("/mq/pub_confirm")
    public String pubConfirm() {
        sender.sendConfirm();
        return "ok";
    }

    @GetMapping("/mq/pub_return")
    public String pubReturn() {
        sender.sendReturn();
        return "ok";
    }

    @GetMapping("/mq/sub_ack")
    public String subAck() {
        sender.send();
        return "ok";
    }
}

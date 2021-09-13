package com.springboot.amqp.tutorials.rabbitmqtutorials.rpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Profile({"rpc"})
@RestController
public class RpcController {

    @Autowired
    private TutClient client;

    @GetMapping("/mq/rpc")
    public String helloWorld(@RequestParam Integer start) {
        return client.send(start);
    }


}

package com.jsy.rabbitmqprovide;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class NotifyAllProvider {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendMessage(){
        rabbitTemplate.convertAndSend("fanoutExchange","","i am fanout sender");
    }
}

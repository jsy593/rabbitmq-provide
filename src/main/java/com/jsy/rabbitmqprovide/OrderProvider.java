package com.jsy.rabbitmqprovide;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderProvider {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendMessage(){
        rabbitTemplate.convertAndSend("topicExchange","order.log.debug","i am order.log.debug");
        rabbitTemplate.convertAndSend("topicExchange","order.log.info","i am order.log.info");
        rabbitTemplate.convertAndSend("topicExchange","order.log.warn","i am order.log.warn");
        rabbitTemplate.convertAndSend("topicExchange","order.log.error","i am order.log.error");
    }
}

package com.jsy.rabbitmqprovide;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FactorProvider {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendMessage(){
//        rabbitTemplate.convertAndSend("directExchange","factor.log.debug","i am factor.log.debug");
        rabbitTemplate.convertAndSend("directExchange","factor.log.info","i am factor.log.info");
//        rabbitTemplate.convertAndSend("directExchange","factor.log.warn","i am factor.log.warn");
//        rabbitTemplate.convertAndSend("directExchange","factor.log.error","i am factor.log.error");
    }
}

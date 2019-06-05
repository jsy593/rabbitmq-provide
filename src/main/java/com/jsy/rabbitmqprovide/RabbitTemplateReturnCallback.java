package com.jsy.rabbitmqprovide;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * rabbit:template return-callback="returnCallback"设置生效
 */
@Component
public class RabbitTemplateReturnCallback implements RabbitTemplate.ReturnCallback{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final Logger logger = LoggerFactory.getLogger(RabbitTemplateReturnCallback.class);

    @PostConstruct
    public void init(){
        rabbitTemplate.setReturnCallback(this);           //指定 ConfirmCallback
    }
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        logger.info("消息主体 message : "+message);
        logger.info("消息编码 message : "+replyCode);
        logger.info("描述："+replyText);
        logger.info("消息使用的交换器 exchange : "+exchange);
        logger.info("消息使用的路由键 routing : "+routingKey);
    }
}

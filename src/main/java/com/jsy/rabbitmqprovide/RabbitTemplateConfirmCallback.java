package com.jsy.rabbitmqprovide;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * rabbit:connection-factory  publisher-confirms="true"才有效
 * rabbit:template confirm-callback="confirmCallback"
 *
 * 只确认是否正确到达 Exchange 中,至于是否有队列不关心，是否到达队列也不关心
 */
@Component
public class RabbitTemplateConfirmCallback implements RabbitTemplate.ConfirmCallback {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final Logger logger = LoggerFactory.getLogger(RabbitTemplateConfirmCallback.class);

    @PostConstruct
    public void init(){
        rabbitTemplate.setConfirmCallback(this);            //指定 ConfirmCallback
    }
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        logger.info("确认结果："+ack);
        logger.info("失败原因："+cause);
    }
}
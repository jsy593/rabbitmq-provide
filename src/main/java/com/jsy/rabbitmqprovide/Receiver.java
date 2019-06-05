package com.jsy.rabbitmqprovide;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class Receiver {

    @RabbitListener(queues  = "factorLogInfoQueue")
    @RabbitHandler
    public void receiveFactorInfoLogQueueMessage(String msg, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG)long tag){
        System.out.println("factorLogInfoQueue received:"+msg);
        try{
            channel.basicAck(tag,true);
        }catch (IOException e){

        }

    }

    @RabbitListener(queues  = "factorLogWarnQueue")
    @RabbitHandler
    public void receiveFactorWarnLogQueueMessage(String msg){
        System.out.println("factorLogWarnQueue received:"+msg);
    }

    @RabbitListener(queues  = "orderQueue")
    @RabbitHandler
    public void receiveTopicMessage(String msg){
        System.out.println("orderQueue received:"+msg);
    }
}

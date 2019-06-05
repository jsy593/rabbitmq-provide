package com.jsy.rabbitmqprovide;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfigation {
    //direct交换器
    @Bean
    public DirectExchange directExchange(){
       return new DirectExchange("directExchange");
    }
    //topic交换器
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }
    //fanout交换器
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    //保理info级别日志队列
    @Bean
    public Queue factorLogInfoQueue(){
        return new Queue("factorLogInfoQueue");
    }
    //保理warn级别日志队列
    @Bean
    public Queue factorLogWarnQueue(){
        return new Queue("factorLogWarnQueue");
    }
    //订单队列
    @Bean
    public Queue orderQueue(){
        return new Queue("orderQueue");
    }

    //direct模式交换器绑定保理info级别日志队列
    //@Bean
    public Binding directBindFactorLogInfo(@Qualifier("factorLogInfoQueue") Queue queue, DirectExchange directExchange){
       return BindingBuilder.bind(queue).to(directExchange).with("factor.log.info");
    }
    //direct模式交换器绑定保理warn级别日志队列
    @Bean
    public Binding directBindFactorLogWarn(Queue factorLogWarnQueue, DirectExchange directExchange){
        return BindingBuilder.bind(factorLogWarnQueue).to(directExchange).with("factor.log.warn");
    }
    //topic模式交换器绑定订单队列
    @Bean
    public Binding topicBindOrderQueue(@Qualifier("orderQueue") Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("order.log.*");
    }
    //fanout模式交换器绑定所有的队列
    @Bean
    public Binding fanoutBindFactorInfoLogQueue(Queue factorLogInfoQueue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(factorLogInfoQueue).to(fanoutExchange);
    }

    @Bean
    public Binding fanoutBindFactorInfoWarnQueue(Queue factorLogWarnQueue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(factorLogWarnQueue).to(fanoutExchange);
    }
    @Bean
    public Binding fanoutBindOrderQueue(Queue orderQueue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(orderQueue).to(fanoutExchange);
    }
}

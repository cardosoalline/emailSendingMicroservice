package com.mailService.msmail.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.queue}")
    private String queue;

    @Bean //criando o bean da fila
    public Queue queue() {
        return new Queue(queue, true); //nome da fila e duração da fila mesmo q perca o rabbitmq
    }

    @Bean //conversor global
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}

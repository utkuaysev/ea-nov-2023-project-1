package com.project.user.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitMQConfig {
    private final CachingConnectionFactory cachingConnectionFactory;

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("direct-prof-experience-exchange");
    }

    @Bean
    DirectExchange directExchange2() {
        return new DirectExchange("direct-edu-experience-exchange");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("delete-alumni-exchange");
    }


    @Bean
    public Queue directQ2() {
        return new Queue("q2", true);
    }

    @Bean
    public Queue directQ4() {
        return new Queue("q4", true);
    }

    @Bean
    public Queue fanoutQ3() {return new Queue("q3", true);
    }

    @Bean
    public Queue fanoutQ5() {return new Queue("q5", true);
    }


    @Bean
    Binding directQ2Binding(Queue directQ2, DirectExchange directExchange) {
        return BindingBuilder.bind(directQ2).to(directExchange).with("create-update-prof-experience");
    }
    @Bean
    Binding directQ4Binding(Queue directQ4, DirectExchange directExchange2) {
        return BindingBuilder.bind(directQ4).to(directExchange2).with("create-update-edu-experience");
    }

    @Bean
    Binding fanoutQ3Binding(Queue fanoutQ3 , FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQ3).to(fanoutExchange);
    }
    @Bean
    Binding fanoutQ5Binding(Queue fanoutQ5 , FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQ5).to(fanoutExchange);
    }
    @Bean
    public RabbitTemplate rabbitTemplate(Jackson2JsonMessageConverter converter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        rabbitTemplate.setMessageConverter(converter);
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        var jsonMapper = new Jackson2JsonMessageConverter();
        return jsonMapper;
    }

}

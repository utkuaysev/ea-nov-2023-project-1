package com.project.business;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
@EnableDiscoveryClient
@EnableFeignClients
@EnableRabbit
@SpringBootApplication
public class AlumniApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlumniApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
	DirectExchange directExchange() {
		return new DirectExchange("prof-experience-exchange");
	}

	@Bean
	public Queue directQ1() {
		return new Queue("q1", true);
	}

	@Bean
	Binding directQ1Binding(Queue directQ1, DirectExchange directExchange) {
		return BindingBuilder.bind(directQ1).to(directExchange).with("added-prof-experience");
	}


}

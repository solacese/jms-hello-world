package com.solace.jmshelloworld;

import javax.jms.ConnectionFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.util.ErrorHandler;


@SpringBootApplication
@EnableJms
public class JmsHelloWorldApplication {

    @Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
	    DefaultJmsListenerContainerFactoryConfigurer configurer, 
	    ErrorHandler errorHandler) {
	DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	// This provides all boot's default to this factory, including the message
	// converter
	configurer.configure(factory, connectionFactory);
	
	//want to listen on topics
	factory.setPubSubDomain(true);
    factory.setErrorHandler(errorHandler);
	
	// You could still override some of Boot's default if necessary.
	return factory;
    }

    public static void main(String[] args) {
	SpringApplication.run(JmsHelloWorldApplication.class, args);
	
	
    }

}

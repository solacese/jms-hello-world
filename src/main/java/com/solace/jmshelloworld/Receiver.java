package com.solace.jmshelloworld;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "${app.jms.topic}", containerFactory = "myFactory")
    public String receiveMessage(Message message) {
    	if (message instanceof TextMessage) {
	       try {
			System.out.printf("Received <%s>\n", ((TextMessage) message).getText());
		   	return "Hello " + message + "!";

		   } catch (JMSException e) {
			return "Couldn't get message text";
		   }
    	}
	    System.out.printf("Received a message but it isn't text\n");
        return "Not a text message ";
    }
}

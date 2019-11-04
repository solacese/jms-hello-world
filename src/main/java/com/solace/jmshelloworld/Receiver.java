package com.solace.jmshelloworld;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "${app.jms.topic}", containerFactory = "myFactory")
    public String receiveMessage(String message) {
	System.out.printf("Received <%s>\n", message);

	return "Hello " + message + "!";
    }
}

package com.solace.jmshelloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;


@Service
public class DefaultErrorHandler implements ErrorHandler {
	
	@Autowired
	private ApplicationContext context;

    @Override
    public void handleError(Throwable t) {
        System.out.printf("JMS receiver error.  Did you send a text message?\n");
        System.out.printf(t.getCause().getMessage());
        SpringApplication.exit(context);
    }
}

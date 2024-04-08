package com.murshidh.CabBookingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CabBookingAppApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(CabBookingAppApplication.class, args);
		DemoDriver demoDriver = context.getBean(DemoDriver.class);
		demoDriver.executeAllCommands();
	}

}

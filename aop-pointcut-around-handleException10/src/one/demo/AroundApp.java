package one.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import one.demo.config.DemoConfig;
import one.demo.service.TrafficFortuneService;

public class AroundApp {

	public static void main(String[] args) {
 
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean
		TrafficFortuneService trafficService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\nMain program AroundApp");
		System.out.println("calling getFortune");

		String data =trafficService.getFortune();
		System.out.println("\nMy fortune is " +data);
		
		System.out.println("Finished");
		
		
		context.close();
		
		
	}

}

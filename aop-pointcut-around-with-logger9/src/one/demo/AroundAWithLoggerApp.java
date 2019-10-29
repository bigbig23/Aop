package one.demo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import one.demo.config.DemoConfig;
import one.demo.service.TrafficFortuneService;

public class AroundAWithLoggerApp {
	
	//using logger to get an ordered output stream,
	//otherwise with println u get onlu the standard output stream with is not ordered
	private static Logger myLogger = Logger.getLogger(AroundAWithLoggerApp.class.getName());

	public static void main(String[] args) {
 
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean
		TrafficFortuneService trafficService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\nMain program AroundApp");
		myLogger.info("calling getFortune");

		String data =trafficService.getFortune();
		myLogger.info("\nMy fortune is " +data);
		
		myLogger.info("Finished");
		
		
		context.close();
		
		
	}

}

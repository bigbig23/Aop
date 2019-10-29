package one.demo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	public String getFortune() {
	 
		//simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Expect heavy traffic this weekend";
	}

	
	public String getFortune(boolean sudFlag) {
		if(sudFlag) {
			throw new RuntimeException("Roads are closed ");
		}
		// else , return getFortune method 
		return getFortune();
	}
	
	
	
	

}

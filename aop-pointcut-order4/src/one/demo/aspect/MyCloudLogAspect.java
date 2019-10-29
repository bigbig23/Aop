package one.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyCloudLogAspect {
	
	
	
	@Before("one.demo.aspect.AopExpressions.forDaoPackNoGetterSetter()")
	public void logingToCloud() {
		System.out.println("\n-------logingToCloud ...");
	}
	
	

}

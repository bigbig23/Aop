package one.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyApiAnalyticsAspect {
	
	
	@Before("one.demo.aspect.AopExpressions.forDaoPackNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n-------performApiAnalytics ...");
	}
	
	

}

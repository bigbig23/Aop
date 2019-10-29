package one.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(13)
public class MyLoggingAspect {

	@Before("one.demo.aspect.AopExpressions.forDaoPackNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\nExecuting @Before advice addAccount() ...");
	}
	
	
	


	
	
	

}

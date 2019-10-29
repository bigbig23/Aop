package one.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {
	//Here we add all our related advices 
	
	@Pointcut("execution(* one.demo.dao.*.*(..))")
	private void forDaoPackage() {};
 
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\nExecuting @Before advice addAccount() and membershipDAO...");
	}

}

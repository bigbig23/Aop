package one.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import one.demo.Account;

@Aspect
@Component
@Order(13)
public class MyLoggingAspect {

	@Before("one.demo.aspect.AopExpressions.forDaoPackNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\nExecuting @Before advice addAccount() ...");
		
		//Display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("method " +methodSignature);
		
		//Display the method arguments
		Object[] args = theJoinPoint.getArgs();
		
		for(Object o: args) {
			System.out.println(o);
			if(o instanceof Account) {
				Account theAccount = (Account) o;
				System.out.println("Accout name: " + theAccount.getName());
				System.out.println("Accout level: " + theAccount.getLevel1());

			}
		}
		
		
		
		
	}
	
	
	


	
	
	

}

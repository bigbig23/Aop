package one.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {
	//Here we add all our related advices 
	
	//let's add point cut expression @Before advice
	//@Before("execution(public void addAccount())")  //0 param
	//@Before("execution(* add*(one.demo.Account))") //one param
	//@Before("execution(* add*(..))") //one to many params
	@Before("execution(* one.demo.dao.*.*(..))") //match any package with any class and any method with any params
	public void beforeAddAccountAdvice() {
		System.out.println("\nExecuting @Before advice addAccount() and membershipDAO...");
	}

}

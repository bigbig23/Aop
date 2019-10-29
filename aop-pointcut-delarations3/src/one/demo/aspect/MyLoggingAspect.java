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
 
	//createa pointcut for getter methos
	@Pointcut("execution(* one.demo.dao.*.get*(..))")
	private void getterMethod() {}
	//create a poincutfor setter methods
	@Pointcut("execution(* one.demo.dao.*.set*(..))")
	private void setterMethod() {}
	
	//create pointcut include package and exclude the getter/setter
	@Pointcut("forDaoPackage() && !(getterMethod() || setterMethod())")
	private void forDaoPackNoGetterSetter() {}

	
	
	@Before("forDaoPackNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\nExecuting @Before advice addAccount() ...");
	}

}

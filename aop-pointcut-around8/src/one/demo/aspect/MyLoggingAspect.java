package one.demo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	
	//adding aop for @Around

	@Around("execution(* one.demo.service.*.getFortune(..)))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceeding) throws Throwable {
		
		Signature method = theProceeding.getSignature();
		System.out.println("\nExecuting @Around method : " + method);
		
		//get being timestamp
		Long begin = System.currentTimeMillis();
		
		//now exeuting the method 
		Object result = theProceeding.proceed();
		
		//get end timestamp
		Long end = System.currentTimeMillis();
	
		//get duration and display
		Long duration = end - begin;
		System.out.println("\nDuration is : " + duration /1000.0 + " seconds" );
		
		return result;
	}
	
	@AfterThrowing(
			pointcut="execution(* one.demo.dao.AccountDAO.findAccounts(..)))",
			throwing="ex"
			)
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable ex) {
		
		MethodSignature methSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("\nmethod Signature afterthrowing : "+ methSignature );
		
		System.out.println("\nafter throwing : " +ex);
	}
	
	
	
	
	
	//add afterReturning advice for findAccount method
	@AfterReturning(
			pointcut="execution(* one.demo.dao.AccountDAO.findAccounts(..)))",
			returning="result"
			)
	public void afterReturningfindAccountMeth(JoinPoint theJoinPoint, List<Account> result) {
		
		//print out the method
		MethodSignature methSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("\nmethod Signature : "+ methSignature );
		
		//print out the result of method call
		System.out.println("\nresult after returning : " +result);
		
		//we can modify the data before returning it 
		convertAccountNamesToUpperCase(result);
		
		
		
	}
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		for(Account acc: result) {
			 
			String theUpperName = acc.getName().toUpperCase();
			acc.setName(theUpperName);
			
		}
	}


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

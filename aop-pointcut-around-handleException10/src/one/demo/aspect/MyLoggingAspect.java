package one.demo.aspect;

import java.util.List;
import java.util.logging.Logger;

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

	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//adding aop for @Around

	@Around("execution(* one.demo.service.*.getFortune(..)))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceeding) throws Throwable {
		
		Signature method = theProceeding.getSignature();
	myLogger.info("\nExecuting @Around method : " + method);
		
		//get being timestamp
		Long begin = System.currentTimeMillis();
		
		//now exeuting the method 
		Object result = null;
		try {
			result = theProceeding.proceed();
		} catch (Exception e) {
			// log the exception
			myLogger.warning(e.getMessage());
			
			//try this example with only result which is commented and the second ex with throw e these are 2 different examples
			//give the user a custome message
			//result = "A mager accident but no worries, your private AOP helicopter is on the way ";
			
			//to rethrow the exception we just throw e;
			throw e;
		}
		
		//get end timestamp
		Long end = System.currentTimeMillis();
	
		//get duration and display
		Long duration = end - begin;
	myLogger.info("\nDuration is : " + duration /1000.0 + " seconds" );
		
		return result;
	}
	
	
	
	
	
	@AfterThrowing(
			pointcut="execution(* one.demo.dao.AccountDAO.findAccounts(..)))",
			throwing="ex"
			)
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable ex) {
		
		MethodSignature methSignature = (MethodSignature) theJoinPoint.getSignature();
	myLogger.info("\nmethod Signature afterthrowing : "+ methSignature );
		
	myLogger.info("\nafter throwing : " +ex);
	}
	
	
	
	
	
	//add afterReturning advice for findAccount method
	@AfterReturning(
			pointcut="execution(* one.demo.dao.AccountDAO.findAccounts(..)))",
			returning="result"
			)
	public void afterReturningfindAccountMeth(JoinPoint theJoinPoint, List<Account> result) {
		
		//print out the method
		MethodSignature methSignature = (MethodSignature) theJoinPoint.getSignature();
	myLogger.info("\nmethod Signature : "+ methSignature );
		
		//print out the result of method call
	myLogger.info("\nresult after returning : " +result);
		
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
	myLogger.info("\nExecuting @Before advice addAccount() ...");
		
		//Display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
	myLogger.info("method " +methodSignature);
		
		//Display the method arguments
		Object[] args = theJoinPoint.getArgs();
		
		for(Object o: args) {
		myLogger.info(o.toString());
			if(o instanceof Account) {
				Account theAccount = (Account) o;
			myLogger.info("Accout name: " + theAccount.getName());
			myLogger.info("Accout level: " + theAccount.getLevel1());

			}
		}
		
		
		
		
	}
	
	
	


	
	
	

}

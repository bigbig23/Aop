package one.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import one.demo.config.DemoConfig;
import one.demo.dao.AccountDAO;

public class AfterReturningApp {

	public static void main(String[] args) {
 
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccount = theAccountDAO.findAccounts();
		System.out.println("\n main programme method " +theAccount);
		
		System.out.println("\n");
		
		context.close();
		
		
	}

}

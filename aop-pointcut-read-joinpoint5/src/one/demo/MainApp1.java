package one.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import one.demo.config.DemoConfig;
import one.demo.dao.AccountDAO;
import one.demo.dao.MembershipDAO;

public class MainApp1 {

	public static void main(String[] args) {
 
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		
		//get bean
		MembershipDAO theMembership = context.getBean("membershipDAO", MembershipDAO.class);
		
		//call method
		Account theAccount = new Account();
		theAccount.setName("Roaa");
		theAccount.setLevel1("advanced");
		theAccountDAO.addAccount(theAccount,true);
		theAccountDAO.DoHomeWork();
		
		//call setter/getter method
		theAccountDAO.setName("Monay");
		theAccountDAO.setServiceCode("foo");
		theAccountDAO.getName();
		theAccountDAO.getServiceCode();
		
		//call method
		theMembership.addAccount();
		
		System.out.println();
		
		context.close();
		
		
	}

}

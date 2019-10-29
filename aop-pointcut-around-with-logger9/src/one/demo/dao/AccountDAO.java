package one.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import one.demo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	
	public List<Account> findAccounts(boolean sudFla){
		//simulate an exception
		if(sudFla) {
			throw new RuntimeException("exception for sudflag");
		}
		List<Account> accounts = new ArrayList<>();
		
		Account ac1 = new Account("Raed","Mo");	
		Account ac2 = new Account("Hess","Good");
		Account ac3 = new Account("Sah","Best");
		accounts.add(ac1);
		accounts.add(ac2);
		accounts.add(ac3);
		
		return accounts;
	}
	
	
	public void addAccount(Account theAccount, boolean sudanFlag) {
		System.out.println(getClass() + "adding my account ");
	}
	
	
	public void DoHomeWork() {
		System.out.println("Doing my home work every day ah....");
	}
	

	public String getName() {
		System.out.println(getClass() + " getName() ");
		return name;
	}


	public void setName(String name) {
		System.out.println(getClass() + " setName() ");
		this.name = name;
	}


	public String getServiceCode() {
		System.out.println(getClass() + " getServiceCode() ");
		return serviceCode;
	}


	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " setServiceCode() ");
		this.serviceCode = serviceCode;
	}
	
	

}

package one.demo.dao;

import org.springframework.stereotype.Component;

import one.demo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	
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

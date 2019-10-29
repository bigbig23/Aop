package one.demo.dao;

import org.springframework.stereotype.Component;

import one.demo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account theAccount, boolean sudanFlag) {
		System.out.println(getClass() + "adding my account ");
	}
	
	
	public void DoHomeWork() {
		System.out.println("Doing my home work every day ah....");
	}

}

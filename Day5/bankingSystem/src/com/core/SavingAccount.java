package com.core;

public class SavingAccount extends BankAccount{
	private double interestRate;

	public SavingAccount(int accountnumber, double balance, String customer_name, String phone_number,double interestRate) {
         
		super( accountnumber,  balance,  customer_name,  phone_number);
		
		this.interestRate = interestRate;
	
	}

}

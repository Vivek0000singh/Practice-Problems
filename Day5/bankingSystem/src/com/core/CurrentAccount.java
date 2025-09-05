package com.core;

public class CurrentAccount extends BankAccount {

	private int overdraftLimit;

	public CurrentAccount(int accountnumber, double balance, String customer_name, String phone_number,
			int overdraftLimit) {

		super(accountnumber, balance, customer_name, phone_number);
		this.overdraftLimit = overdraftLimit;
		// TODO Auto-generated constructor stub
	}

}

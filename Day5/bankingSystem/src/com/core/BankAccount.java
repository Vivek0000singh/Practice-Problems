package com.core;

public class BankAccount {
	private int accountnumber;
	private double balance;
	private String customer_name;
	private String phone_number;

	public BankAccount(int accountnumber, double balance, String customer_name, String phone_number) {

		this.accountnumber = accountnumber;
		this.balance = balance;
		this.customer_name = customer_name;
		this.phone_number = phone_number;
	}

	public String toString() {
		return "Account number: " + accountnumber + "balance: " + balance + "Customer name: " + customer_name
				+ "Phone number: " + phone_number;
	}

//	public String withdraw() {
//		return withdraw;
//
//	}

	public double getBalance() {
		return this.balance = balance;
	}

}

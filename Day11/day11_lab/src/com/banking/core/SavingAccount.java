package com.banking.core;

import java.time.LocalDate;

public class SavingAccount extends BankAccount {
    private double interestRate; 

	public SavingAccount(int accountNumber, double balance, String customerName, String phoneNumber,
			double interestRate,LocalDate dob,AccountType acType) {
		super(accountNumber, balance, customerName, phoneNumber,dob,acType);
		this.interestRate = interestRate;
	}  
     //Saving account specific  method
    public void applyInterest() {
        double interest = getBalance() * interestRate / 100;
        setBalance(getBalance() + interest);
        System.out.println("Interest applied: " + interest + ". New balance = " + getBalance());
    }
	@Override
	public String toString() {
		return "SavingAccount "+super.toString()+" [interestRate=" + interestRate + "]";
	}
    
}

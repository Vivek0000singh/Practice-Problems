package com.banking.service;

import java.time.LocalDate;
import java.util.List;

import com.banking.core.AccountType;
import com.banking.core.BankAccount;
import com.banking.custom_exceptions.BankingException;

public interface BankService {
	
	String  OpenAccount(int accountNumber, double balance, String customerName, String phoneNumber,
			double rateOrLimit,LocalDate dob,AccountType acType) throws BankingException;
//	
//	String OpenCurrentAccount(int accountNumber,double balance, String customerName,
//			String phoneNumber, double overdraftLimit,LocalDate dob,AccountType acType) throws BankingException;
//	
	
	String withdraw(int accountNumber,double amount)throws BankingException;
	
	String deposit(int accountNumber,double amount)throws BankingException;
	
	String transferFunds(int srcAccountNo,int destAccountNo,double amount)throws BankingException;
	
	String closeAccount(int accountNumber)throws BankingException;
	String applyInterestToAllSavings()throws BankingException;
	
	
	List<String> getPhoneNumberByAccountTypeAndBalance();
	
	List<BankAccount> getAccountSortedByAccountNo();
	
	String DeleteAllCurrentAccounts();
	
	List<BankAccount> getAllAccounts();
	
	
	void displayAccountDetails();

}

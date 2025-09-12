package com.banking.validations;

import java.time.LocalDate;
import java.util.List;

import com.banking.core.AccountType;
import com.banking.core.BankAccount;
import com.banking.core.CurrentAccount;
import com.banking.core.SavingAccount;
import com.banking.custom_exceptions.BankingException;

public class BankingValidations {
	//add a public static method to check for duplicate account no.
	
	public  static void checkForDuplicate(int accountNumber,List<BankAccount>accountList)throws BankingException{
		BankAccount a=new BankAccount(accountNumber);
		if(accountList.contains(a)) {
			throw new BankingException("Dup Acc no Detected !!!");
		}
	}
	
	public static AccountType  checkForAccountType(String actType) throws IllegalArgumentException {
		
		return AccountType.valueOf(actType.toUpperCase());
		

	}
	
	
	public static BankAccount validateAllInputs(int accountNumber, double balance, String customerName, String phoneNumber,String dob,String acType,double rateOrLimit,List<BankAccount>accountList)throws BankingException 
	{
		
		checkForDuplicate(accountNumber,accountList);
		
		
		AccountType type=checkForAccountType(acType);
		LocalDate birthDate=LocalDate.parse(dob);
		
		if(type.equals(AccountType.SAVING)) {
			return new SavingAccount(accountNumber,balance,customerName,phoneNumber,rateOrLimit,birthDate,type);
		}else {
			return new CurrentAccount(accountNumber, balance, customerName, phoneNumber, rateOrLimit, birthDate, type);
		}
		
		
		
	}

}

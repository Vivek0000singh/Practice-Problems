package com.banking.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.banking.core.AccountType;
import com.banking.core.BankAccount;
import com.banking.core.CurrentAccount;
import com.banking.core.SavingAccount;
import com.banking.custom_exceptions.BankingException;
import com.banking.validations.BankingValidations;

public class BankServiceImpl implements BankService {
	
	private List<BankAccount> accounts=new ArrayList<>();
	

	@Override
	public String OpenAccount(int accountNumber, double balance, String customerName, String phoneNumber,
			double rateOrLimit, LocalDate dob, AccountType acType) throws BankingException {

           BankAccount account=BankingValidations.validateAllInputs(accountNumber, balance, customerName, phoneNumber,dob.toString(),acType.toString() ,rateOrLimit, accounts);
           
           accounts.add(account);
           return "Account opened Successfully: " + accountNumber;
	}

	private BankAccount findAccount(int accountNumber)throws BankingException{
		for(BankAccount account:accounts) {
			if(account.getAccountNumber()==accountNumber) {
				return account;
			}
		}
		throw  new BankingException("Account not found: "+accountNumber);
	}
	
	  
    @Override
    public String withdraw(int accountNumber, double amount) throws BankingException {
        BankAccount account = findAccount(accountNumber);
        account.withdraw(amount);
        return "Withdrawal successful from account: " + accountNumber;
    }
    
    @Override
    public String deposit(int accountNumber, double amount) throws BankingException {
        BankAccount account = findAccount(accountNumber);
        account.deposit(amount);
        return "Deposit successful to account: " + accountNumber;
    }
    
    @Override
    public String transferFunds(int srcAccountNo, int destAccountNo, double amount) throws BankingException {
        BankAccount srcAccount = findAccount(srcAccountNo);
        BankAccount destAccount = findAccount(destAccountNo);
        
        srcAccount.withdraw(amount);
        destAccount.deposit(amount);
        
        return "Transfer successful from account " + srcAccountNo + " to account " + destAccountNo;
    }
    
    @Override
    public String closeAccount(int accountNumber) throws BankingException {
        BankAccount account = findAccount(accountNumber);
        accounts.remove(account);
        return "Account closed successfully: " + accountNumber;
    }
    
    @Override
    public String applyInterestToAllSavings() throws BankingException {
        int count = 0;
        for (BankAccount account : accounts) {
            if (account instanceof SavingAccount) {
                ((SavingAccount) account).applyInterest();
                count++;
            }
        }
        return "Interest applied to " + count + " saving accounts";
    }
    
//    public List<String> getPhoneNumbersByAccountTypeAndBalance(AccountType acType, double minBalance) {
//        List<String> phoneNumbers = new ArrayList<>();
//        for (BankAccount account : accounts) {
//            if (account.getAcType() == acType && account.getBalance() > minBalance) {
//                phoneNumbers.add(account.getPhoneNumber());
//            }
//        }
//        return phoneNumbers;
//    }
    
//    public List<BankAccount> getAccountsSortedByAccountNo() {
//        List<BankAccount> sortedAccounts = new ArrayList<>(accounts);
//        Collections.sort(sortedAccounts, Comparator.comparingInt(BankAccount::getAccountNumber));
//        return sortedAccounts;
//    }
    
    public String deleteAllCurrentAccounts() {
        int count = 0;
        Iterator<BankAccount> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            BankAccount account = iterator.next();
            if (account instanceof CurrentAccount) {
                iterator.remove();
                count++;
            }
        }
        return "Deleted " + count + " current accounts";
    }
    
    @Override
    public List<BankAccount> getAllAccounts() {
        return new ArrayList<>(accounts);
    }
}
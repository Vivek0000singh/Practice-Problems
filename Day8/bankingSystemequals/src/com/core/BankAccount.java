package com.core;

public class BankAccount {
    private int accountNumber;
    private double balance;
    private String customerName;
    private String phoneNumber;

    public BankAccount(int accountNumber, double balance, String customerName, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient balance! Available: " + balance);
        }
        balance -= amount;
    }

    // Getters
    public int getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public String getCustomerName() { return customerName; }
    public String getPhoneNumber() { return phoneNumber; }

    @Override
    public String toString() {
        return "Account: " + accountNumber + ", Balance: " + balance + ", Name: " + customerName + ", Phone: " + phoneNumber;
    }

    
    
    

//  @Override
//  public boolean equals(Object obj) {   
//	  
//
//	
//
//      // Two accounts are considered equal if they have the same account number
//      return this.getAccountNumber() == obj.getAccountNumber();
//  }
//}


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Same object reference
        if (!(obj instanceof BankAccount)) return false; // Not a BankAccount
        BankAccount other = (BankAccount) obj; // Type casting
        return this.accountNumber == other.accountNumber; // Compare account numbers
    }

}




























































//if (!(obj instanceof BankAccount)) return false;
//if (this == obj) return true;







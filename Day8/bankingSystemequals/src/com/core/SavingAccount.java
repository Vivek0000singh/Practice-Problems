package com.core;

public class SavingAccount extends BankAccount {
    private double interestRate;

    public SavingAccount(int accountNumber, double balance, String customerName, String phoneNumber, double interestRate) {
        super(accountNumber, balance, customerName, phoneNumber);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }
        
        // Minimum balance check - 1000 rupees
        if (getBalance() - amount < 1000) {
            throw new InsufficientFundsException("Withdrawal failed! Minimum balance of 1000 required");
        }
        
        super.withdraw(amount);
    }

    public void applyInterest() throws InvalidAmountException {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
    }

    @Override
    public String toString() {
        return super.toString() + ", Interest Rate: " + interestRate + "%";
    }
    
    



}

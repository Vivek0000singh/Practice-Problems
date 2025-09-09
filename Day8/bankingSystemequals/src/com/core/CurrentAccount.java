package com.core;

public class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(int accountNumber, double balance, String customerName, String phoneNumber, double overdraftLimit) {
        super(accountNumber, balance, customerName, phoneNumber);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }
        
        double currentBalance = getBalance();
        
        if (currentBalance >= amount) {
            super.withdraw(amount);
        } else if (currentBalance + overdraftLimit >= amount) {
            double overdraftUsed = amount - currentBalance;
            super.withdraw(currentBalance);
            overdraftLimit -= overdraftUsed;
        } else {
            throw new InsufficientFundsException("Transaction declined! Insufficient funds and overdraft limit");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Overdraft Limit: " + overdraftLimit;
    }
}
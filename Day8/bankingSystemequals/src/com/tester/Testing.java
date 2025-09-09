package com.tester;
import java.util.Scanner;
import com.core.BankAccount;
import com.core.CurrentAccount;
import com.core.SavingAccount;
import com.core.InsufficientFundsException;
import com.core.InvalidAmountException;

public class Testing {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
        System.out.println("Welcome to ABC Bank ");
        
        BankAccount[] Acc = new BankAccount[100];
        int counter = 0;
        boolean exit = false;
        
        while(!exit) {
            try {
                System.out.println("\n1. Open Saving account");
                System.out.println("2. Open Current account");
                System.out.println("3. Display account summary");
                System.out.println("4. Deposit");
                System.out.println("5. Withdraw");
                System.out.println("6. Apply Interest");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                
                int choice = sc.nextInt();
                
                switch(choice) {
                 
                    	
                    case 1: // Open Saving account
                        System.out.println("Enter Account Details (accountNumber, balance, name, phone, interestRate):");
                        int savingAccNo = sc.nextInt();
                        double savingBalance = sc.nextDouble();
                        String savingName = sc.next();
                        String savingPhone = sc.next();
                        double interestRate = sc.nextDouble();
                        
                        // Create a temporary account object for validation
                        SavingAccount temp= new SavingAccount(savingAccNo, savingBalance, savingName, savingPhone, interestRate);
                        
                        // Check for duplicate account number
                        boolean duplicateSaving = false;
                        
                        
                        for (int i = 0; i < counter; i++) {
                            if (Acc[i].equals(temp)) {
                            	duplicateSaving = true;
                                break;
                            }
                        }
                        
                        if (duplicateSaving==true) {
                            System.out.println("Error: Account with number " + savingAccNo + " already exists!");
                        } else {
                            Acc[counter] = temp;
                            counter++;
                            System.out.println("Saving Account registered!");
                        }
                        break;
                        
                        
//                    case 1:
                        
//                        System.out.println("Enter Account Details (accountNumber, balance, name, phone, interestRate):");
//                        
//                       
//                        Acc[counter] = new SavingAccount(sc.nextInt(), sc.nextDouble(), sc.next(), sc.next(), sc.nextDouble());
//                        counter++;
//                        System.out.println("Saving Account registered!");
//                        break;
//                        
                        
                        
                        
                    case 2:
                        System.out.println("Enter Account Details (accountNumber, balance, name, phone, overdraftLimit):");
                        Acc[counter] = new CurrentAccount(sc.nextInt(), sc.nextDouble(), sc.next(), sc.next(), sc.nextInt());
                        counter++;
                        System.out.println("Current Account registered!");
                        break;
                        
                    case 3:
                        System.out.print("Enter account number: ");
                        int accNo = sc.nextInt();
                        boolean found = false;
                        for (BankAccount ba : Acc) {
                            if (ba != null && ba.getAccountNumber() == accNo) {
                                System.out.println("Account Summary:");
                                System.out.println(ba);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Account not found!");
                        }
                        break;
                        
                    case 4: // Deposit
                        try {
                            System.out.print("Enter account number: ");
                            int depositAccNo = sc.nextInt();
                            System.out.print("Enter amount to deposit: ");
                            double depositAmount = sc.nextDouble();
                            
                            boolean depositFound = false;
                            for (BankAccount ba : Acc) {
                                if (ba != null && ba.getAccountNumber() == depositAccNo) {
                                    ba.deposit(depositAmount);
                                    System.out.println("Deposit successful! New balance: " + ba.getBalance());
                                    depositFound = true;
                                    break;
                                }
                            }
                            if (!depositFound) {
                                System.out.println("Account not found!");
                            }
                        } catch (InvalidAmountException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                        
                    case 5:
                    	try {
                            System.out.print("Enter account number: ");
                            int withdrawAccNo = sc.nextInt();
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawAmount = sc.nextDouble();
                            boolean withdrawFound = false;
                            for (BankAccount ba : Acc) {
                                if (ba != null && ba.getAccountNumber() == withdrawAccNo) {
                                    ba.withdraw(withdrawAmount);
                                    System.out.println("Withdrawal successful! New balance: " + ba.getBalance());
                                    withdrawFound = true;
                                    break;
                                }
                            }
                            if (!withdrawFound) {
                                System.out.println("Account not found!");
                            }
                        } catch (InvalidAmountException | InsufficientFundsException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                        
                    case 6: // Apply Interest
                        try {
                            System.out.print("Enter saving account number: ");
                            int interestAccNo = sc.nextInt();
                            
                            boolean interestFound = false;
                            for (BankAccount ba : Acc) {
                                if (ba != null && ba instanceof SavingAccount && ba.getAccountNumber() == interestAccNo) {
                                    ((SavingAccount)ba).applyInterest();
                                    System.out.println("Interest applied! New balance: " + ba.getBalance());
                                    interestFound = true;
                                    break;
                                }
                            }
                            if (!interestFound) {
                                System.out.println("Saving account not found!");
                            }
                        } catch (InvalidAmountException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                        
                    case 0:
                        exit = true;
                        System.out.println("Thank you for banking with us!");
                        break;
                        
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid input");
                sc.nextLine(); // clear buffer
            }
        }
        }
     
    }
}
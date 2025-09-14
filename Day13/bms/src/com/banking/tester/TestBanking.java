
package com.banking.tester;

import java.time.LocalDate;
import java.util.Scanner;

import com.banking.core.AccountType;
import com.banking.service.BankService;
import com.banking.service.BankServiceImpl;

public class TestBanking {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			
			
			BankService service = new BankServiceImpl();

	

			boolean exit = false;

			while (!exit) {
				try {
					System.out.println("\n1. Open Saving account");
                    System.out.println("2. Open Current account");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Deposit");
                    System.out.println("5. Transfer funds");
                    System.out.println("6. Close Account");
                    System.out.println("7. Apply Interest to all saving accounts");
                    System.out.println("8. Display phone numbers");
                    System.out.println("9. Display Accounts sorted by account no");
                    System.out.println("10. Delete All Current Accounts");
                    System.out.println("0. Exit");

					int choice = sc.nextInt();

					switch (choice) {

					case 1: // Open Saving account
						
						 System.out.println("Enter Account Details (accountNumber, balance, name, phone, interestRate, dob(yyyy-mm-dd):");
	                        int AccNo = sc.nextInt();
	                        double Balance = sc.nextDouble();
	                        String Name = sc.next();
	                        String Phone = sc.next();
	                        double interestRate = sc.nextDouble();
	                        String dobstr=sc.next();
	                        LocalDate dob=LocalDate.parse(dobstr);
	                        
	                     System.out.println(service.OpenAccount(AccNo,Balance,Name,Phone,interestRate, dob, AccountType.SAVING));
						
						
						break;

					case 2: // Open  current Accont
						
						System.out.println("Enter Account Details (AccountNumber,balance,Name,phone,overdraftLimit,dob(yyyy-mm-dd)");
						
						int accNo2=sc.nextInt();
						double balance2=sc.nextDouble();
						String name2=sc.next();
						String phone2=sc.next();
						double overdraftLimit=sc.nextDouble();
						 String dobStr2 = sc.next();
                         LocalDate dob2 = LocalDate.parse(dobStr2);
                         
                         String result2 = service.OpenAccount(accNo2, balance2, name2, phone2, 
                                 overdraftLimit, dob2, AccountType.CURRENT);
                         System.out.println(result2);
                         break;

					case 3:// Withdraw
						
						System.out.println("Enter acc no. and amount");
						
						int  accNoWithdraw=sc.nextInt();
						double amountWithdraw=sc.nextDouble();
						
						System.out.println(service.withdraw(accNoWithdraw, amountWithdraw));

						break;

					case 4: // Deposit
						
						System.out.println("Enter acc no and amount to deposit");
						
						int accNoDeposit=sc.nextInt();
						double amountDeposit=sc.nextDouble();
						System.out.println(service.deposit(accNoDeposit, amountDeposit));
						break;

					case 5:// transfer Amount
						System.out.println("Enter source account,destination account and amount to transfer :");
						
						int srcAcc=sc.nextInt();
						int desAcc=sc.nextInt();
						
						double transferAmount=sc.nextDouble();
						System.out.println(service.transferFunds(srcAcc, desAcc, transferAmount));
						break;

					case 6: // close account
						
						System.out.println("Enter acc no to close :");
						int accnoclose=sc.nextInt();
						System.out.println(service.closeAccount(accnoclose));
						break;

					case 7:// Apply interest
						
						System.out.println(service.applyInterestToAllSavings());

						break;

					case 8: // Display Phone numbers
						break;

					case 9://

						break;
					case 10:// Delete All current accounts
						
						System.out.println(service.DeleteAllCurrentAccounts());

						break;

					case 0:
						exit = true;
						System.out.println("Exiting...GoodBye!");

						break;

					}
				} catch (Exception e) {
					System.out.println("Error: t"+ e.getMessage());
					sc.nextLine(); // clear buffer
				}
			}

		}
	}
}

//	    }
//	}
//		try {
//			for (BankAccount acc : accounts) {
//				System.out.println(acc);
//				// Run time polymorphism - withdraw
//				acc.withdraw(6000);
//				// Subclass-specific logic (downcasting)
//				if (acc instanceof SavingAccount) {
//					SavingAccount sa = (SavingAccount) acc;
//					sa.applyInterest();
//				} else if (acc instanceof CurrentAccount) {
//					CurrentAccount ca = (CurrentAccount) acc;
//					ca.increaseOverdraftLimit(200);
//				}
//				System.out.println();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}

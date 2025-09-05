package com.tester;
import java.util.Scanner;

import com.core.BankAccount;
import com.core.CurrentAccount;
import com.core.SavingAccount;


public class Testing {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Welcome to ABC Bank ");
		
		BankAccount [] Acc=new BankAccount[100];
		int counter=0;
		
		boolean exit=false;
		
		while(!exit) {
			
			System.out.println("1. Open Saving account\n"
					+ "2. Current account\r\n"
					
					+ "3. Display account summary\r\n"
					
					+ "4. Deposit\r\n"
					
					+ "5. Withdraw\r\n"
					
					+ "0.Exit");

            
            switch(sc.nextInt()) {
                case 1:
                    // Open Saving account logic
                    System.out.println("Saving account opening selected");
                    if (counter < Acc.length) {
    					System.out.println("Enter Account Details -");
    					Acc[counter] = new SavingAccount(sc.nextInt(), sc.nextDouble(), sc.next(), sc.next(),sc.nextDouble());
    							
    					counter++;
    					System.out.println("Account registered !!!!");
    				} else
    					System.out.println("Sorry Account is Full !!!!");
                    break;
                    
                case 2:
                    // Open Current account logic  
                    System.out.println("Current account opening selected");
                    if (counter < Acc.length) {
    					System.out.println("Enter Account Details -");
    					Acc[counter] = new CurrentAccount(sc.nextInt(), sc.nextDouble(), sc.next(), sc.next(),sc.nextInt());
    							
    					counter++;
    					System.out.println("Account registered !!!!");
    				} else
    					System.out.println("Sorry Account is Full !!!!");
                    break;
                    
                    
                case 3:
                    // Display account summary logic
                    System.out.println("Display account summary selected");
                    
                	for (BankAccount ba : Acc) {//
    					if (ba != null) {
    						System.out.println(ba);
    					}
    				}
                    break;
                    
                case 4:
                    // Deposit logic
                    System.out.println("Deposit selected");
                    break;
                    
                case 5:
                    // Withdraw logic
                    System.out.println("Withdraw selected");
                    break;
                    
                case 0:
                    exit = true;
                    System.out.println("Thank you for banking with us!");
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        
        sc.close();
			
		}
}
		
		
		// TODO Auto-generated method stub

	

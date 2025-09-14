package com.banking.tester;

import java.util.ArrayList;

import com.banking.core.BankAccount;
import com.banking.custom_exceptions.BankingException;
import com.banking.validations.BankingValidations;

public class Tst1 {

	

	public static void main(String[] args)throws BankingException {
		// TODO Auto-generated method stub
		
		ArrayList<BankAccount>list=new ArrayList<>();
		list.add(new BankAccount(101,1000,"abc",null,null,null));
		list.add(new BankAccount(102,2000,"abc",null,null,null));
		list.add(new BankAccount(101,3000,"abc",null,null,null));
		
       for(BankAccount a:list)
    	   System.out.println(a);
       
//       BankingValidations.checkForDuplicate(101,list);
       
      
       System.out.println( BankingValidations.checkForAccountType("saving"));
	}

}

package com.service;

import com.core.ShoeType;
import com.custom_handling.ShoeHandlingException;

public class ShoeServiceValidation {

	public static void Validatename(String name) throws ShoeHandlingException {

		if (name.length() < 3 || name.length() > 20) {
			throw new ShoeHandlingException("Length of name should be 3 to 20");
		}

		return;
	}

	public static void ValidateRating(int rating) throws ShoeHandlingException {
		if (rating < 1 || rating > 10) {
			throw new ShoeHandlingException("Rating shoulb be between 1 to 10 ");
		}
		return ;
	}
	
	
	public static ShoeType parseAndValidateShoeType(String type) throws ShoeHandlingException{
		    
		try {
			
			return ShoeType.valueOf(type.trim().toUpperCase());
			
		} catch (IllegalArgumentException e) {
			throw new ShoeHandlingException("Invalid Shoe Type...");
		}
		
	}

}
package com.service;

import com.core.PhoneType;
import com.custom_exception.MobileHandlingException;

public class MobileValidation {
	
	public static void validateRatings(int Ratings)throws MobileHandlingException{
		if(Ratings<1 || Ratings>5) {
			throw new MobileHandlingException("Rating must between 1 and 5");
		}
	}
	
	
	public static void modelName(String name)throws MobileHandlingException{
		if(name.length()<2 || name.length()>15) {
			throw new MobileHandlingException("Model name should be between 2 to 15 characters");
		}
	}
	
	public static PhoneType parseAndValidatePhoneType(String type)throws MobileHandlingException {
		
		try {
			return PhoneType.valueOf(type.trim().toUpperCase());
			
		} catch (IllegalArgumentException e) {
            
			throw new MobileHandlingException("phone type not matched");
		}
		
	}

}

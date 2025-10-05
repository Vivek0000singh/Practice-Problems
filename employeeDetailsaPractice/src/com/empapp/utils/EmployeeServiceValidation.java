package com.empapp.utils;

import com.empapp.core.Employee;
import com.empapp.custom_exceptions.EmployeeHandlingException;

import java.util.Map;

public class EmployeeServiceValidation {

	public static void validatePhoneNumber(String phone) throws EmployeeHandlingException {
		String trimmedPhoneString=phone.trim();
		String PhoneReg = "^[0-9]{10}$";
		if (!trimmedPhoneString.matches(PhoneReg)) {
			throw new EmployeeHandlingException("Invalid Phone Number: Must be exactly 10 digits.");
		}
	}

	public static void validateAadhaarNumber(String aadhaar) throws EmployeeHandlingException {
        
		String trimmedAadhaarString=aadhaar.trim();
		String aadharRegString = "^\\d{12}$";
		if (!trimmedAadhaarString.matches(aadharRegString)) {
			throw new EmployeeHandlingException("Invalid Aadhaar Number: Must be exactly 12 digits with no spaces.");
		}
	}


	public static void checkForDuplicateAadhaar(String aadhaar, Map<Integer, Employee> employeeMap)
			throws EmployeeHandlingException {
		for (Employee emp : employeeMap.values()) {
			if (emp.getAadhaarNumber().equals(aadhaar)) {
				throw new EmployeeHandlingException(
						"Duplicate Aadhaar Number: An employee with this Aadhaar already exists.");
			}
		}
	}
}

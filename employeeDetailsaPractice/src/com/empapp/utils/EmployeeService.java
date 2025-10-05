package com.empapp.utils;

import com.empapp.core.Employee;
import com.empapp.custom_exceptions.EmployeeHandlingException;
import java.util.List;

public interface EmployeeService {

	String addFullTimeEmployee(String name, String joiningDate, String phone, String aadhaar, double salary)
			throws EmployeeHandlingException;

	String addPartTimeEmployee(String name, String joiningDate, String phone, String aadhaar, double hourlyPayment)
			throws EmployeeHandlingException;

	String deleteEmployeeById(int empId) throws EmployeeHandlingException;

	Employee searchEmployeeByAadhaar(String aadhaar) throws EmployeeHandlingException;

	List<Employee> getAllEmployees();

	List<Employee> getAllEmployeesSortedByJoiningDate();
}

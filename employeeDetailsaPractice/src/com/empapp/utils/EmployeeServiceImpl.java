package com.empapp.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.empapp.core.Employee;
import com.empapp.core.FullTimeEmployee;
import com.empapp.core.PartTimeEmployee;
import com.empapp.custom_exceptions.EmployeeHandlingException;

public class EmployeeServiceImpl implements EmployeeService {

	private Map<Integer, Employee> employeeMap;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }

    @Override
    public String addFullTimeEmployee(String name, String dateStr, String phone, String aadhaar, double salary) throws EmployeeHandlingException {
        // Perform all validations
    
        EmployeeServiceValidation.validatePhoneNumber(phone);
        EmployeeServiceValidation.validateAadhaarNumber(aadhaar);
        EmployeeServiceValidation.checkForDuplicateAadhaar(aadhaar, employeeMap);

        
        FullTimeEmployee fte = new FullTimeEmployee(name, LocalDate.parse(dateStr), phone, aadhaar, salary);
        employeeMap.put(fte.getEmpId(), fte);
        return " Full Time Employee added successfully with ID: " + fte.getEmpId();
    }

    @Override
    public String addPartTimeEmployee(String name, String dateStr, String phone, String aadhaar, double hourlyPayment) throws EmployeeHandlingException {
        // Perform all validations
    	
        EmployeeServiceValidation.validatePhoneNumber(phone);
        EmployeeServiceValidation.validateAadhaarNumber(aadhaar);
        EmployeeServiceValidation.checkForDuplicateAadhaar(aadhaar, employeeMap);

        // Create and add the employee
        PartTimeEmployee pte = new PartTimeEmployee(name, LocalDate.parse(dateStr), phone, aadhaar, hourlyPayment);
        employeeMap.put(pte.getEmpId(), pte);
        return " Part Time Employee added successfully with ID: " + pte.getEmpId();
    }

    @Override
    public String deleteEmployeeById(int empId) throws EmployeeHandlingException {
        if (employeeMap.remove(empId) != null) {
            return " Employee with ID " + empId + " deleted.";
        }
        throw new EmployeeHandlingException(" Employee with ID " + empId + " not found.");
    }

    @Override
    public Employee searchEmployeeByAadhaar(String aadhaar) throws EmployeeHandlingException {
        for (Employee emp : employeeMap.values()) {
            if (emp.getAadhaarNumber().equals(aadhaar)) {
                return emp;
            }
        }
        throw new EmployeeHandlingException(" Employee with Aadhaar " + aadhaar + " not found.");
    }

    @Override
    public List<Employee> getAllEmployees() {

    	return new ArrayList<>(employeeMap.values());
    }

    @Override
    public List<Employee> getAllEmployeesSortedByJoiningDate() {
        List<Employee> sortedList = new ArrayList<>(employeeMap.values());
        Collections.sort(sortedList);
        return sortedList;
    }
}

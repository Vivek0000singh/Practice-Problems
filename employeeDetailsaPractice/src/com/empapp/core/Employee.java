package com.empapp.core;

import java.time.LocalDate;


public  class Employee implements Comparable<Employee> {
	
    private static int idCounter = 100; 

    private int empId;
    private String name;
    private LocalDate joiningDate;
    private String phoneNumber;
    private String aadhaarNumber;

    public Employee(String name, LocalDate joiningDate, String phoneNumber, String aadhaarNumber) {
        this.empId = ++idCounter;
        this.name = name;
        this.joiningDate = joiningDate;
        this.phoneNumber = phoneNumber;
        this.aadhaarNumber = aadhaarNumber;
    }

   
    public int getEmpId() { return empId; }
    public String getName() { return name; }
    public LocalDate getJoiningDate() { return joiningDate; }
    public String getAadhaarNumber() { return aadhaarNumber; }

    @Override
    public String toString() {
        return "Employee [ID=" + empId + ", Name=" + name + ", Joining Date=" + joiningDate +
               ", Phone=" + phoneNumber + ", Aadhaar=" + aadhaarNumber;
    }

   
    @Override
    public boolean equals(Object o) {
        if (o instanceof Employee) {
            Employee other = (Employee) o;
            return this.aadhaarNumber.equals(other.aadhaarNumber);
        }
        return false;
    }

   
    @Override
    public int compareTo(Employee other) {
        return this.joiningDate.compareTo(other.getJoiningDate());
    }
}

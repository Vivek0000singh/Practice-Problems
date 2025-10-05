package com.empapp.core;

import java.time.LocalDate;

public class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, LocalDate joiningDate, String phoneNumber, String aadhaarNumber, double monthlySalary) {
        super(name, joiningDate, phoneNumber, aadhaarNumber);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Type=Full-Time, Salary=" + monthlySalary + "]";
    }
}

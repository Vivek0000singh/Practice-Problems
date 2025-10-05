package com.empapp.core;

import java.time.LocalDate;

public class PartTimeEmployee extends Employee {
    private double hourlyPayment;

    public PartTimeEmployee(String name, LocalDate joiningDate, String phoneNumber, String aadhaarNumber, double hourlyPayment) {
        super(name, joiningDate, phoneNumber, aadhaarNumber);
        this.hourlyPayment = hourlyPayment;
    }

    @Override
    public String toString() {
        // Appends specific PTE details to the base class's toString output
        return super.toString() + ", Type=Part-Time, Hourly Payment=" + hourlyPayment + "]";
    }
}

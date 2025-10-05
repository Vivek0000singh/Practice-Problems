package com.empapp.tester;

import com.empapp.core.Employee;
import com.empapp.custom_exceptions.EmployeeHandlingException;
import com.empapp.utils.EmployeeService;
import com.empapp.utils.EmployeeServiceImpl;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementApp {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

        	EmployeeService service = new EmployeeServiceImpl();
            boolean exit = false;

            while (!exit) {
                System.out.println("\n===== Employee Management Menu =====");
                System.out.println("1. Add Full Time Employee");
                System.out.println("2. Add Part Time Employee");
                System.out.println("3. Delete an Employee by ID");
                System.out.println("4. Search Employee by Aadhaar Number");
                System.out.println("5. Display All Employee Details");
                System.out.println("6. Display All Employees Sorted by Joining Date");
                System.out.println("0. Exit");
                System.out.print(" Choose an option: ");

                try {
                    int choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1: // Add FTE
                            System.out.print("Enter Name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter Joining Date (YYYY-MM-DD): ");
                            String date = sc.nextLine();
                            System.out.print("Enter Phone Number: ");
                            String phone = sc.nextLine();
                            System.out.print("Enter Aadhaar Number: ");
                            String aadhaar = sc.nextLine();
                            System.out.print("Enter Monthly Salary: ");
                            double salary = Double.parseDouble(sc.nextLine());

                            System.out.println(service.addFullTimeEmployee(name, date, phone, aadhaar, salary));
                            break;

                        case 2: // Add PTE
                             System.out.print("Enter Name: ");
                             name = sc.nextLine();
                             System.out.print("Enter Joining Date (YYYY-MM-DD): ");
                             date = sc.nextLine();
                             System.out.print("Enter Phone Number: ");
                             phone = sc.nextLine();
                             System.out.print("Enter Aadhaar Number: ");
                             aadhaar = sc.nextLine();
                             System.out.print("Enter Hourly Payment: ");
                             double payment = Double.parseDouble(sc.nextLine());

                             System.out.println(service.addPartTimeEmployee(name, date, phone, aadhaar, payment));
                            break;

                        case 3: // Delete Employee
                            System.out.print("Enter Employee ID to delete: ");
                            int empId = Integer.parseInt(sc.nextLine());
                            System.out.println(service.deleteEmployeeById(empId));
                            break;

                        case 4: // Search by Aadhaar
                            System.out.print("Enter Aadhaar Number to search: ");
                            String searchAadhaar = sc.nextLine();
                            System.out.println(" Employee Found: " +  service.searchEmployeeByAadhaar(searchAadhaar));
                            break;

                        case 5: // Display All
                            System.out.println("\n--- All Employee Details ---");
                            List<Employee> allEmployees = service.getAllEmployees();
                            if (allEmployees.isEmpty()) {
                               throw new EmployeeHandlingException("No employees in the system.");
                            } else {
                                for (Employee emp : allEmployees) {
                                    System.out.println(emp);
                                }
                            }
                            break;

                        case 6: // Display Sorted
                            System.out.println("\n--- Employees Sorted by Joining Date ---");
                            List<Employee> sortedEmployees = service.getAllEmployeesSortedByJoiningDate();
                            if (sortedEmployees.isEmpty()) {
                                throw new EmployeeHandlingException("No employees to sort.");
                            } else {
                                for (Employee emp : sortedEmployees) {
                                    System.out.println(emp);
                                }
                            }
                            break;

                        case 0:
                            exit = true;
                            System.out.println("Exiting application. Goodbye! ");
                            break;
                            
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } catch (Exception e) {

                	System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}


package com.tester;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.admission.Admission;
import com.admission.AdmissionImpl;
import com.core.MyCourse;
import com.core.Student;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {

			Admission admission = new AdmissionImpl();

			boolean exit = false;
			while (!exit) {
				try {

					System.out.println("\n===== Student Admission Management System ====="
							+ "\nEnter you choice -- \n1. Admit Student\n" + "2. Cancel Admission\n"
							+ "3. Search Student by Email\n" + "4. List of All Student\n"
							+ "5. List Student by course \n" + "0. exit");

					switch (sc.nextInt()) {

					case 1:
					    System.out.println("Enter student details:");
					    
                        System.out.println("Name: ");
                        String Name = sc.next();
                        
                        System.out.println("Email: ");
                        String email = sc.next();
                        
                        System.out.println("Marks: ");
                        int marks = sc.nextInt();
                        
                        sc.nextLine();

						System.out.println("Available courses:");
						for (MyCourse course : MyCourse.values()) {
							System.out.println(course + " (Min marks: " + course.getMinMarks() + ", Available seats: "
									+ course.getCapacity() + ")");
						}
						System.out.print("Course: ");
						String courseStr = sc.nextLine().toUpperCase();
						MyCourse course;
						try {
							course = MyCourse.valueOf(courseStr);
						} catch (IllegalArgumentException e) {
							System.out.println("Invalid course!");
							break;
						}

						System.out.print("Admission Date (YYYY-MM-DD): ");
						String admDateStr = sc.nextLine();
						LocalDate admissionDate = LocalDate.parse(admDateStr);

						System.out.println(admission.admitStudent(Name, email, marks, course, admissionDate));

						break;

					case 2:
						System.out.print("Enter student email to cancel admission: ");
						String cancelEmail = sc.next();

						System.out.println(admission.cancelAdmission(cancelEmail));

						break;

					case 3:
						System.out.print("Enter student email to search: ");
						String searchEmail = sc.next();
						System.out.println(admission.searchStudentByEmail(searchEmail));

						break;
						
						
					case 4:
				        List<Student> allStudents = admission.listAllStudents();
                        if (allStudents.isEmpty()) {
                            System.out.println("No students found.");
                        } else {
                            System.out.println("All students:");
                            for (Student s : allStudents) {
                                System.out.println(s);
                            }
                        }
						
						break;
					case 5:  
						System.out.println("Available courses:");
                    for (MyCourse c : MyCourse.values()) {
                        System.out.println(c);
                    }
                    System.out.print("Enter course name: ");
                    String courseName = sc.next().toUpperCase();
                    MyCourse filterCourse;
                    try {
                        filterCourse = MyCourse.valueOf(courseName);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid course!");
                    }
                        break;
                        
                        
					case 0:
						exit = true;
						System.out.println("you are gone!");
						break;

					}

				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
					sc.nextLine(); // Clear the buffer

				}
			}

		}

	}

}

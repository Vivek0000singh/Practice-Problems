package com.admission;

import static com.admission.AdmissionValidation.checkvalidStudent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.StudentException.*;
import com.core.MyCourse;
import com.core.Student;

public class AdmissionImpl implements Admission {

	private ArrayList<Student> StudentList = new ArrayList<>();
	

	@Override
	public String admitStudent(String name, String email, int marks, MyCourse course, LocalDate admissionDate)
			throws StudentException {
		
		
		   // Check if email already exists
        if (searchStudentByEmail(email) != null) {
            throw new StudentException("Student with email " + email + " already exists!");
        }
        
        // Check if marks are sufficient
        if (marks < course.getMinMarks()) {
            throw new StudentException("Marks are insufficient for " + course + ". Minimum required: " + course.getMinMarks());
        }
        
        // Check if course has available seats
        if (course.getCapacity() <= 0) {
            throw new StudentException("No available seats in " + course);
        }
        
     // Create and add student
        Student student = new Student(name, email, marks, course, admissionDate);
        StudentList.add(student);
        course.decreaseCapacity();
        
		 return "Student is admitted.. id: "+student.getId();
		
	}


    @Override
    public String cancelAdmission(String email) throws StudentException {
        Student student = searchStudentByEmail(email);
        if (student == null) {
            throw new StudentException("Student with email " + email + " not found!");
        }
        
        student.getCourse().increaseCapacity();
        StudentList.remove(student);
        
        return "Admission cancelled successfully for student with email: " + email;
    }

    
    @Override
    public Student searchStudentByEmail(String email) {
        for (Student student : StudentList) {
            if (student.getEmail().equals(email)) {
                return student;
            }
        }
        return null;
    }
    

    @Override
    public List<Student> listAllStudents() {
        return new ArrayList<>(StudentList);
    }



}



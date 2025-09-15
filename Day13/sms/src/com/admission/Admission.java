package com.admission;

import java.time.LocalDate;
import java.util.List;

import com.StudentException.StudentException;
import com.core.MyCourse;
import com.core.Student;

public interface Admission {

	public String admitStudent(String name, String email, int marks, MyCourse course, LocalDate admissionDate)
			throws StudentException;

	public String cancelAdmission(String email) throws StudentException;

	public Student searchStudentByEmail(String email);

	public List<Student> listAllStudents();

	public List<Student> listStudentsByCourse(MyCourse course);
}
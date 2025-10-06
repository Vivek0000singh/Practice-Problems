package com.core;

import java.time.LocalDate;

public class Student implements Comparable<Student> {
	private int idGenerator;
	
	private int Student_Id;
	private String student_name;
	private String email;
    private int marks;
    private boolean isMale;
    private LocalDate dateOfJoinDate;
    private Course courseType;
    
	public Student(String student_name, String email, int marks, boolean isMale,
			LocalDate dateOfJoinDate, Course courseType) {
		
		Student_Id = ++idGenerator;
		this.student_name = student_name;
		this.email = email;
		this.marks = marks;
		this.isMale = isMale;
		this.dateOfJoinDate = dateOfJoinDate;
		this.courseType = courseType;
	}

	public int getIdGenerator() {
		return idGenerator;
	}

	public void setIdGenerator(int idGenerator) {
		this.idGenerator = idGenerator;
	}

	public int getStudent_Id() {
		return Student_Id;
	}

	public void setStudent_Id(int student_Id) {
		Student_Id = student_Id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public LocalDate getDateOfJoinDate() {
		return dateOfJoinDate;
	}

	public void setDateOfJoinDate(LocalDate dateOfJoinDate) {
		this.dateOfJoinDate = dateOfJoinDate;
	}

	public Course getCourseType() {
		return courseType;
	}

	public void setCourseType(Course courseType) {
		this.courseType = courseType;
	}

	@Override
	public String toString() {
		return "Student [idGenerator=" + idGenerator + ", Student_Id=" + Student_Id + ", student_name=" + student_name
				+ ", email=" + email + ", marks=" + marks + ", isMale=" + isMale + ", dateOfJoinDate=" + dateOfJoinDate
				+ ", courseType=" + courseType + "]";
	}

	@Override
	public int compareTo(Student o) {
		
		return Double.compare(this.marks,o.marks);
	}
    
	
	
    

}

package com.core;

import java.time.LocalDate;

public class Student {
	private String name;
	private String email;
	private int marks;
	private MyCourse course;
	private LocalDate admissionDate;
	private int id;
	private static int idCounter = 100;

	/// Constructor

	public Student(String name, String email, int marks, MyCourse course, LocalDate admissionDate) {
		this.id = idCounter++;
		this.name = name;
		this.email = email;
		this.marks = marks;
		this.course = course;
		this.admissionDate = admissionDate;
	}

	// Getter and setters

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public MyCourse getCourse() {
		return course;
	}

	public void setCourse(MyCourse course) {
		this.course = course;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", marks=" + marks + ", course=" + course
				+ ", admissionDate=" + admissionDate + "]";
	}
}

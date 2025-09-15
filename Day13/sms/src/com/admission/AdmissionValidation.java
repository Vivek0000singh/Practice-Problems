package com.admission;

import java.util.ArrayList;

import com.StudentException.StudentException;
import com.core.Student;

public class AdmissionValidation {
	
	public static int seatNo;
	public static int minMarks;
	
	{
		seatNo =50;
		minMarks= 60;
	}
	
	
	
	public static void checkvalidStudent(int marks) throws StudentException{
		if(marks<=minMarks)
			throw new StudentException("Student is not eligible");
		if(marks>minMarks && seatNo == 0)
			throw new StudentException("seats are full! ");
		else {
			System.out.println("student is valid..");
	
	
	}


	
	}
}

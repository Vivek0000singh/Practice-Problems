package com.service;

import com.core.Course;
import com.custom_Exception.StudentHandlingException;

public class StudentValidation {
	
  public static void ValidateMarks(int marks) throws StudentHandlingException{
	  if(marks<0) {
		  throw new StudentHandlingException("Marks Should be +ve.");
	  }
  }
  
  public static void ValidateEmail(String email)throws StudentHandlingException{
	  String emailregexString=email.trim();
	  String regexpString="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	  if(!emailregexString.matches(regexpString)) {
		  throw new StudentHandlingException("Email is not valid");
	  }
  }
 
  
  public static Course parseAndvalidateCourse (String course)throws StudentHandlingException {
	  try {
		  return Course.valueOf(course.trim().toUpperCase());
		
	} catch (IllegalArgumentException e) {
         throw new StudentHandlingException("Invalid course...");
	}
  }
  

}

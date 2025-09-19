package utils;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Student;
import com.app.core.Subject;

public class Test4 {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			
			Subject sub=Subject.JAVA;
			Map<String,Student> mpp=populateMap(populateList());
			
			Student s=mpp.values()
			.stream()
			.filter(p->p.getSubject()==sub)
//			.filter(p->p.getGpa())
			.max(Comparator.comparing(Student::getGpa))
			.orElseThrow();
			System.out.println(s.getName());
	}

}
}

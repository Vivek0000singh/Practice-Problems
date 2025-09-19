package tester;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.Map;

import com.app.core.Student;
import com.app.core.Subject;

public class Test2 {
	public static void main(String[] args) {
		Map<String,Student> mpp=populateMap(populateList());
		
		Subject sub=Subject.JAVA;
		
		mpp.values()
		.stream()
		.filter(s->s.getSubject()==sub)
		.forEach(s->System.out.println(s));
		
	}

}

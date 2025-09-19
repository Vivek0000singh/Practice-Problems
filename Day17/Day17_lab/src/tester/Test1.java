package tester;

import static utils.StudentCollectionUtils.*;

import java.util.Map;

import com.app.core.Student;

public class Test1 {
	
	public static void main(String[] args) {
		Map<String,Student> mpp=populateMap(populateList());
		
		
		mpp.forEach((k,v)->System.out.println(v));
	}

}

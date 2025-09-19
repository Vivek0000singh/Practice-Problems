package tester;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.Map;
import java.util.Scanner;

import com.app.core.Student;


public class Test3 {

	public static void main(String[] args) {
try(Scanner sc=new Scanner(System.in)){
	
	System.out.println("Enter State");
	String state=sc.next();
	
	Map<String,Student> mpp=populateMap(populateList());
	
	double Sum=mpp.values()
	.stream()
	.filter(v->v.getAddress().getState().equals(state))
	.mapToDouble(p->p.getGpa())
	.sum();
	System.out.println(Sum);
}
		

	}

}

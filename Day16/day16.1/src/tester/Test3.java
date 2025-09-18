package tester;

import java.util.TreeSet;
import static utils.Utils.sumOfNumbers;

public class Test3 {
	public static void main(String[] args) {
		TreeSet<Long> longSet=new TreeSet<>();
		longSet.add(123l);
		longSet.add(12l);
		longSet.add(1235678l);
		
		System.out.println(sumOfNumbers(longSet));;
		
	}

}

package utils;

import java.util.List;

import fruits.Mango;

public interface Utils  {
// static void displayTaste(List<? extends Fruit> basket) {
//	 
//	 basket.forEach(f->f.taste());
//	
//};
//	
//	static double sumOfNumbers(Set<? extends Number> s) {
//		
//		double sum=0;
//		for(Number n:s) {
//			sum+=n.doubleValue();
//		}
//		return sum;
//		
//		
//	}
	
	
	static void addingMangoes(List<? super Mango> basket,Mango... mangos) {
		
		for(Mango m:mangos) {
			basket.add(m);
		}
		
	}
	
}

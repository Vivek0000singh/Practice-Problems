package tester;

import static utils.Utils.displayTaste;

import java.util.ArrayList;
import java.util.List;

import fruits.Apple;

public class Test2 {
public static void main(String[] args) {
	
	ArrayList<Apple> apples=new ArrayList<>(List.of(new Apple(),new Apple(),new Apple()));
	displayTaste(apples);
	
	
}
}

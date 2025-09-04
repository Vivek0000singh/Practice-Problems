package com.tester;

import java.util.Scanner;

import com.developer.Point2D;

public class TestPoint {

	public static void main(String[] args) {
			System.out.println("how many point to plot:");
			
			Scanner sc=new Scanner(System.in);
			
			Point2D [] pnt =new Point2D[sc.nextInt()];
			
              boolean exit=false;
			
			
			while(!exit) {
				
				System.out.println("choose 1 for ploting. 2 for display ");
				
				switch(sc.nextInt()) {
				
				case 1:
					
					System.out.println("Enetr index number:");
					
					int n=sc.nextInt();
					
					if(n>=0 && n<pnt.length && pnt[n]==null) {
						
						pnt[n]=new Point2D(sc.nextInt(),sc.nextInt());
					}else {
						System.out.println("Aleady present");
					}
				
//			for(int i=0;i<pnt.length; i++) {
//				System.out.println("enter value of x and y");
//				
//				pnt[i]=new Point2D(sc.nextInt(),sc.nextInt());
//				
//				System.out.println(pnt[i].show());
//			}
//			
			break;
			
			
				case 2:
			
			System.out.println("Displaying Arrays : ");
			
			for(Point2D p:pnt) {
				if (p !=null)
				System.out.println(p.show());
			}
			break;
			
			
				case 0:
					exit=true;
					System.out.println("Exit");
					break;
			
			
			default : 
		 System.out.println("Invalid input");
		 break;
		 
		 
				}
	}
			sc.close();
	}

}

//1. Prompt user , how many points to plot? 
//Create suitable array. (Hint : array of references)
//
//2. Show following options
//
//Options : 
//1. Plot a point
//Inputs : array index , x  ,y
//Check boundary conditions  & also check if some point is already plotted at the same index , if not then store the point details.
//In case of any errors , display suitable error message.
//
//2.   Display x,y co-ordinates of all the points plotted so far ,using for-each loop.
//
//0. Exit 
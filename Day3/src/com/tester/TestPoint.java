
package com.tester;
import com.developers.geometry.Point2D;


import java.util.Scanner;

class TestPoint {
 public static void main(String[] args) {

 Scanner sc=new Scanner(System.in);


    Point2D p1=new Point2D(sc.nextInt(),sc.nextInt());
    Point2D p2=new Point2D(sc.nextInt(), sc.nextInt());

     System.out.println(p1.show());
      System.out.println(p2.show());
    

    System.out.println(p1.isEqual(p2));
    System.out.println(p1.calculateDistance(p2));
 }
    
}

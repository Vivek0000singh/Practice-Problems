// 1.3 
//  Solve this (Discuss memory picture)
// Given : Box class is compiled.
// In main method  of TestBox
// Box b1=new Box(1,2,3);
// b1++;
// Box b2=b1;
// b1=new Box(3,4,5);
// //any objects marked for garbage collection ? how many ? 
// Box b3=b1;
// b2=new Box(4,5,6);
// //any objects marked for garbage collection ? how many ?

import java.util.*;


class TestBox {

    public static void main(String[] args){
        Box b1=new Box(1,2,3);
        System.out.println(b1.getShow());
        // b1++;
        Box b2=b1;
        b1=new Box(3,4,5);
        System.out.println(b1.getShow());
//any objects marked for garbage collection ? how many ? 
// HERE NO ONE.
        Box b3=b1;
        b2=new Box(4,5,6);
        System.out.println(b2.getShow());
//any objects marked for garbage collection ? how many ?
//YES , ONE .
    }
    
}

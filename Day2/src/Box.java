
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

class Box{
    private double width;
    private double height;
    private double depth;
    
    Box(double width, double height,double depth){
        this.width=width;
        this.height=height;
        this.depth=depth;

    }
    String getShow(){
        return "the dimensions"+this.width+this.height+this.depth;

    }
    
}
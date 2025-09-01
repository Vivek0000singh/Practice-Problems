// Write Java program for the following - 
// It should  run till user enters any other option than add or sub or multiply or divide
// Prompt user to enter the input operation : (add|subtract|multiply|divide) & 2 numbers(double)
// Display the result of the operation.
// Use Scanner for accepting all inputs from user. 
// Hint : use switch-case

import java.util.Scanner;

class Calculator
{
    public static void main(String[] args){

        Scanner sc= new Scanner(System.in);

        System.out.println("Enter 2 numbers:");
        double num1=sc.nextDouble();
        double num2=sc.nextDouble();

        System.out.println("Enter opertions:");
         System.out.println("1.Add ");
          System.out.println("2.Subtract");
           System.out.println("3.Multiply");
            System.out.println("4.divide ");

            boolean exit=false;

            double result=0.0;


            while(!exit){
                switch(sc.nextInt()){
                    case 1:
                    result= (num1+num2);
                    break;
                     case 2:
                    result= (num1-num2);
                    break;
                     case 3:
                    result= (num1*num2);
                    break;
                     case 4:
                    if (num2 != 0) {
                        result =( num1 / num2);
                    } else {
                        System.out.println("Error: Division by zero!");
                        continue; // skip printing result
                    }
                    exit=true;
                    break;
                      default:
                    System.out.println("Invalid choice! Please try again.");
            }
            System.out.println("Result: "+result);
                }
            

      sc.close();

    }
}
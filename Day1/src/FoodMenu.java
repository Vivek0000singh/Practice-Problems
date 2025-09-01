// Display food menu to user. User will select items from menu along with the quantity. (eg 1. Dosa 2. Samosa 3. Idli ... 0 . Generate Bill ) Assign fixed prices to food items(hard code the prices)
// When user enters 'Generate Bill' option(0) , display total bill & exit.


import java.util.Scanner;

class FoodMenu{

    public static void main (String[] args){
        
        boolean exit=false;
        Scanner sc=new Scanner(System.in);

        
        System.out.println("Food Menu:");
            System.out.println("1. Dosa     Rs.40");
            System.out.println("2. Samosa   Rs.10");
            System.out.println("3. Idli     Rs.25");
            System.out.println("0. Generate Bill");

           int sum=0;

        while(!exit){

            switch(sc.nextInt()){

                case 1:
                System.out.println("qty");
                int qty1 = sc.nextInt();
                sum+=40*qty1;
                 System.out.println("Dosa "+qty1);
                 break;

                    case 2:
                    System.out.println("qty");
                    int qty2=sc.nextInt();
                sum+=10*qty2;
                 System.out.println("Samosa "+qty2);
                 break;

                   case 3:
                   System.out.println("qty");
                   int qty3=sc.nextInt();
                sum+=25*qty3;
                 System.out.println("Idli "+ qty3);
                 break;
                   case 0:
                    System.out.println("Total Bill = Rs. " + sum);
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        sc.close();
    }
} 
package com.shoegallery.tester;

import java.util.List;
import java.util.Scanner;

import com.shoegallery.core.Shoe;
import com.shoegallery.custom_exceptions.ShoeHandlingException;
import com.shoegallery.service.ShoeService;
import com.shoegallery.service.ShoeServiceImpl;

public class ShoeGalleryApp {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ShoeService service = new ShoeServiceImpl();
            boolean exit = false;

            while (!exit) {
                System.out.println("\n===== Shoe Gallery Menu =====");
                System.out.println("1. Add a new Shoe");
                System.out.println("2. Display all Shoe details");
                System.out.println("3. Display all Shoe details sorted by Shoe ID");
                System.out.println("4. Find the most expensive Shoe in the Gallery");
                System.out.println("5. Remove Shoes not available in the Gallery");
                System.out.println("6. Update Shoe price by Brand");
                System.out.println("7. Display Shoes sorted by Price (High to Low)");
                System.out.println("8. Exit");
                System.out.print("👉 Choose an option: ");

                try {
                    int choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.print("Enter Name (3-20 chars): ");
                            String name = sc.nextLine();
                            System.out.print("Enter Brand: ");
                            String brand = sc.nextLine();
                            System.out.print("Enter Rating (1-10): ");
                            int rating = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter Price: ");
                            double price = Double.parseDouble(sc.nextLine());
                            System.out.print("Is it available in Gallery? (true/false): ");
                            boolean available = Boolean.parseBoolean(sc.nextLine());
                            System.out.print("Enter Shoe Type (FORMAL, CASUAL, SPORTS): ");
                            String type = sc.nextLine();
                            System.out.println(service.addShoe(name, brand, rating, price, available, type));
                            break;

                        case 2:
                            System.out.println("\n--- All Shoe Details ---");
                            List<Shoe> allShoes=service.getAllShoes();
                            if(allShoes.isEmpty()) {
                            	throw new ShoeHandlingException("no shoes available.");
                            }else {
                            	for(Shoe s:allShoes) {
                            		System.out.println(s);
                            	}
                            }
                            
                            break;

                        case 3:
                            System.out.println("\n--- All Shoes Sorted by ID ---");
//                            service.getAllShoesSortedById().forEach(System.out::println);
                            List<Shoe> allShoesbyid=service.getAllShoesSortedById();
                            if(allShoesbyid.isEmpty()) {
                            	throw new ShoeHandlingException("no shoes available.");
                            }else {
                            	for(Shoe s:allShoesbyid) {
                            		System.out.println(s);
                            	}
                            }
                            
                            break;
                            
                        case 4:
                            System.out.println("\n--- Most Expensive Shoe in Gallery ---");
                            System.out.println(service.findMostExpensiveShoeInGallery());
                            break;

                        case 5:
                            System.out.println(service.removeUnavailableShoes());
                            break;
                            
                        case 6:
                            System.out.print("Enter Brand to update price: ");
                            String brandToUpdate = sc.nextLine();
                            System.out.print("Enter new Price: ");
                            double newPrice = Double.parseDouble(sc.nextLine());
                            System.out.println(service.updatePriceByBrand(brandToUpdate, newPrice));
                            break;

                        case 7:
                            System.out.println("\n--- All Shoes Sorted by Price (High to Low) ---");
                           // service.getAllShoesSortedByPriceDesc().forEach(System.out::println);
                            List<Shoe> allShoesbyprice=service.getAllShoesSortedByPriceDesc();
                            if(allShoesbyprice.isEmpty()) {
                            	throw new ShoeHandlingException("no shoes available.");
                            }else {
                            	for(Shoe s:allShoesbyprice) {
                            		System.out.println(s);
                            	}
                            }
                            
                            break;

                        case 8:
                            exit = true;
                            System.out.println("Exiting application. Goodbye! 👋");
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}

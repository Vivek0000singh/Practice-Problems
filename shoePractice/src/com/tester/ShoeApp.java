package com.tester;

import java.util.List;
import java.util.Scanner;

import com.core.Shoe;
import com.custom_handling.ShoeHandlingException;
import com.service.ShoeService;
import com.service.ShoeServiceImpl;

public class ShoeApp {

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
						System.out.println("------Add Shoe Details------");
						System.out.println("Enter name (length should be between 1 and 20 characters)");
						String name = sc.nextLine();
						System.out.println("Enter Brand ");
						String brand = sc.nextLine();
						System.out.println("Enter Rating (Rating between 1 to 10) ");
						int rating = Integer.parseInt(sc.nextLine());
						System.out.println("Enter Price ");
						double price = Double.parseDouble(sc.nextLine());

						System.out.println("is Shoe Available (true/false)");
						boolean availability = Boolean.parseBoolean(sc.nextLine());

						System.out.println("Enter Shoe Type (forma,casual,sports) ");
						String type = sc.nextLine();

						System.out.println(service.addShoe(name, brand, rating, price, availability, type));
						break;
						
					case 2 :
						System.out.println("-------All Shoes Details--------");
						List<Shoe> allShoes=service.getallShoes();
						if(allShoes.isEmpty()) {
							throw new ShoeHandlingException("no Shoes Available");
						}else {
							for(Shoe s:allShoes) {
								System.out.println(s);
							}
						}
						
						break;
						
					case 3:
						System.out.println("--------All Shoes Details by id------");
						List<Shoe> allShoesbyid=service.getallShoesById();
						if(allShoesbyid.isEmpty()) {
							throw new ShoeHandlingException("no Shoes Available");
						}else {
							for(Shoe s:allShoesbyid) {
								System.out.println(s);
							}
						}
						break;
						
						
					case 4 :
						System.out.println("--------Most Expensive shoes--------");
						System.out.println(service.mostExpensiveShoes());
						break;
						
					case 5:
						System.out.println("------Remove Shoes------");
						System.out.println(service.removeNotAvailableShoes());
						
						break;
						
					case 6 :
						System.out.println("-------update shoe price ---------");
						  System.out.print("Enter Brand to update price: ");
                          String brandToUpdate = sc.nextLine();
                          System.out.print("Enter new Price: ");
                          double newPrice = Double.parseDouble(sc.nextLine());
                          System.out.println(service.updateBrandPrice(brandToUpdate, newPrice));
                          break;
						
					case 7 :
						System.out.println("--------Sort shoes by price-------");
						   List<Shoe> allShoesbyprice=service.getAllShoesByPricedesc();
                           if(allShoesbyprice.isEmpty()) {
                           	throw new ShoeHandlingException("no shoes available.");
                           }else {
                           	for(Shoe s:allShoesbyprice) {
                           		System.out.println(s);
                           	}
                           }
                           
                           break;
						
					case 8 :
						exit=true;
						
						System.out.println("Exiting.....Bye...");
						break;
						

					default:
						throw new IllegalArgumentException("Unexpected value: " + choice);
						
					}

				} catch (Exception e) {
					System.out.println("error :  " + e.getMessage());
				}

			}

		}

	}

}

package com.tester;

import java.util.List;
import java.util.Scanner;

import com.core.Mobile;
import com.custom_exception.MobileHandlingException;
import com.service.MobileService;
import com.service.mobileImpl;

public class MobileInventoryms {
	public static void main(String[] args) {
		try (Scanner sc =new Scanner(System.in)){
			
			MobileService service=new mobileImpl();
			
			
			boolean exit=false;
			
			while(!exit) {
				System.out.println("\n===== Mobile inventory Management System Menu =====");
				System.out.println("1. Add a new Mobile");
				System.out.println("2. Display all Mobile details");
				System.out.println("3. Display all Mobile details sorted by Phone ID");
				System.out.println("4. Find the least expensive Shoe in the Gallery");
				System.out.println("5. Remove Mobiles not available in the Stock");
				System.out.println("6. Update Mobile price by modelNmae");
				System.out.println("7. Display Shoes sorted by Price in ascending");
				System.out.println("8. Exit");
				System.out.print("👉 Choose an option: ");
				
				
				
				try {
					
					int choice=Integer.parseInt(sc.nextLine());
					
					switch (choice) {
					case 1: 
						System.out.println("--------Add new Mobile-----");
						
						System.out.println("Enter model name (Length should be between 2 and 15)");
						String name=sc.nextLine();
						
						System.out.println("Enter Brand ");
						String brand = sc.nextLine();
						
						System.out.println("Enter Price ");
						double price = Double.parseDouble(sc.nextLine());
						
						System.out.println("Enter Rating (Rating between 1 to 5) ");
						int rating = Integer.parseInt(sc.nextLine());

						System.out.println("is mobile Available (true/false)");
						boolean availability = Boolean.parseBoolean(sc.nextLine());

						System.out.println("Enter mobile Type  [SMARTPHONE, FEATURE_PHONE, FOLDABLE]");
						String type = sc.nextLine();

						System.out.println(service.addMobile(name, brand, rating, price, availability, type));
						break;
						
						
					case 2 :
						System.out.println("-------All Mobiles Details--------");
						List<Mobile> allMobiles=service.getallMobiles();
						if(allMobiles.isEmpty()) {
							throw new MobileHandlingException("no Mobile Available");
						}else {
							for(Mobile m:allMobiles) {
								System.out.println(m);
							}
						}
						
						break;
						
					case 3:
						System.out.println("--------All Mobiles Details by id------");
						List<Mobile> allMobilesbyid=service.getallMobilesById();
						if(allMobilesbyid.isEmpty()) {
							throw new MobileHandlingException("no Mobile is Available");
						}else {
							for(Mobile m:allMobilesbyid) {
								System.out.println(m);
							}
						}
						break;
						
						
					case 4 :
						System.out.println("--------least Expensive Mobiles--------");
						System.out.println(service.leastExpensiveMobiles());
						break;
						
					case 5:
						System.out.println("------Remove Mobiles------");
						System.out.println(service.removeNotAvailableMobiles());
						
						break;
						
					case 6 :
						System.out.println("-------update Mobile price ---------");
						  System.out.print("Enter Brand to update price: ");
                          String brandToUpdate = sc.nextLine();
                          System.out.print("Enter new Price: ");
                          double newPrice = Double.parseDouble(sc.nextLine());
                          System.out.println(service.updateBrandPrice(brandToUpdate, newPrice));
                          break;
						
					case 7 :
						System.out.println("--------Sort Mobiles by price-------");
						   List<Mobile> allMobilesbyprice=service.getAllMobilesByPricedesc();
                           if(allMobilesbyprice.isEmpty()) {
                           	throw new MobileHandlingException("no shoes available.");
                           }else {
                           	for(Mobile m:allMobilesbyprice) {
                           		System.out.println(m);
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
					System.out.println("Error : "+ e.getMessage());
				}
			}
			
		}
	}

}

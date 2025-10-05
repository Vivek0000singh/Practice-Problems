package com.shoegallery.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.shoegallery.core.Shoe;
import com.shoegallery.core.ShoeType;
import com.shoegallery.custom_exceptions.ShoeHandlingException;

public class ShoeServiceImpl implements ShoeService {

	private Map<Integer, Shoe> shoeMap;

	public ShoeServiceImpl() {
		shoeMap = new HashMap<>();
		// Pre-populating with 4+ records as required
		try {
			addShoe("Air Max", "Nike", 9, 12000, true, "SPORTS");
			addShoe("Classic Leather", "Reebok", 8, 7500, true, "CASUAL");
			addShoe("Oxford", "Bata", 7, 5000, false, "FORMAL");
			addShoe("Ultraboost", "Adidas", 10, 18000, true, "SPORTS");
			addShoe("Loafer", "Woodland", 8, 6500, true, "CASUAL");
		} catch (ShoeHandlingException e) {
			System.out.println("Error initializing sample data: " + e.getMessage());
		}
	}

	@Override
	public String addShoe(String name, String brand, int ratings, double price, boolean available, String type)
			throws ShoeHandlingException {
		ShoeValidationRules.validateName(name);
		ShoeValidationRules.validateRating(ratings);
		ShoeType shoeType = ShoeValidationRules.parseAndValidateShoeType(type);

		Shoe newShoe = new Shoe(name, brand, ratings, price, available, shoeType);
		shoeMap.put(newShoe.getShoeId(), newShoe);
		return "✅ Shoe added successfully with ID: " + newShoe.getShoeId();
	}

	@Override
	public List<Shoe> getAllShoes() {
		return new ArrayList<>(shoeMap.values());
	}

	@Override
	public List<Shoe> getAllShoesSortedById() {
		List<Shoe> sortedList = new ArrayList<>(shoeMap.values());
		// Sorting using a custom comparator for Shoe ID, since it's not the natural
		// order
		Collections.sort(sortedList, Comparator.comparingInt(Shoe::getShoeId));

		return sortedList;
	}

	@Override
	public Shoe findMostExpensiveShoeInGallery() throws ShoeHandlingException {
		Shoe mostExpensive = null;
		for (Shoe shoe : shoeMap.values()) {
			if (shoe.isAvailableInGallery()) {
				if (mostExpensive == null || shoe.getPrice() > mostExpensive.getPrice()) {
					mostExpensive = shoe;
				}
			}
		}
		if (mostExpensive == null) {
			throw new ShoeHandlingException("No shoes are currently available in the gallery.");
		}
		return mostExpensive;
	}

	@Override
	public String removeUnavailableShoes() {
		int count = 0;
		Iterator<Map.Entry<Integer, Shoe>> iterator = shoeMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, Shoe> entry = iterator.next();
			if (!entry.getValue().isAvailableInGallery()) {
				iterator.remove();
				count++;
			}

		}

		return " Removed " + count + " unavailable shoe(s) from the gallery.";
	}

	@Override
	public String updatePriceByBrand(String brand, double newPrice) {
		int count = 0;
		for (Shoe shoe : shoeMap.values()) {
			if (shoe.getBrand().equalsIgnoreCase(brand.trim())) {
				shoe.setPrice(newPrice);
				count++;
			}
		}
		return "✅ Updated price for " + count + " shoe(s) of brand '" + brand + "'.";
	}

	@Override
	public List<Shoe> getAllShoesSortedByPriceDesc() {
		List<Shoe> sortedList = new ArrayList<>(shoeMap.values());
		// This now works correctly because it uses the compareTo method defined in
		// Shoe.java
		Collections.sort(sortedList);
		return sortedList;
	}
}

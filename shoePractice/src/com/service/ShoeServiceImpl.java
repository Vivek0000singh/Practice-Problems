package com.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.core.Shoe;
import com.core.ShoeType;
import com.custom_handling.ShoeHandlingException;

public  class ShoeServiceImpl implements ShoeService {
	
	private Map<Integer, Shoe> shoeMap;
	
	public ShoeServiceImpl() {
		
		shoeMap=new HashMap<>();

	}

	@Override
	public String addShoe(String name, String brand, int rating, double price, boolean availability, String type)
			throws ShoeHandlingException {
		ShoeServiceValidation.Validatename(name);
		ShoeServiceValidation.ValidateRating(rating);
	    
		
		ShoeType myType=ShoeServiceValidation.parseAndValidateShoeType(type);
		
		 Shoe newShoe=new Shoe(name, brand, rating, price, availability, myType);
		 shoeMap.put(newShoe.getShoeId(), newShoe);
		 
		
		
		return "Shoes Added.......";
	}

	@Override
	public List<Shoe> getallShoes() {
		 
		return new ArrayList<>(shoeMap.values());
	}

	@Override
	public List<Shoe> getallShoesById() {
		List<Shoe> sortedList=new ArrayList<>(shoeMap.values());
		
		Collections.sort(sortedList,Comparator.comparingInt(Shoe::getShoeId));
		return sortedList;
	}

	@Override
	public Shoe mostExpensiveShoes() throws ShoeHandlingException {
		Shoe mostexpensiveShoe=null;
		
		for(Shoe shoe:shoeMap.values()) {
			if(mostexpensiveShoe==null || shoe.getPrice()>mostexpensiveShoe.getPrice()) {
				mostexpensiveShoe=shoe;
			}
		}
		
		if(mostexpensiveShoe==null) {
			throw new ShoeHandlingException("No shoe Availaible");
		}
		
		return mostexpensiveShoe;
	}

	@Override
	public String removeNotAvailableShoes() throws ShoeHandlingException {
		int count=0;
		
		Iterator<Map.Entry<Integer,Shoe>> iterator=shoeMap.entrySet().iterator();
		
		while(iterator.hasNext()) {
			
			Map.Entry<Integer, Shoe> entry=iterator.next();
			
			if(!entry.getValue().isAvailableInGallery()) {
				iterator.remove();
				count++;
				
			}
			
		}
		return "Total shoe removed : "+ count;
	}

	@Override
	public String updateBrandPrice(String Brand,double newPrice)  {
		
		int count=0;
		
		for(Shoe shoe:shoeMap.values()) {
			
			if(shoe.getBrand().equals(Brand)) {
				shoe.setPrice(newPrice);
				count++;
			}
			
		}

		
		return "Total Shoes Updated : "+ count;
	}

	@Override
	public List<Shoe> getAllShoesByPricedesc() {
		List<Shoe> sortedList=new ArrayList<>(shoeMap.values());
		Collections.sort(sortedList);
		return sortedList;
	}

}

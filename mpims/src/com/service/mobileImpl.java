package com.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.core.Mobile;
import com.core.PhoneType;
import com.custom_exception.MobileHandlingException;

public class mobileImpl implements MobileService {
	
	private Map<Integer, Mobile> mobileMap;
	

	public mobileImpl() {
		mobileMap=new HashMap<>();
		
	}

	@Override
	public String addMobile(String name, String brand, int rating, double price, boolean availability, String type)
			throws MobileHandlingException {
		MobileValidation.modelName(name);
		MobileValidation.validateRatings(rating);
		
		PhoneType mtype = MobileValidation.parseAndValidatePhoneType(type);
		
		Mobile newMobile=new Mobile(name, brand, price, rating, availability, mtype);
		mobileMap.put(newMobile.getPhoneId(),newMobile);
		return "New Mobile is added.....................";
	}

	@Override
	public List<Mobile> getallMobiles() {
	
		return new ArrayList<>(mobileMap.values());
	}

	@Override
	public List<Mobile> getallMobilesById() {
        ArrayList<Mobile> sortedList=new ArrayList<>(mobileMap.values());  
        
        Collections.sort(sortedList,Comparator.comparingInt(Mobile::getPhoneId));
		return sortedList;
	}

	@Override
	public Mobile leastExpensiveMobiles() throws MobileHandlingException {
		
		Mobile leastExpensiveMobile=null;
		
		for(Mobile m: mobileMap.values()) {
			if(leastExpensiveMobile==null || m.getPrice() < leastExpensiveMobile.getPrice()) {
				leastExpensiveMobile=m;
			}
		}
		
		
		
		
		return leastExpensiveMobile;
	}

	@Override
	public String removeNotAvailableMobiles() throws MobileHandlingException {
		
		int count =0;
		
		Iterator<Map.Entry<Integer, Mobile>> iterator=mobileMap.entrySet().iterator();
		
		while(iterator.hasNext()) {
			
			Map.Entry<Integer, Mobile> entry=iterator.next();
			
			if(! entry.getValue().isInStock()) {
				iterator.remove();
				count++;
			}
			
		}
		return "Total removed mobiles : "+count;
	}

	@Override
	public String updateBrandPrice(String brandToUpdate, double newPrice) throws MobileHandlingException {
		int count=0;
		
		for(Mobile m:mobileMap.values()) {
			if(m.getBrand().equals(brandToUpdate)) {
				m.setPrice(newPrice);
				count++;
			}
		}
		return "Total mobile updated : "+ count;
	}

	@Override
	public List<Mobile> getAllMobilesByPricedesc() {
		  ArrayList<Mobile> sortedList=new ArrayList<>(mobileMap.values());  
	        
	        Collections.sort(sortedList);
			return sortedList;
	}

}

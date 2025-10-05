package com.service;

import java.util.List;

import com.core.Mobile;
import com.custom_exception.MobileHandlingException;

public interface MobileService {


	String addMobile(String name, String brand, int rating, double price, boolean availability, String type)throws MobileHandlingException;

	List<Mobile> getallMobiles();
	List<Mobile> getallMobilesById();

	  Mobile leastExpensiveMobiles() throws MobileHandlingException;

	String removeNotAvailableMobiles() throws MobileHandlingException;

	String updateBrandPrice(String brandToUpdate, double newPrice) throws MobileHandlingException;

	List<Mobile> getAllMobilesByPricedesc();
	
	

}

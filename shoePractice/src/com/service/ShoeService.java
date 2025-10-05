package com.service;

import java.util.List;

import com.core.Shoe;
import com.custom_handling.ShoeHandlingException;

public interface ShoeService  {
	
	
	String addShoe(String name,String brand,int rating,double price,boolean availability,String type)throws ShoeHandlingException;
	List<Shoe> getallShoes();
	List<Shoe>getallShoesById();
	Shoe mostExpensiveShoes() throws ShoeHandlingException;
	String removeNotAvailableShoes()throws ShoeHandlingException;
	String updateBrandPrice(String brand, double price) throws ShoeHandlingException;
	List<Shoe> getAllShoesByPricedesc();
	


}

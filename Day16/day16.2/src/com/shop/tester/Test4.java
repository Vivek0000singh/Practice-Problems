package com.shop.tester;

import static com.shop.utils.ShopUtils.populateProductList;
import static com.shop.utils.ShopUtils.populateProductMap;

import com.shop.core.Category;
import java.util.Map;

import com.shop.core.Product;

public class Test4 {
	
	public static void main(String[] args) {
		
	
	// get populated Map of products
	Map<Integer, Product> productMap = populateProductMap(populateProductList());
	
	productMap.forEach((pid, product) -> System.out.println("Key " + pid + " Value " + product));
	
	Category category=Category.BISCUITS;
	
	productMap.values().removeIf(p->p.getProductCategory()==category);
	
	System.out.println("After removing");
	
	productMap.forEach((pid, product) -> System.out.println("Key " + pid + " Value " + product));

}

}

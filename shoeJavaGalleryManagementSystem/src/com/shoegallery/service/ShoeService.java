package com.shoegallery.service;

import com.shoegallery.core.Shoe;
import com.shoegallery.custom_exceptions.ShoeHandlingException;
import java.util.List;

public interface ShoeService {
    String addShoe(String name, String brand, int ratings, double price, boolean available, String shoeType) throws ShoeHandlingException;
    List<Shoe> getAllShoes();
    List<Shoe> getAllShoesSortedById();
    Shoe findMostExpensiveShoeInGallery() throws ShoeHandlingException;
    String removeUnavailableShoes();
    String updatePriceByBrand(String brand, double newPrice);
    List<Shoe> getAllShoesSortedByPriceDesc();
}

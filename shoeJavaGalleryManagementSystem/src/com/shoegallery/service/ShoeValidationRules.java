package com.shoegallery.service;

import com.shoegallery.core.ShoeType;
import com.shoegallery.custom_exceptions.ShoeHandlingException;

public class ShoeValidationRules {

    /**
     * Validates that the name has a length between 3 and 20 characters.
     */
    public static void validateName(String name) throws ShoeHandlingException {
        if (name.length() < 3 || name.length() > 20) {
            throw new ShoeHandlingException("Invalid Name: Length must be between 3 and 20 characters.");
        }
    }

    /**
     * Validates that the rating is between 1 and 10 (inclusive).
     */
    public static void validateRating(int rating) throws ShoeHandlingException {
        if (rating < 1 || rating > 10) {
            throw new ShoeHandlingException("Invalid Rating: Must be between 1 and 10.");
        }
    }

    /**
     * Parses the shoe type from a string (case-insensitive) into the ShoeType enum.
     */
    public static ShoeType parseAndValidateShoeType(String type) throws ShoeHandlingException {
        try {
            // valueOf is case-sensitive, so we convert input to uppercase
            return ShoeType.valueOf(type.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ShoeHandlingException("Invalid Shoe Type. Must be one of: FORMAL, CASUAL, SPORTS.");
        }
    }
}

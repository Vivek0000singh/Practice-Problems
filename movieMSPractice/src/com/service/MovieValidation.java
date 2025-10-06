package com.service;

import java.time.LocalDate;
import java.util.Map;

import com.core.Movie;
import com.core.MovieType;
import com.custom_exception.MovieHandlingExceptions;

public class MovieValidation {

	public static MovieType parseAndValidateMovieType (String type)throws MovieHandlingExceptions{
		try {
			return MovieType.valueOf(type.trim().toUpperCase());
			
		} catch(IllegalArgumentException e) {
		       throw new MovieHandlingExceptions("Movie Type is not valid...");
		}
	}
	
	
	public static void validateName (String name,Map<Integer, Movie>movieMap )throws MovieHandlingExceptions{
		for(Movie m:movieMap.values()) {
			if(m.getName().equals(name)) {
				throw new MovieHandlingExceptions("Duplicate Movie Name....");
			}
		}
	}
	
	
	public static void validateDate(LocalDate date)throws MovieHandlingExceptions{
		if(date.isAfter(LocalDate.now())){
			throw new MovieHandlingExceptions("Release date cannot be in the future. Please enter a valid date.");
		}
	}
	
	
}

package com.service;

import java.time.LocalDate;
import java.util.List;

import com.core.Movie;
import com.custom_exception.MovieHandlingExceptions;

public interface MovieService {

	String addMovie(int id, String name, double rating, boolean inCinemas, LocalDate rDate, String type)throws MovieHandlingExceptions; 
	List<Movie> getAllMovies();
	List<Movie> getAllMoviesByDate();
	List<Movie> getAllMoviesByName();
    String UpdateDate(int id, LocalDate newdate);
	String removeMovies() throws MovieHandlingExceptions;
	List<Movie> SearchMovie(String type) throws MovieHandlingExceptions;
		
	

}

		
	

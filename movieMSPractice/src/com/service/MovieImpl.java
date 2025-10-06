package com.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.core.Movie;
import com.core.MovieType;
import com.custom_exception.MovieHandlingExceptions;

public class MovieImpl implements MovieService {

	private Map<Integer, Movie> movieMap;

	public MovieImpl() {
		movieMap = new HashMap<>();

	}

	@Override
	public String addMovie(int id, String name, double rating, boolean inCinemas, LocalDate rDate, String type)
			throws MovieHandlingExceptions {

		MovieValidation.validateName(name, movieMap);
		MovieValidation.validateDate(rDate);
		MovieType mType = MovieValidation.parseAndValidateMovieType(type);

		Movie newMovie = new Movie(id, name, rating, inCinemas, rDate, mType);
		movieMap.put(newMovie.getId(), newMovie);

		return "Movie Added Succesfully With id : " + newMovie.getId();
	}

	@Override
	public List<Movie> getAllMovies() {

		return new ArrayList<>(movieMap.values());
	}

	@Override
	public List<Movie> getAllMoviesByDate() {
		List<Movie> sortedList = new ArrayList<>(movieMap.values());

		Collections.sort(sortedList, Comparator.comparing(Movie::getReleaseDate));

		return sortedList;
	}

	@Override
	public List<Movie> getAllMoviesByName() {
		List<Movie> sortedList = new ArrayList<>(movieMap.values());

		Collections.sort(sortedList);

		return sortedList;
	}

	@Override
	public String UpdateDate(int id, LocalDate newdate) {
		
		for(Movie m:movieMap.values()) {
			if(m.getId()==id) {
				
				m.setReleaseDate(newdate);
				
			}
		}
		return "Date  is updated " ;
	}

	@Override
	public String removeMovies() throws MovieHandlingExceptions {
		int count=0;
		
		Iterator<Map.Entry<Integer, Movie>>iterator=movieMap.entrySet().iterator();
		
		while (iterator.hasNext()) {
			Map.Entry<Integer, Movie>entry=iterator.next();
			
			if(entry.getValue().getRatings()<3.5) {
				iterator.remove();
				count++;
			}
			
		}
		return "Total movies removed : "+count ;
	}

	

	@Override
	public List<Movie> SearchMovie(String type) throws MovieHandlingExceptions {
		MovieType mType=MovieValidation.parseAndValidateMovieType(type);
		
		List<Movie> foundMovies=new ArrayList<>();
		
		for(Movie m:movieMap.values()) {
			if(m.getType()==mType) {
				foundMovies.add(m);
			}
		}
		
		return foundMovies;
	}

}

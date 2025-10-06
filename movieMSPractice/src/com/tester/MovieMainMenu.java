package com.tester;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.core.Movie;
import com.custom_exception.MovieHandlingExceptions;
import com.service.MovieImpl;
import com.service.MovieService;

public class MovieMainMenu {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			MovieService service = new MovieImpl();

			boolean exit = false;

			while (!exit) {

				System.out.println("=====MOVIE MANAGEMENT SYSTEM MENU======");
				System.out.println("1.Add Movie");
				System.out.println("2.Display Movie with rating >5 ");
				System.out.println("3.Remove Movie with Rating < 3.5");
				System.out.println("4.Sort Movies by Date");
				System.out.println("5.Sort Movies by Name (Descending order)");
				System.out.println("6.Search movies By Type");
				System.out.println("7.update ReleaseDate Using Id");
				System.out.println("8.exit");
				System.out.println("Enter your Choice");

				try {

					int choice = Integer.parseInt(sc.nextLine());

					switch (choice) {
					case 1:
						System.out.println("---------Add Movie Details-----");
						System.out.println("Enter id ");
						int id = Integer.parseInt(sc.nextLine());

						System.out.println("Enter Movie Name");
						String name = sc.nextLine();

						System.out.println("Enter Ratings (1 to 10 )");
						double rating = Double.parseDouble(sc.nextLine());

						System.out.println("Is this Available (True/False)");
						boolean inCinemas = Boolean.parseBoolean(sc.nextLine());

						System.out.println("Enter ReleaseDate (yyyy-mm-d)");
						LocalDate rDate = LocalDate.parse(sc.nextLine());

						System.out.println("Enter MovieType (Bollywood,Tollywood,Hollywood)");
						String type = sc.nextLine();

						System.out.println(service.addMovie(id, name, rating, inCinemas, rDate, type));

						break;

					case 2:
						System.out.println("-------Display Movie with Rating > 5----------- ");

						List<Movie> showallMovies = service.getAllMovies();

						if (showallMovies.isEmpty()) {
							throw new MovieHandlingExceptions("List is Empty...");
						} else {
							for (Movie m : showallMovies) {
								if (m.getRatings() > 5) {
									System.out.println(m);
								}
							}
						}
						break;

					case 3:
						System.out.println("------Remove movies with rating < 3.5------");
						System.out.println(service.removeMovies());
						break;
						
		

					case 4:
						System.out.println("------Sort movies  by date----");

						List<Movie> showallMoviesbydate = service.getAllMoviesByDate();

						if (showallMoviesbydate.isEmpty()) {
							throw new MovieHandlingExceptions("List is Empty...");
						} else {
							for (Movie m : showallMoviesbydate) {
								System.out.println(m);
							}
						}
						break;

					case 5:
						System.out.println("------Sort movies by name (descending)-----");
						List<Movie> showallMoviesbyName = service.getAllMoviesByName();

						if (showallMoviesbyName.isEmpty()) {
							throw new MovieHandlingExceptions("List is Empty...");
						} else {
							for (Movie m : showallMoviesbyName) {
								System.out.println(m);
							}
						}
						break;

					case 6:
						System.out.println("------Movie by Type-------");
						
						System.out.println("Enter MovieType (Bollywood, Tollywood, Hollywood)");
					    type = sc.nextLine();
					    
					    List<Movie> movielist=service.SearchMovie(type);
					    
					    
					    if(movielist.isEmpty()) {
					    	throw new MovieHandlingExceptions("Movie List Is Empty ....");
					    }else {
					    	for(Movie movie :movielist) {
					    		System.out.println(movie);
					    	}
					    }

						break;
						
			

					case 7:
						System.out.println("------update Release Date by Id--------");
						
						System.out.println("Enter movie id ");
						id=Integer.parseInt(sc.nextLine());
						
						System.out.println("enter new Release Date :");
						LocalDate newdate=LocalDate.parse(sc.nextLine());
						
						System.out.println(service.UpdateDate(id,newdate));

						break;
					case 8:
						exit = true;
						System.out.println("Exiting ...GoodBye");

					default:
						throw new IllegalArgumentException("Unexpected value: " + choice);
					}

				} catch (Exception e) {
					System.out.println("Error : " + e.getMessage());
				}

			}
		}
	}

}

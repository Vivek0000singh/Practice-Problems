package com.core;

import java.time.LocalDate;

public class Movie implements Comparable<Movie> {

	private int id;
	private String name;
	private double ratings;
	private boolean inCinemas;
	private LocalDate releaseDate;
	private MovieType type;

	public Movie(int id, String name, double ratings, boolean inCinemas, LocalDate releaseDate, MovieType type) {

		this.id = id;
		this.name = name;
		this.ratings = ratings;
		this.inCinemas = inCinemas;
		this.releaseDate = releaseDate;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", ratings=" + ratings + ", inCinemas=" + inCinemas
				+ ", releaseDate=" + releaseDate + ", type=" + type + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRatings() {
		return ratings;
	}

	public void setRatings(double ratings) {
		this.ratings = ratings;
	}

	public boolean isInCinemas() {
		return inCinemas;
	}

	public void setInCinemas(boolean inCinemas) {
		this.inCinemas = inCinemas;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public MovieType getType() {
		return type;
	}

	public void setType(MovieType type) {
		this.type = type;
	}

	@Override
	public int compareTo(Movie o) {
		
		return o.name.compareTo(this.name);
	}

}

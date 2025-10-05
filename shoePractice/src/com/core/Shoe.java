package com.core;

public class Shoe implements Comparable<Shoe> {

	private static int idGenerator;
	private int shoeId;
	private String name;
	private String brand;
	private int rating;
	private double price;
	private boolean isAvailableInGallery;
	private ShoeType type;

	public Shoe( String name, String brand, int rating, double price, boolean isAvailableInGallery,
			ShoeType type) {

		this.shoeId = ++idGenerator;
		this.name = name;
		this.brand = brand;
		this.rating = rating;
		this.price = price;
		this.isAvailableInGallery = isAvailableInGallery;
		this.type = type;
	}

	public int getShoeId() {
		return shoeId;
	}

	public String getName() {
		return name;
	}

	public String getBrand() {
		return brand;
	}

	public int getRating() {
		return rating;
	}

	public double getPrice() {
		return price;
	}

	public boolean isAvailableInGallery() {
		return isAvailableInGallery;
	}

	public ShoeType getType() {
		return type;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		return "Shoe [shoeId=" + shoeId + ", name=" + name + ", brand=" + brand + ", rating=" + rating + ", price="
				+ price + ", isAvailableInGallery=" + isAvailableInGallery + ", type=" + type + " ]" ;
	}
	
	

	@Override
	public int compareTo(Shoe o) {
		
		return Double.compare(o.price, this.price);
	}


}

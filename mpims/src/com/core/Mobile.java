package com.core;

public class Mobile implements Comparable<Mobile> {

	private static int idGenerator = 100;

	private int PhoneId;
	private String modelName;
	private String brand;
	private double price;
	private int ratings;
	private boolean inStock;
	private PhoneType type;

	public Mobile(String modelName, String brand, double price, int ratings, boolean inStock, PhoneType type) {

		this.PhoneId = ++idGenerator;
		this.modelName = modelName;
		this.brand = brand;
		this.price = price;
		this.ratings = ratings;
		this.inStock = inStock;
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public static int getIdGenerator() {
		return idGenerator;
	}

	public int getPhoneId() {
		return PhoneId;
	}

	public String getModelName() {
		return modelName;
	}

	public String getBrand() {
		return brand;
	}

	public int getRatings() {
		return ratings;
	}

	public boolean isInStock() {
		return inStock;
	}

	public PhoneType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Mobile [PhoneId=" + PhoneId + ", modelName=" + modelName + ", brand=" + brand + ", price=" + price
				+ ", ratings=" + ratings + ", inStock=" + inStock + ", type=" + type + "]";
	}

	@Override
	public int compareTo(Mobile o) {
		return Double.compare(this.price, o.price);
	}

}

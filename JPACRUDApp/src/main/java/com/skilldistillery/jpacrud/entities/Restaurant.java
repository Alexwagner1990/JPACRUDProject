package com.skilldistillery.jpacrud.entities;

public class Restaurant {

	private int id;
	private Price price;
	private String category;
	private Distance distance;
	private String address;
	private String logo;
	private Integer favorite;
	
	public Restaurant() {
		
	}
	public Restaurant(int id, Price price, String category, Distance distance, String address, String logo) {
		super();
		this.id = id;
		this.price = price;
		this.category = category;
		this.distance = distance;
		this.address = address;
		this.logo = logo;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	public Integer getFavorite() {
		return favorite;
	}
	public void setFavorite(Integer favorite) {
		this.favorite = favorite;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Distance getDistance() {
		return distance;
	}
	public void setDistance(Distance distance) {
		this.distance = distance;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public int getId() {
		return id;
	}
	
	
}

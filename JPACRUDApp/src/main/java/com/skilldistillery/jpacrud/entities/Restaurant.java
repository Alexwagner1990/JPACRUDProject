package com.skilldistillery.jpacrud.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Enumerated(EnumType.STRING)
	private Price price;
	private String category;
	@Enumerated(EnumType.STRING)
	private Distance distance;
	private String address;
	private String logo;
	private Integer favorite;
//	@Column(name="user_id")
//	private Integer userId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Restaurant() {
		
	}
	
	public Restaurant(String name, User user, Integer favorite) {
		this.name = name;
		this.user = user;
		this.favorite = favorite;
	}
	
	public Restaurant(String name) {
		this.name=name;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
//	public Integer getUserId() {
//		return userId;
//	}
//	public void setUserId(Integer userId) {
//		this.userId = userId;
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}

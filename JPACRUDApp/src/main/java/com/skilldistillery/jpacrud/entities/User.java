package com.skilldistillery.jpacrud.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<Restaurant> restaurants;
	
	public User() {
		
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
	public void addRestaurants(Restaurant restaurant) {
		if(restaurants == null) {
			restaurants = new ArrayList<>();
		}
		if(!restaurants.contains(restaurant)) {
			restaurants.add(restaurant);
			if(restaurant.getUser() != null) {
				restaurant.getUser().getRestaurants().remove(restaurant);
			}
		}
		restaurant.setUser(this);
	}
	
	public void removeRestaurants(Restaurant restaurant) {
		restaurant.setUser(null);
		if(restaurants != null) {
			restaurants.remove(restaurant);
		}
	}
	
//	public void addRestaurantToUser(Restaurant restaurant) {
//		if(restaurants==null) {
//			restaurants=new ArrayList<>();
//		}
//		if(!restaurants.contains(restaurant)) {
//			restaurants.add(restaurant);
//			if(restaurant.getUser() != null) {
//				restaurant.getUser().removeRestaurantFromUser(restaurant);
//			}
//		}
//		restaurant.setUser(this);
//	}
//	
//	public void removeRestaurantFromUser(Restaurant restaurant) {
//		
//	}
	
	
	
}

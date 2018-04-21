package com.skilldistillery.jpacrud.data;

import java.util.List;

import com.skilldistillery.jpacrud.entities.Category;
import com.skilldistillery.jpacrud.entities.Distance;
import com.skilldistillery.jpacrud.entities.Price;
import com.skilldistillery.jpacrud.entities.Restaurant;

public interface RestaurantDAO {
	
	public List<Restaurant> allRestaurants();
	public List<Restaurant> allRestaurantsOfType(Restaurant rest);
	public boolean addRestaurants(List<Restaurant> restaurants);
	public boolean addRestaurant(Restaurant restaurants);
	public boolean deleteRestaurant(int id);
	public Restaurant updateRestaurant(Restaurant restaurant, int id);
	public Restaurant pickRandomRestaurant();
	public List<Restaurant> viewRestaurantInformation(String restName);
	public Restaurant findRestaurantById(int id);
}

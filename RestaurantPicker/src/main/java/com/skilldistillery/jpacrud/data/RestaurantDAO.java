package com.skilldistillery.jpacrud.data;

import java.util.List;

import com.skilldistillery.jpacrud.entities.Category;
import com.skilldistillery.jpacrud.entities.Distance;
import com.skilldistillery.jpacrud.entities.Price;
import com.skilldistillery.jpacrud.entities.Restaurant;

public interface RestaurantDAO {
	
	public List<Restaurant> allRestaurants();
	public List<Restaurant> allRestaurantsOfType(Price price, Category category, Distance distance, Integer favorite);
	public boolean addRestaurant(List<Restaurant> restaurants);
	public boolean deleteRestaurant(int id);
	public Restaurant updateRestaurant(Restaurant restaurant);
	public Restaurant pickRandomRestaurant();
	public Restaurant viewRestaurantInformation(String restName);
}

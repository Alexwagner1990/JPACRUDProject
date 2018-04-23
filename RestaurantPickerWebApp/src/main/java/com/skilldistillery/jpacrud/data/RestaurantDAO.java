package com.skilldistillery.jpacrud.data;

import java.util.List;

import com.skilldistillery.jpacrud.entities.Category;
import com.skilldistillery.jpacrud.entities.Distance;
import com.skilldistillery.jpacrud.entities.Price;
import com.skilldistillery.jpacrud.entities.Restaurant;

public interface RestaurantDAO {
	
	public List<Restaurant> allRestaurants();
	public List<Restaurant> allRestaurantsOfType(Restaurant rest);
	public boolean addManyRestaurants(String[] names);
	public boolean addRestaurant(Restaurant restaurants);
	public boolean deleteRestaurant(int id);
	public Restaurant updateRestaurant(Restaurant restaurant, int id);
	public Restaurant pickRandomRestaurant();
	public List<Restaurant> viewRestaurantInformation(String restName);
	public Restaurant findRestaurantById(int id);
	public List<Restaurant> getRestaurantsOfCategory(String category);
	public List<Restaurant> getRestaurantsOfPrice(String price);
	public List<Restaurant> getRestaurantsOfDistance(String distance);
	public Restaurant pickRandomRestaurantOfCategory(String category);
	public Restaurant pickRandomRestaurantOfPrice(String price);
	public Restaurant pickRandomRestaurantOfDistance(String distance);
	public Restaurant pickRandomFavoriteRestaurant();

}

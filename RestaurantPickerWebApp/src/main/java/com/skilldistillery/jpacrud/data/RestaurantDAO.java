package com.skilldistillery.jpacrud.data;

import java.util.List;

import com.skilldistillery.jpacrud.entities.Restaurant;
import com.skilldistillery.jpacrud.entities.User;

public interface RestaurantDAO {
	
	public List<Restaurant> allRestaurants(User user); 
	public boolean addManyRestaurants(String[] names, User user); 
	public boolean addRestaurant(Restaurant restaurants, User user); 
	public boolean deleteRestaurant(int id); //DONE DON'T NEED USER FOR METHOD
	public Restaurant updateRestaurant(Restaurant restaurant, int id, User user); 
	public Restaurant pickRandomRestaurant(User user); 
	public List<Restaurant> viewRestaurantInformation(String restName, User user); 
	public Restaurant findRestaurantById(int id); // DONE THINK THIS IS HELP METHOD DON'T NEED USER
	public List<Restaurant> getRestaurantsOfCategory(String category, User user); 
	public List<Restaurant> getRestaurantsOfPrice(String price, User user); 
	public List<Restaurant> getRestaurantsOfDistance(String distance, User user); 
	public Restaurant pickRandomRestaurantOfCategory(String category, User user); 
	public Restaurant pickRandomRestaurantOfPrice(String price, User user); 
	public Restaurant pickRandomRestaurantOfDistance(String distance, User user); 
	public Restaurant pickRandomFavoriteRestaurant(User user); 

}

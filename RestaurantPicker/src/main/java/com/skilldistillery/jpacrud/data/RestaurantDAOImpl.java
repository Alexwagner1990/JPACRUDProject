package com.skilldistillery.jpacrud.data;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.skilldistillery.jpacrud.entities.Category;
import com.skilldistillery.jpacrud.entities.Distance;
import com.skilldistillery.jpacrud.entities.Price;
import com.skilldistillery.jpacrud.entities.Restaurant;

@Transactional
@Component
public class RestaurantDAOImpl implements RestaurantDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Restaurant> allRestaurants() {
		String query = "Select r from Restaurant r";
		List<Restaurant>allRestaurants = em.createQuery(query, Restaurant.class).getResultList();
		return allRestaurants;
	}

	@Override
	public List<Restaurant> allRestaurantsOfType(Price price, Category category, Distance distance, Integer favorite) {
		String query = "select r from Restaurant r where price = ?, category = ?, distance = ?, favorite = ?";
		List<Restaurant> allRest = allRestaurants();
//		em.createStoredProcedureQuery(query);
		return null;
	}

	@Override
	public boolean addRestaurant(List<Restaurant> restaurants) {
		for (Restaurant restaurant : restaurants) {
			em.persist(restaurant);
		}
		em.flush();
		return false;
	}

	@Override
	public boolean deleteRestaurant(int id) {
		
		return false;
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant pickRandomRestaurant() {
		List<Restaurant> allRest = allRestaurants();
		Collections.shuffle(allRest);
		Restaurant picked = allRest.get(0);
		return picked;
	}

	@Override
	public Restaurant viewRestaurantInformation(String restName) {
		String queryString = "SELECT r FROM Restaurant r where r.name = ?";
		
		return null;
	}

}

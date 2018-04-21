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
		System.out.println("In method");
		String query = "Select r from Restaurant r";
		List<Restaurant> allRestaurants = em.createQuery(query, Restaurant.class).getResultList();
		return allRestaurants;
	}

	
	//NOT YET COMPLETED
	@Override
	public List<Restaurant> allRestaurantsOfType(Restaurant rest) {
		String query = "select r from Restaurant r where price = ?, category = ?, distance = ?, favorite = ?";
		List<Restaurant> allRest = allRestaurants();
		// em.createStoredProcedureQuery(query);
		return allRest;
	}

	@Override
	public boolean addRestaurants(List<Restaurant> restaurants) {
		try {
			for (Restaurant restaurant : restaurants) {
				em.persist(restaurant);
				em.flush();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addRestaurant(Restaurant restaurant) {
		try {
			em.persist(restaurant);
			em.flush();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteRestaurant(int id) {
		try {
			Restaurant rest = em.find(Restaurant.class, id);
			em.remove(rest);
			em.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant, int id) {
		Restaurant db = em.find(Restaurant.class, id);
		System.out.println(db);
		db.setAddress(restaurant.getAddress());
		db.setCategory(restaurant.getCategory());
		db.setDistance(restaurant.getDistance());
		db.setPrice(restaurant.getPrice());
		db.setLogo(restaurant.getLogo());
		db.setFavorite(restaurant.getFavorite());
		db.setUserId(restaurant.getUserId());
		em.persist(db);
		em.flush();
		System.out.println(db);
		return db;
	}

	@Override
	public Restaurant pickRandomRestaurant() {
		List<Restaurant> allRest = allRestaurants();
		Collections.shuffle(allRest);
		Restaurant picked = allRest.get(0);
		return picked;
	}

	@Override
	public List<Restaurant> viewRestaurantInformation(String restName) {
		String queryString = "SELECT r FROM Restaurant r where r.name = :name";
		List<Restaurant> search = em.createQuery(queryString, Restaurant.class).setParameter("name", restName).getResultList();
		return search;
	}

	@Override
	public Restaurant findRestaurantById(int id) {
		Restaurant restaurant = em.find(Restaurant.class, id);
		return restaurant;
	}

}

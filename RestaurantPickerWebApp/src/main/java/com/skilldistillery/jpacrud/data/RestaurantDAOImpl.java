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
	public boolean addManyRestaurants(String[] names) {
		try {
			Restaurant add = null;
			for (String name : names){
				add = new Restaurant(name);
				em.persist(add);
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


	@Override
	public List<Restaurant> getRestaurantsOfCategory(String category) {
		String query = "Select r from Restaurant r where r.category = :category";
		List<Restaurant> results = em.createQuery(query, Restaurant.class).setParameter("category", category).getResultList();
		return results;
	}


	@Override
	public List<Restaurant> getRestaurantsOfPrice(String price) {
		String query = "Select r from Restaurant r where r.price = :price";
		List<Restaurant> results = null;
		if(price.equals("CHEAP")) {
			results = em.createQuery(query, Restaurant.class).setParameter("price", Price.CHEAP).getResultList();	
		}
		if(price.equals("AVERAGE")) {
			results = em.createQuery(query, Restaurant.class).setParameter("price", Price.AVERAGE).getResultList();	
		}
		if(price.equals("PRICEY")) {
			results = em.createQuery(query, Restaurant.class).setParameter("price", Price.PRICEY).getResultList();	
		}
		if(price.equals("NONE")) {
			results = em.createQuery(query, Restaurant.class).setParameter("price", Price.NONE).getResultList();	
		}
		return results;
	}


	@Override
	public List<Restaurant> getRestaurantsOfDistance(String distance) {
		String query = "Select r from Restaurant r where r.distance = :distance";
		List<Restaurant> results = null;
		if(distance.equals("CLOSE")) {
			results = em.createQuery(query, Restaurant.class).setParameter("distance", Distance.CLOSE).getResultList();	
		}
		if(distance.equals("AVERAGE")) {
			results = em.createQuery(query, Restaurant.class).setParameter("distance", Distance.AVERAGE).getResultList();	
		}
		if(distance.equals("FAR")) {
			results = em.createQuery(query, Restaurant.class).setParameter("distance", Distance.FAR).getResultList();	
		}
		if(distance.equals("NONE")) {
			results = em.createQuery(query, Restaurant.class).setParameter("distance", Distance.NONE).getResultList();	
		}
		return results;
	}


	@Override
	public Restaurant pickRandomRestaurantOfCategory(String category) {
		String query = "Select r from Restaurant r where r.category = :category";
		List<Restaurant> list = em.createQuery(query, Restaurant.class).setParameter("category", category).getResultList();
		Collections.shuffle(list);
		Collections.shuffle(list);
		Restaurant chosen = list.get(0);
		return chosen;
	}


	@Override
	public Restaurant pickRandomRestaurantOfPrice(String price) {
		
		String query = "Select r from Restaurant r where r.price = :price";
		System.out.println("IN DAO");
		List<Restaurant> list = null;
		if(price.equals("NONE")) {
			list = em.createQuery(query, Restaurant.class).setParameter("price", Price.NONE).getResultList();	
		}
		if(price.equals("CHEAP")) {
			list = em.createQuery(query, Restaurant.class).setParameter("price", Price.CHEAP).getResultList();	
		}
		if(price.equals("AVERAGE")) {
			list = em.createQuery(query, Restaurant.class).setParameter("price", Price.AVERAGE).getResultList();	
		}
		if(price.equals("PRICEY")) {
			list = em.createQuery(query, Restaurant.class).setParameter("price", Price.PRICEY).getResultList();	
		}
		Collections.shuffle(list);
		Collections.shuffle(list);
		Restaurant chosen = list.get(0);
		return chosen;
	}


	@Override
	public Restaurant pickRandomRestaurantOfDistance(String distance) {
		String query = "Select r from Restaurant r where r.distance = :distance";
		List<Restaurant> list = null;
		if(distance.equals("NONE")) {
			list = em.createQuery(query, Restaurant.class).setParameter("distance", Distance.NONE).getResultList();
		}
		if(distance.equals("CLOSE")) {
			list = em.createQuery(query, Restaurant.class).setParameter("distance", Distance.CLOSE).getResultList();
		}
		if(distance.equals("AVERAGE")) {
			list = em.createQuery(query, Restaurant.class).setParameter("distance", Distance.AVERAGE).getResultList();
		}
		if(distance.equals("FAR")) {
			list = em.createQuery(query, Restaurant.class).setParameter("distance", Distance.FAR).getResultList();
		}
		Collections.shuffle(list);
		Collections.shuffle(list);
		Restaurant chosen = list.get(0);
		return chosen;
	}


	@Override
	public Restaurant pickRandomFavoriteRestaurant() {
		String query = "select r from Restaurant r where r.favorite=1";
		Restaurant pick = null;
		List<Restaurant> results = em.createQuery(query, Restaurant.class).getResultList();
		System.out.println(results);
		Collections.shuffle(results);
		if(results.size() != 0) {
		pick = results.get(0);
		}
		return pick;
	}
	
	

}

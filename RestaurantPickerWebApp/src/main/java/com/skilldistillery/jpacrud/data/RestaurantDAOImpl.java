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
import com.skilldistillery.jpacrud.entities.User;

@Transactional
@Component
public class RestaurantDAOImpl implements RestaurantDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Restaurant> allRestaurants(User user) {
		String query = "select r from Restaurant r join fetch r.user where r.user=:user";
		List<Restaurant> restaurantList = em.createQuery(query, Restaurant.class).setParameter("user", user).getResultList();
		return restaurantList;
	}

	@Override
	public boolean addManyRestaurants(String[] names, User user) {
		try {
			Restaurant add = null;
			for (String name : names) {
				add = new Restaurant(name);
				add.setUser(user);
				add.setFavorite(0);
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
	public boolean addRestaurant(Restaurant restaurant, User user) {
		try {
			restaurant.setUser(user);
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
	public Restaurant updateRestaurant(Restaurant restaurant, int id, User user) {
		Restaurant db = em.find(Restaurant.class, id);
		db.setName(restaurant.getName());
		db.setAddress(restaurant.getAddress());
		db.setCategory(restaurant.getCategory());
		db.setDistance(restaurant.getDistance());
		db.setPrice(restaurant.getPrice());
		db.setLogo(restaurant.getLogo());
		db.setFavorite(restaurant.getFavorite());
		db.setUser(user);
		em.persist(db);
		em.flush();
		return db;
	}

	@Override
	public Restaurant pickRandomRestaurant(User user) {
		List<Restaurant> allRest = allRestaurants(user);
		Collections.shuffle(allRest);
		Restaurant picked = null;
		if (allRest.size() > 0) {
			picked = allRest.get(0);
		}
		return picked;
	}

	@Override
	public List<Restaurant> viewRestaurantInformation(String restName, User user) {
		String queryString = "SELECT r FROM Restaurant r join fetch r.user where r.name like :name and r.user = :user";
		List<Restaurant> search = em.createQuery(queryString, Restaurant.class)
				.setParameter("name", "%" + restName + "%").setParameter("user", user).getResultList();
		return search;
	}

	@Override
	public Restaurant findRestaurantById(int id) {
		Restaurant restaurant = em.find(Restaurant.class, id);
		return restaurant;
	}

	@Override
	public List<Restaurant> getRestaurantsOfCategory(String category, User user) {
		String query = "Select r from Restaurant r join fetch r.user where r.category = :category and r.user= :user";
		List<Restaurant> results = em.createQuery(query, Restaurant.class).setParameter("category", category)
				.setParameter("user", user).getResultList();
		return results;
	}

	@Override
	public List<Restaurant> getRestaurantsOfPrice(String price, User user) {
		String query = "Select r from Restaurant r join fetch r.user where r.price = :price and r.user=:user";
		List<Restaurant> results = null;
		if (price.equals("CHEAP")) {
			results = em.createQuery(query, Restaurant.class).setParameter("price", Price.CHEAP)
					.setParameter("user", user).getResultList();
		}
		if (price.equals("AVERAGE")) {
			results = em.createQuery(query, Restaurant.class).setParameter("price", Price.AVERAGE)
					.setParameter("user", user).getResultList();
		}
		if (price.equals("PRICEY")) {
			results = em.createQuery(query, Restaurant.class).setParameter("price", Price.PRICEY)
					.setParameter("user", user).getResultList();
		}
		if (price.equals("NONE")) {
			results = em.createQuery(query, Restaurant.class).setParameter("price", Price.NONE)
					.setParameter("user", user).getResultList();
		}
		return results;
	}

	@Override
	public List<Restaurant> getRestaurantsOfDistance(String distance, User user) {
		String query = "Select r from Restaurant r join fetch r.user where r.distance = :distance and r.user = :user";
		List<Restaurant> results = null;
		if (distance.equals("CLOSE")) {
			results = em.createQuery(query, Restaurant.class).setParameter("distance", Distance.CLOSE)
					.setParameter("user", user).getResultList();
		}
		if (distance.equals("AVERAGE")) {
			results = em.createQuery(query, Restaurant.class).setParameter("distance", Distance.AVERAGE)
					.setParameter("user", user).getResultList();
		}
		if (distance.equals("FAR")) {
			results = em.createQuery(query, Restaurant.class).setParameter("distance", Distance.FAR)
					.setParameter("user", user).getResultList();
		}
		if (distance.equals("NONE")) {
			results = em.createQuery(query, Restaurant.class).setParameter("distance", Distance.NONE)
					.setParameter("user", user).getResultList();
		}
		return results;
	}

	@Override
	public Restaurant pickRandomRestaurantOfCategory(String category, User user) {
		String query = "Select r from Restaurant r join fetch r.user where r.category = :category and r.user = :user";
		List<Restaurant> list = em.createQuery(query, Restaurant.class).setParameter("category", category)
				.setParameter("user", user).getResultList();
		Collections.shuffle(list);
		Collections.shuffle(list);
		Restaurant chosen = list.get(0);
		return chosen;
	}

	@Override
	public Restaurant pickRandomRestaurantOfPrice(String price, User user) {

		String query = "Select r from Restaurant r join fetch r.user where r.price = :price and r.user = :user";
		System.out.println("IN DAO");
		List<Restaurant> list = null;
		if (price.equals("NONE")) {
			list = em.createQuery(query, Restaurant.class).setParameter("price", Price.NONE).setParameter("user", user)
					.getResultList();
		}
		if (price.equals("CHEAP")) {
			list = em.createQuery(query, Restaurant.class).setParameter("price", Price.CHEAP).setParameter("user", user)
					.getResultList();
		}
		if (price.equals("AVERAGE")) {
			list = em.createQuery(query, Restaurant.class).setParameter("price", Price.AVERAGE)
					.setParameter("user", user).getResultList();
		}
		if (price.equals("PRICEY")) {
			list = em.createQuery(query, Restaurant.class).setParameter("price", Price.PRICEY)
					.setParameter("user", user).getResultList();
		}
		Collections.shuffle(list);
		Collections.shuffle(list);
		Restaurant chosen = list.get(0);
		return chosen;
	}

	@Override
	public Restaurant pickRandomRestaurantOfDistance(String distance, User user) {
		String query = "Select r from Restaurant r join fetch r.user where r.distance = :distance and r.user = :user";
		List<Restaurant> list = null;
		if (distance.equals("NONE")) {
			list = em.createQuery(query, Restaurant.class).setParameter("distance", Distance.NONE)
					.setParameter("user", user).getResultList();
		}
		if (distance.equals("CLOSE")) {
			list = em.createQuery(query, Restaurant.class).setParameter("distance", Distance.CLOSE)
					.setParameter("user", user).getResultList();
		}
		if (distance.equals("AVERAGE")) {
			list = em.createQuery(query, Restaurant.class).setParameter("distance", Distance.AVERAGE)
					.setParameter("user", user).getResultList();
		}
		if (distance.equals("FAR")) {
			list = em.createQuery(query, Restaurant.class).setParameter("distance", Distance.FAR)
					.setParameter("user", user).getResultList();
		}
		Collections.shuffle(list);
		Collections.shuffle(list);
		Restaurant chosen = list.get(0);
		return chosen;
	}

	@Override
	public Restaurant pickRandomFavoriteRestaurant(User user) {
		String query = "select r from Restaurant r join fetch r.user where r.favorite=1 and r.user = :user";
		Restaurant pick = null;
		List<Restaurant> results = em.createQuery(query, Restaurant.class).setParameter("user", user).getResultList();
		Collections.shuffle(results);
		if (results.size() != 0) {
			pick = results.get(0);
		}
		return pick;
	}

}

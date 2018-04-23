package com.skilldistillery.jpacrud.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RestaurantTest {

	private EntityManagerFactory emf;
	private EntityManager em;
	private Restaurant restaurant;

	@BeforeEach
	void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("RestaurantPickerWebApp");
		em = emf.createEntityManager();
		restaurant = new Restaurant();
		restaurant.setAddress("TEST");
		restaurant.setCategory("TEST");
		restaurant.setDistance(Distance.AVERAGE);
		restaurant.setFavorite(0);
		restaurant.setLogo("TEST");
		restaurant.setUserId(0);
		restaurant.setName("TEST");
		restaurant.setPrice(Price.CHEAP);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		emf.close();
	}

	@Test
	@DisplayName("Restaurant Mapping")
	void test() {
		restaurant = em.find(Restaurant.class, 10);
		assertEquals("The Egg And I", restaurant.getName());
		assertEquals("Breakfast", restaurant.getCategory());
	}
	
	@Test
	@DisplayName("Restaurant Adding")
	void testAdd() {
		em.getTransaction().begin();
		em.persist(restaurant);
		em.flush();
		assertEquals(Price.CHEAP, restaurant.getPrice());
		em.getTransaction().rollback();
		
	}
	
	@Test
	@DisplayName("Restaurant Updating")
	void testUpdate() {
		em.getTransaction().begin();
		Restaurant rest = em.find(Restaurant.class, 1);
		rest.setName("SubwayTest");
		em.flush();
		Restaurant restUpdate = em.find(Restaurant.class, 1);
		assertEquals("SubwayTest", restUpdate.getName());
		em.getTransaction().rollback();
	}
	
	@Test
	@DisplayName("Restaurant Deleting")
	void testDelete() {
		em.getTransaction().begin();
		em.remove(em.find(Restaurant.class, 1));
		assertEquals(null, em.find(Restaurant.class, 1));
		em.getTransaction().rollback();
	}

}

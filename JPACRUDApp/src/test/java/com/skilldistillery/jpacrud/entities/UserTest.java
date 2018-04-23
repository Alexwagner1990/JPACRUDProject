package com.skilldistillery.jpacrud.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

	private EntityManagerFactory emf;
	private EntityManager em;
	private User user;
	
	@BeforeEach
	void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("RestaurantPickerWebApp");
		em = emf.createEntityManager();
		user = new User();
		user.setPassword("testing");
		user.setUsername("tester");
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		emf.close();
	}

	@Test
	@DisplayName("User Mapping")
	void test() {
		user = em.find(User.class, 2);
		assertEquals("test", user.getUsername());
		assertEquals("tester", user.getPassword());
	}
	
	@Test
	@DisplayName("User Adding")
	void testAdd() {
		String query = "select u from User u";
		em.getTransaction().begin();
		List<User> count = em.createQuery(query, User.class).getResultList();
		int size = count.size();
		em.persist(user);
		em.flush();
		count = em.createQuery(query, User.class).getResultList();
		int size2 = count.size();
		assertEquals(size, (size2 - 1));
		em.getTransaction().rollback();
		
	}
	
	@Test
	@DisplayName("User Updating")
	void testUpdate() {
		em.getTransaction().begin();
		user = em.find(User.class, 1);
		user.setUsername("Batman");
		em.flush();
		user = em.find(User.class, 1);
		assertEquals("Batman", user.getUsername());
		em.getTransaction().rollback();
	}
	
	@Test
	@DisplayName("User Deleting")
	void testDelete() {
		em.getTransaction().begin();
		user = em.find(User.class, 1);
		em.remove(user);
		em.flush();
		assertEquals(null, em.find(User.class, 1));
		em.getTransaction().rollback();
	}


}

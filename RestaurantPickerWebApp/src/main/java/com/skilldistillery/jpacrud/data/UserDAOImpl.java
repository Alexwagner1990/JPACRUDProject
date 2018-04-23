package com.skilldistillery.jpacrud.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.skilldistillery.jpacrud.entities.User;

@Transactional
@Component
public class UserDAOImpl implements UserDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Boolean checkIfUsernameIsUnique(String username) {
		String query = "select u from User u";
		List<User> allUsers = em.createQuery(query, User.class).getResultList();
		for (User user : allUsers) {
			if(username.equalsIgnoreCase(user.getUsername())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Boolean addUserToDatabase(String[] unpw) {
		try {
			User user = new User(unpw[0], unpw[1]);
			em.persist(user);
			em.flush();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public User checkUserLoginCredentials(String[] unpw) {
		String query = "select u from User u";
		List<User> userlist = em.createQuery(query, User.class).getResultList();
		for (User user : userlist) {
			if(unpw[0].equalsIgnoreCase(user.getUsername())) {
				if(unpw[1].equals(user.getPassword())) {
					return user;
				}
			}
		}
		return null;
	}

}

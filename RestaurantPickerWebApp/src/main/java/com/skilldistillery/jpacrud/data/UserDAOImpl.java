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

	@Override
	public User getUserById(int id) {
		User user = em.find(User.class, id);
		return user;
	}

	@Override
	public Boolean changeUserPassword(String[] updateinfo) {
		String query = "select u from User u";
		List<User> userlist = em.createQuery(query, User.class).getResultList();
		for (User user : userlist) {
			if(updateinfo[0].equalsIgnoreCase(user.getUsername())) {
				if(updateinfo[1].equals(user.getPassword())) {
					user.setPassword(updateinfo[2]);
//					em.persist(user);
					em.flush();
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Boolean deleteUser(String[] unpw) {
		String query = "select u from User u";
		List<User> userlist = em.createQuery(query, User.class).getResultList();
		for (User user : userlist) {
			if(unpw[0].equalsIgnoreCase(user.getUsername())) {
				if(unpw[1].equals(user.getPassword())) {
					em.remove(user);
					em.flush();
					return true;
				}
			}
		}
		return false;
	}

}

package com.skilldistillery.jpacrud.data;

import com.skilldistillery.jpacrud.entities.User;

public interface UserDAO {
	
	public Boolean checkIfUsernameIsUnique(String username);
	public Boolean addUserToDatabase(String[] unpw);
	public User checkUserLoginCredentials(String[] unpw);
	public User getUserById(int id);
	public Boolean changeUserPassword(String[]updateinfo);
	public Boolean deleteUser(String[] unpw);
}

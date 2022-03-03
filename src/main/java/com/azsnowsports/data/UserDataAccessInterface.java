package com.azsnowsports.data;

import com.azsnowsports.model.UserModel;

public interface UserDataAccessInterface <T>{
	/**
	 * Method used to find a user by their username
	 * @param username The username being searched
	 * @return Returns the user if found
	 */
	public UserModel findByUsername(T username);
	public UserModel createUser(T newUser);
	public boolean login(T user);
}

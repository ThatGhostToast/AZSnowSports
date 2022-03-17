package com.azsnowsports.data;

import com.azsnowsports.model.UserModel;

/**
 * @author Zac Almas & Austin Driver
 *
 * Interface used for the user data access
 */
public interface UserDataAccessInterface <T>{
	/**
	 * Method used to find a user by their username
	 * @param username The username being searched
	 * @return Returns the user if found
	 */
	public UserModel findByUsername(T username);
	
	/**
	 * Method used to create a new user
	 * @param newUser user being added into the database
	 * @return Returns if added successfully 
	 */
	public UserModel createUser(T newUser);
	/**
	 * Method used to check if the user exists and log them in
	 * @param user Data of the user being checked
	 * @return Returns if the user exists or not
	 */
	public boolean login(T user);
	/**
	 * Method used to check if the user is an Admin
	 * @param user User being checked
	 * @return Returns if the user is an Admin or not
	 */
	public boolean isAdmin(T user);
	
}

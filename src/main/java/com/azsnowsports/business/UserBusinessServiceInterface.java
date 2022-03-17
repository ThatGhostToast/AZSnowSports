package com.azsnowsports.business;

import com.azsnowsports.model.LoginModel;
import com.azsnowsports.model.UserModel;

/**
 * @author Zac Almas & Austin Driver
 *
 * Interface used for the user business service
 */
public interface UserBusinessServiceInterface {
	/**
	 * Method used to get the current user
	 * @return returns this.user
	 */
	public UserModel getUser();
	/**
	 * Method used to set the current user
	 * @param user User being set
	 */
	public void setUser(UserModel user);
	/**
	 * Method used to check if the user exists in the database by checking their username and password
	 * @param user User data pulled from the login form
	 * @return Returns if the user exists or not
	 */
	public boolean checkForUser(LoginModel user);
	/**
	 * Method used to create a user in the database
	 * @param newUser User that's going to be added into the database
	 * @return returns the current user
	 */
	public UserModel createUser(UserModel newUser);
	/**
	 * Method used at login to sign in the user
	 * @param user User being logged in 
	 */
	public void loginToUser(LoginModel user);
	
	/**
	 * Method used to get a user from the database
	 * @param user User we're looking for
	 * @return returns the user
	 */
	public UserModel getUserByUsername(UserModel user);
}

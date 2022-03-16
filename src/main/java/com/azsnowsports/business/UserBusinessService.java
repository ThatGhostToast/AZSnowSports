package com.azsnowsports.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.azsnowsports.data.UserDataAccessInterface;
import com.azsnowsports.model.LoginModel;
import com.azsnowsports.model.UserModel;

@SuppressWarnings({"rawtypes", "unchecked"})
public class UserBusinessService implements UserBusinessServiceInterface{
	/**
	 * Current user
	 */
	private UserModel user;
	
	/**
	 * Private attribute used to access our data access layer
	 */
	@Autowired
	private UserDataAccessInterface service;
	
	@Override
	public UserModel getUser() {
		//return the current user
		return this.user;
	}
	
	@Override
	public void setUser(UserModel user) {
		//Set the current user
		this.user = new UserModel(user.getFirstName(), user.getLastName(), user.getEmail(), user.getAddress(), user.getPhoneNumber(), user.getUsername(), user.getPassword());
	}
	
	@Override
	public boolean checkForUser(LoginModel login)
	{
		//Change the loginModel into a user model
		UserModel user = new UserModel(login);
		//calling the data access layer to check for the user and returning it's response
		return (service.login(user));
	}
	
	@Override
	public UserModel createUser(UserModel newUser) {
		//Sets the current user to the new user
		setUser(newUser);
		//Calls the data access layer to create a user
		service.createUser(newUser);
		//returns the current user
		return getUser();
	}
	
	@Override
	public void loginToUser(LoginModel user) {
		//Changes login model to user model
		UserModel userToSearch = new UserModel(user);
		//Setting the user to the user found in the database
		setUser(service.findByUsername(userToSearch));
	}
	
}

package com.azsnowsports.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.azsnowsports.data.UserDataAccessInterface;
import com.azsnowsports.model.LoginModel;
import com.azsnowsports.model.UserModel;

@SuppressWarnings({"rawtypes", "unchecked"})
public class UserBusinessService implements UserBusinessServiceInterface{
	private UserModel user;
	
	@Autowired
	private UserDataAccessInterface service;
	
	@Override
	public UserModel getUser() {
		return this.user;
	}
	
	@Override
	public void setUser(UserModel user) {
		this.user = new UserModel(user.getFirstName(), user.getLastName(), user.getEmail(), user.getAddress(), user.getPhoneNumber(), user.getUsername(), user.getPassword());
		
	}
	
	@Override
	public boolean checkForUser(LoginModel login)
	{
		UserModel user = new UserModel(login);
		return (service.login(user));
	}
	
	@Override
	public UserModel createUser(UserModel newUser) {
		setUser(newUser);
		service.createUser(newUser);
		return getUser();
	}
	
	@Override
	public void loginToUser(LoginModel user) {
		UserModel userToSearch = new UserModel(user);
		setUser(service.findByUsername(userToSearch));
	}
	
}

package com.azsnowsports.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.azsnowsports.data.UserDataAccessInterface;
import com.azsnowsports.data.UserDataService;
import com.azsnowsports.model.LoginModel;
import com.azsnowsports.model.UserModel;

/**
 * @author Zac Almas and Austin Driver
 *
 * Business service used for the Users
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Service
public class UserBusinessService implements UserBusinessServiceInterface, UserDetailsService{
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

	@Override
	public UserModel getUserByUsername(UserModel user) {
		return service.findByUsername(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel usrSearch = new UserModel(username);
		UserDataService.currentUserUsername = username;
		
		//Getting the user from the database
		UserModel user = service.findByUsername(usrSearch);
		
		//If the user was found they will be granted user authority
		if (user != null)
		{
			//Add the user to the list of authorities
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			//Return the user
			return new User(user.getUsername(), user.getPassword(), authorities);
		} else {
			//If the user was not found this exception throws
			throw new UsernameNotFoundException("Username was not found");
		}
	}
	
}

package com.azsnowsports.business;

import com.azsnowsports.model.LoginModel;
import com.azsnowsports.model.UserModel;

public interface UserBusinessServiceInterface {
	public UserModel getUser();
	public void setUser(UserModel user);
	public boolean checkForUser(LoginModel user);
	public UserModel createUser(UserModel newUser);
	public void loginToUser(LoginModel user);
}

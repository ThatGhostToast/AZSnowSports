package com.azsnowsports.business;

import com.azsnowsports.model.UserModel;

public class UserBusinessService implements UserBusinessServiceInterface{
	private UserModel user = new UserModel("FirstName", "LastName", "email@email.com", "1234 Street Street", 555555, "Username", "Password");
	
	@Override
	public UserModel getUser() {
		return user;
	}
	
	public void setUser(String fName, String lName, String email, String addrs, int pn, String uName, String pWord) {
		user = new UserModel(fName, lName, email, addrs, pn, uName, pWord);
	}

	@Override
	public void setUser(String fName, String lName, String email, String addrs, long l, String uName, String pWord) {
		// TODO Auto-generated method stub
		
	}
	
}

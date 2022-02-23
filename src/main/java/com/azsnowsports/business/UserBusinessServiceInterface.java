package com.azsnowsports.business;

import com.azsnowsports.model.UserModel;

public interface UserBusinessServiceInterface {
	public UserModel getUser();
	public void setUser(String fName, String lName, String email, String addrs, long l, String uName, String pWord);
}

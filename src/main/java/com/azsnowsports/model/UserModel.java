package com.azsnowsports.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserModel {
	/**
	 * The user's first name
	 */
	@NotNull(message="FirstName is a required field.")
	@Size(min = 1, max = 32, message="First Name must be between 1 and 32 characters.")
	private String firstName;
	/**
	 * The user's last name
	 */
	@NotNull(message="Last name is a required field.")
	@Size(min = 1, max = 32, message="Last name must be between 1 and 32 characters.")
	private String lastName;
	/**
	 * The user's email
	 */
	@NotNull(message="EMail is a required field.")
	private String email;
	/**
	 * The user's address
	 */
	@NotNull(message="Address is a required field.")
	private String address;
	/**
	 * The user's phone number
	 */
	@NotNull(message="Phone Number is a required field.")
	private long phoneNumber;
	/**
	 * The user's username
	 */
	@NotNull(message="Username is a required field.")
	@Size(min = 1, max = 32, message="Username must be between 1 and 32 characters.")
	private String username;
	/**
	 * The user's password
	 */
	@NotNull(message="Password is a required field.")
	@Size(min = 1, max = 32, message="Password must be between 1 and 32 characters.")
	private String password;
	
	/**
	 * Constructor
	 * 
	 * @param firstNameVal The first name of the user
	 * @param lastNameVal The last name of the user
	 * @param emailVal The email of the user
	 * @param addressVal The address of the user
	 * @param phoneNumber The phone number of the user
	 * @param usernameVal The username for the user
	 * @param passwordVal The password for the user
	 */
	public UserModel(String firstNameVal, String lastNameVal, String emailVal, String addressVal, 
			long phoneNumberVal, String usernameVal, String passwordVal)
	{
		this.firstName = firstNameVal;
		this.lastName = lastNameVal;
		this.email = emailVal;
		this.address = addressVal;
		this.phoneNumber = phoneNumberVal;
		this.username = usernameVal;
		this.password = passwordVal;
	}
	
	public UserModel()
	{
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.address = "";
		this.phoneNumber = 0;
		this.username = "";
		this.password = "";
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the phoneNumber
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}

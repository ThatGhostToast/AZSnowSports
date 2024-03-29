package com.azsnowsports.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.azsnowsports.business.UserBusinessServiceInterface;
import com.azsnowsports.model.UserModel;

/**
 * @author Zac Almas and Austin Driver
 * 
 * Controller used for registration pages
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
	/**
	 * Private autowired attribute to access the user business service
	 */
	@Autowired
	private UserBusinessServiceInterface service;
	
	/**
	 * Private autowired attribute to use the password encoder to encode the users password
	 */
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * Method used for displaying the register page
	 * 
	 * @param model Thymeleaf model
	 * @return Returns the register form
	 */
	@GetMapping("/")
	public String display(Model model)
	{
		// Display the register form view
		model.addAttribute("title", "Register Form");
		//Creating a new user model to be used at registration
		model.addAttribute("userModel", new UserModel());
		//Return the registration view
		return "register";
	}
	
	/**
	 * Method used to register the user
	 * 
	 * @param userModel User thats being registered
	 * @param bindingResult Binding result
	 * @param model Thymeleaf model
	 * @return Returns the register success page if successful or the form again if there were errors
	 */
	@PostMapping("/doRegister")
	public String doRegister(@Valid UserModel userModel, BindingResult bindingResult, Model model)
	{
		//Check for validation errors
		if (bindingResult.hasErrors())
		{
			//If there are errors return the register view
			model.addAttribute("title", "Register Form");
			return "register";
		}
		
		userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
		
		//Creating the user in the user business service
		service.createUser(userModel);
		//Return success screen
		return "registerSuccess";
	}
}

package com.azsnowsports.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.azsnowsports.business.UserBusinessServiceInterface;
import com.azsnowsports.model.UserModel;

/**
 * @author Zac Almas & Austin Driver
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
		//Creating the user in the user business service
		service.createUser(userModel);
		//Return success screen
		return "registerSuccess";
	}
}

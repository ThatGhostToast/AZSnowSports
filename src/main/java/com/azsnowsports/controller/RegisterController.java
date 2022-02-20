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
	@Autowired
	private UserBusinessServiceInterface service;
	
	@GetMapping("/")
	public String display(Model model)
	{
		// Display the login form view
		model.addAttribute("title", "Register Form");
		model.addAttribute("userModel", new UserModel());
		return "register";
	}
	
	@PostMapping("/doRegister")
	public String doRegister(@Valid UserModel userModel, BindingResult bindingResult, Model model)
	{
		//Check for validation errors
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Register Form");
			return "register";
		}
		service.setUser(userModel.getFirstName(), userModel.getLastName(), userModel.getEmail(), userModel.getAddress(), userModel.getPhoneNumber(), userModel.getUsername(), userModel.getPassword());
		return "registerSuccess";
	}
}

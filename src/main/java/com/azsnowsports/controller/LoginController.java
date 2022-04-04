package com.azsnowsports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.azsnowsports.model.LoginModel;

/**
 * @author Zac Almas and Austin Driver
 *
 * Controller used for login pages
 */
@Controller
public class LoginController {
	/**
	 * Method used for displaying the login form
	 * 
	 * @param model Thymeleaf model
	 * @return Returns the login form
	 */
	//@GetMapping("/")
	@RequestMapping("/login")
	public String display(Model model)
	{
		// Display the login form view
		model.addAttribute("title", "Login Form");
		// Creating a new login model to use
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
	

}

package com.azsnowsports.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.azsnowsports.business.BlogBusinessServiceInterface;
import com.azsnowsports.business.UserBusinessServiceInterface;
import com.azsnowsports.model.LoginModel;

/**
 * @author Zac Almas & Austin Driver
 *
 * Controller used for login pages
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	/**
	 * Private autowired attribute to access the user business service
	 */
	@Autowired
	private UserBusinessServiceInterface service;
	/**
	 * Private autowired attribute to access the blog business service
	 */
	@Autowired
	private BlogBusinessServiceInterface bservice;
	
	@GetMapping("/")
	public String display(Model model)
	{
		// Display the login form view
		model.addAttribute("title", "Login Form");
		// Creating a new login model to use
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model, RedirectAttributes redirAttrs)
	{
		//Check for validation errors
		if (bindingResult.hasErrors())
		{
			//If there are errors the program will not proceed
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		// authentication
		if (service.checkForUser(loginModel))
		{
			//If the user was found in the database
			//Using user service to login the user 
			service.loginToUser(loginModel);
			//Getting all of the blogs to be displayed
			model.addAttribute("blog", bservice.getAllBlogs());
			//Getting the user that was just logged in
			model.addAttribute("user", service.getUser());
			//Return the timeline view
			return "timeline";
		} else {
			//If the user was not authenticated then the program will not continue
			return "login";	
		}
		
	}
}

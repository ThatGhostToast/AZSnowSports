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
	@Autowired
	private UserBusinessServiceInterface service;
	@Autowired
	private BlogBusinessServiceInterface bservice;
	
	@GetMapping("/")
	public String display(Model model)
	{
		// Display the login form view
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model, RedirectAttributes redirAttrs)
	{
		//Check for validation errors
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		// authentication
		if (service.checkForUser(loginModel))
		{
			service.loginToUser(loginModel);
			model.addAttribute("blog", bservice.getAllBlogs());
			model.addAttribute("user", service.getUser());
			return "timeline";
		} else {
			return "login";	
		}
		
	}
}

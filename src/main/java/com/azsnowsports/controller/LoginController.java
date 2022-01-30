package com.azsnowsports.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.azsnowsports.model.LoginModel;

@Controller
@RequestMapping("/login")
public class LoginController {
	
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
		
		//Temporary authentication
		if (loginModel.getUsername().equals("Username") && loginModel.getPassword().equals("Password"))
		{
			return "loginSuccess";
		} else {
			return "login";	
		}
		
	}
}

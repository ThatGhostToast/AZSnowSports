package com.azsnowsports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.azsnowsports.model.UserModel;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@GetMapping("/")
	public String display(Model model)
	{
		// Display the login form view
		model.addAttribute("title", "Register Form");
		return "register";
	}
	
	@PostMapping("/doRegister")
	public String doRegister(UserModel userModel)
	{
		
		return "registerSuccess";
	}
}

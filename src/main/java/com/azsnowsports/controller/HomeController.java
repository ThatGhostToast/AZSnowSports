package com.azsnowsports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Zac Almas & Austin Driver
 * 
 *	Controller is used for the main screens of the application.
 */
@Controller
@RequestMapping("/")
public class HomeController {
	@GetMapping("/")
	public String printHello()
	{
		//Returns the home page
		return "home";
	}
}

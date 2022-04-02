package com.azsnowsports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Zac Almas and Austin Driver
 * 
 *	Controller is used for the main screens of the application.
 */
@Controller
@RequestMapping("/")
public class HomeController {
	/**
	 * Method used to show the home page
	 * 
	 * @return Returns the home page
	 */
	@GetMapping("/")
	public String printHello()
	{
		//Returns the home page
		return "home";
	}
}

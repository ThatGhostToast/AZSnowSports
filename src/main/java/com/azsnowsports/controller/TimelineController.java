package com.azsnowsports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.azsnowsports.business.BlogBusinessService;
import com.azsnowsports.business.UserBusinessService;
import com.azsnowsports.data.UserDataService;
import com.azsnowsports.model.UserModel;

/**
 * @author Zac Almas and Austin Driver
 * 
 *	Controller is used for the timeline of the application.
 */
@Controller
@RequestMapping("/timeline")
public class TimelineController {
	
	/**
	 * Private autowired attribute to access the blog business service
	 */
	@Autowired
	private BlogBusinessService service;
	
	/**
	 * Private autowired attribute to access the user business service
	 */
	@Autowired
	private UserBusinessService uservice;

	/**
	 * Method used for displaying the timeline
	 * 
	 * @param usrModel User that's signed in
	 * @param model Thymeleaf model
	 * @return Returns the timeline page
	 */
	@GetMapping("/")
	public ModelAndView display(UserModel usrModel, Model model) {
		//Create a model and view for our timeline 
		ModelAndView mav = new ModelAndView("timeline");
		//Adding a user model as an object to be used
		mav.addObject("user", uservice.getUserByUsername(new UserModel(UserDataService.currentUserUsername)));
		//Adding a users role to be used
		mav.addObject("role", uservice.getUserRole(new UserModel(UserDataService.currentUserUsername)));
		//Adding all the blogs as objects to be used
		mav.addObject("blog", service.getAllBlogs());
		//Return the model and view
		return mav;
	}
}
